import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun suma(): Int {
    println("Ingresa el primer número:")
    val numero1 = readln().toInt()

    println("Ingresa el segundo número:")
    val numero2 = readln().toInt()

    println("Ingresa el tercer número:")
    val numero3 = readln().toInt()

    return numero1 + numero2 + numero3
}

fun ingresarNombre(): String {
    println("Ingresa tu nombre completo:")
    return readln()
}

// Función para calcular el tiempo vivido
fun vividos() {
    println("Ingresa tu fecha de nacimiento (YYYY-MM-DD):")
    val fechaNacimiento = LocalDate.parse(readln())

    val hoy = LocalDate.now()
    val dias = ChronoUnit.DAYS.between(fechaNacimiento, hoy)
    val meses = ChronoUnit.MONTHS.between(fechaNacimiento, hoy)
    val semanas = dias / 7
    val horas = dias * 24
    val minutos = horas * 60
    val segundos = minutos * 60

    println("Has vivido:")
    println("$meses meses")
    println("$semanas semanas")
    println("$dias días")
    println("$horas horas")
    println("$minutos minutos")
    println("$segundos segundos")
}

fun main() {
    var opcion: Int

    do {
        println("********************")
        println("Elige una opción:")
        println("1- Suma de 3 números")
        println("2- Días vividos")
        println("3- Ingresar nombre")
        println("4- Salir")
        println("*********************")

        opcion = readln().toInt() 

        when (opcion) {
            1 -> {
                val resultado = suma()
                println("El resultado de la suma es: $resultado")
            }
            2 -> vividos()
            3 -> {
                val nombre = ingresarNombre()
                println("Hola, $nombre!")
            }
            4 -> println("Saliendo del programa...")
            else -> println("Opción no válida. Intenta de nuevo.")
        }
    } while (opcion != 4)
}
