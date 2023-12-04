import java.io.File
fun main() {
    var resultP1 = 0
    var resultP2 = 0

    val day1code = fileToList("day1")


    fun part1(input : List<String>) : Int{
        day1code.forEach{ l ->
            resultP1 += getResult(l)
        }
        return resultP1
    }

    fun part2(input : List<String>) : Int{
        day1code.forEach{ l ->
            val convertedList = convertStringToInt(l)
            resultP2 += getResult(convertedList)
        }
        return resultP2
    }

    println("P1: " + part1(day1code))
    println("P2: " + part2(day1code))
}
fun fileToList(filename : String): List<String> {
    val text = File("$filename.txt").readText()
    return text.split("\n")
}
fun convertStringToInt(number: String): String {
    var result = number.replace("one", "one1one")
        .replace("two", "two2two")
        .replace("three", "three3three")
        .replace("four", "four4four")
        .replace("five", "five5five")
        .replace("six", "six6six")
        .replace("seven", "seven7seven")
        .replace("eight", "eight8eight")
        .replace("nine", "nine9nine")
    return result
}
fun getResult(number: String): Int {
    val inputString = number.replace(Regex("[^0-9]"), "")
    val toIntString = inputString.take(1) + inputString.takeLast(1)

    return toIntString.toInt()
}