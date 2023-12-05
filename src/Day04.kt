import kotlin.math.pow
private fun part1(inputList: List<String>): Int {
    return inputList.sumOf { card ->
        val cardInfo = card.split(":").last().split('|')
        val winningValues = cardInfo.first().trim().split(" ").mapNotNull { it.toIntOrNull() }
        val ownedValues = cardInfo.last().trim().split(" ").mapNotNull { it.toIntOrNull() }

        val numberOfWinning = ownedValues.count { it in winningValues }

        (2.0.pow((numberOfWinning - 1).toDouble())).toInt()
    }
}

private fun part2(){

}

private fun getCardId(gameString: String): Int? {
    val regex = Regex("""Card\s+(\d+):""")
    val matchResult = regex.find(gameString)
    return matchResult?.groupValues?.get(1)?.toInt()
}

fun main() {
//    fun part10(input: List<String>): Int {
//        return input.sumOf { line ->
//            val ticketValues = line.split(":").last()
//            val winningValues = ticketValues.split('|').first().split(" ").map { it.trim() }
//                .mapNotNull { if (it.isNullOrEmpty()) null else it.toInt() }
//            val actualValues = ticketValues.split('|').last().split(" ").map { it.trim() }
//                .mapNotNull { if (it.isNullOrEmpty()) null else it.toInt() }
//            val numberOfWinning = actualValues.sumOf {
//                if (it in winningValues) 1L else 0L
//            }
//            2.0.pow((numberOfWinning - 1).toDouble()).toInt()
//        }
//    }
//    println(part10(fileToList("day4")))
    println(part1(fileToList("day4")))

}