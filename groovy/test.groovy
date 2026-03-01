import java.time.LocalDate
import java.util.List
import java.util.Map

class TestEditor {

    static final String APP_NAME = "demo-app"

    static void main(String[] args) {
        def list = [100000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 3, 4, 5]

        if (true) {
            println "App: ${APP_NAME}"
        }

        def result = list
                .findAll { it % 2 == 0 }
                .collect { it * 2 }
                .join(",")

        println("Result: " + result)

        def user = [name: "Alex",
                    age : 30,
                    tags: ["dev", "ci", "groovy"]]

        printUser(user,
                LocalDate.now(),
                [retries: 3,
                 timeout: 5000,
                 flags  : [fast: true,
                           safe: false]])

        doWork(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    static void printUser(Map user, LocalDate date, Map options) {
        if (user != null) {
            println "User: ${user.name}"
            println "Date: ${date}"
            println "Options: ${options}"
        } else {
            println 'No user'
        }
    }

    static def doWork(int ... values) {
        values.each { v ->
            if (v > 5) {
                println "Big: ${v}"
            } else {
                println 'Small: ' + v
            }
        }
    }
}
