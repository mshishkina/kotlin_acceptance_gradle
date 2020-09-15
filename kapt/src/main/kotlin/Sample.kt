package kapt

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Sample(
    val value: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0)
