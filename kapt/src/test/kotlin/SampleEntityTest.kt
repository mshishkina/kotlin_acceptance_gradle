package kapt

import com.mysema.query.jpa.impl.JPAQuery
import com.mysema.query.types.path.EntityPathBase
import com.mysema.query.types.path.StringPath
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import kotlin.test.Test
import kotlin.test.assertEquals

class SampleEntityTest {
    @Test fun testPersistence() {
        val sample = bringSampleEntity()

        Persistence.createEntityManagerFactory("unit").use { emf ->
            emf.createEntityManager().use { entityManager ->
                val transaction = entityManager.transaction
                transaction.begin()
                with (entityManager) {
                    persist(Sample("apple"))
                    persist(Sample("peach"))
                    persist(Sample("plum"))
                    flush()
                }
                transaction.commit()

                val query = JPAQuery(entityManager)

                val phValues = query.from(sample)
                    .where(bringValue(sample).like("p%h"))
                    .groupBy(bringValue(sample))
                    .list(bringValue(sample))

                assertEquals("peach", phValues.first())
            }
        }
    }
}

fun bringSampleEntity(): EntityPathBase<Sample> {
    val clazz = Class.forName("kapt.QSample")
    val field = clazz.getDeclaredField("sample")
    @Suppress("UNCHECKED_CAST")
    val result = field.get(null) as EntityPathBase<Sample>
    return result
}

fun bringValue(p: EntityPathBase<Sample>): StringPath {
    val clazz = Class.forName("kapt.QSample")
    val field = clazz.getDeclaredField("value")
    val result = field.get(p) as StringPath
    return result
}

inline fun <T> EntityManagerFactory.use(f: (EntityManagerFactory) -> T) = try { f(this) } finally { close() }
inline fun <T> EntityManager.use(f: (EntityManager) -> T) = try { f(this) } finally { close() }
