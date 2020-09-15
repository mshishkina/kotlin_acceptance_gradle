### Kotlin Gradle support.

Typically this test is performed with **every tested IDEA version. Studio is skipped**.

**Gradle**: we test 2 versions: 
- *the oldest supported* version (currently 4.9),
- *last released* version.

Test one IDE version with one Gradle version and another one with another. You don't need to download Gradle, just use default wrapper in test projects.

**JDK** to use. Since Kapt fails with recent JDKs: [KT-24311](https://youtrack.jetbrains.com/issue/KT-24311), we have to test the Gradle section with JDK 8. 

**Before starting**, edit `acceptance-gradle/gradle.properties`:
- Set `kotlin_version` property to tested Kotlin version.
- Set `dokka_version` to latest release
- Set tested Gradle version in `acceptance-gradle/gradle/wrapper/gradle-wrapper.properties`.
	**NB**: to make this setting effective, the IDE should set the following option in created project: *Settings / ... / Gradle / Use default gradle wrapper = Yes*. So:
	- Check this option's value in the project import wizard (if any), and in resulted project.
	- To verify the effect you may run `help` task from Gradle tool window.

**Testing:**

- **Import project**:
    - In the IDE import `acceptance-gradle/build.gradle.kts` as new IDE project. Resulted project will have acceptance-gradle directory as the root. While importing make sure the setting "*Create separate module per source set*" is On (it's by default, at least in IDEA 2017.2).
    - Check *Gradle tool* window for the absence of errors.
    - Check *Kotlin lib* items under *Project tool window / External Libraries* node.
    - Check *Project Structure / Facet*: 
		- *Gradle modules* referred from `acceptance-gradle/settings.gradle.kts` should produce by one IDE module for each source root (with suffixes `_main` and `_test` and the module *kotlin-java* provides 3 source roots).
		- *Kotlin facets* are created --- by one facet for each created module
		- *dokka_main* and *dokka_test*: check `target version = 1.6` and both language and api versions are `1.3`
		- *kotlin-java_main*, *kotlin-java_deploy* and *kotlin-java_test*: check `target version = 1.8`, both language and api versions are `1.3`
		- *kotlin-plugins_main* and *kotlin-plugins_test*: check compiler plugins page for options for `org.jetbrains.kotlin.allopen` and `org.jetbrains.kotlin.noarg` plugins: one annotation should be specifed for each plugin.
		- *kotlin-pure*: check language and api versions are `1.2`, `coroutines = Enabled with warning`
		- *kapt*: don't check anything
- **JPS compiler and runner**:
	- Make sure *Settings / ... / Gradle / Runner / Delegate to Gradle = No*.
	- Do *main menu / Build / Rebuild Project*.
	- Open tests.kt file
      - Click the gutter `run` for the entire class `TestSource` in the editor.
      - Click the gutter `run` for the test function `testFromDeploy()` in the editor:
         - test results for only one test should be displayed.
- **Kotlin Gradle plugin**, including incremental compilation:
All tasks should be run from the *Gradle tool window*. Check the Gradle output in the *Run* tool window.
	- Execute `acceptance-gradle / build / clean` task.
	- Execute `acceptance-gradle / verification / test` task: should success.
	- Edit `tests.kt` from *kotlin-java* module: 
		- change expected value in the function `testFromDeploy` to make the test fail.
	- Execute `kotlin-java / test` task: see the fail.
	- Edit `kotlinSrc.kt`: 
		- change function `editMe()` to make the test pass.
	- Execute `acceptance-gradle / verification / test` task: should success.
- **Dokka**:
	- Execute `dokka / documentation / dokka`, `dokkajavadoc` tasks: should produce reasonable documentation under *acceptance-gradle/dokka/build/dokka* and *acceptance-gradle/dokka/build/dokkaJavadoc* correspondingly.
- **Cleanup**:
	- Execute `acceptance-gradle / build / clean` task.