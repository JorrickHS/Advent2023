private fun part1(inputList: List<String>) {
    var result = 0
    var worth = 1
    var matches = 1
    for (cards in inputList) {
        val gameId = getCardId(cards)
        val cardsNoIndex = cards.removeRange(0, 10)
        val allNumbers = cardsNoIndex.split("\n")
        allNumbers.forEach { nmr ->
            var card = nmr.split(" | ")
            card[0].split(" ").forEach { nummer ->
                if (card[1].contains(nummer) && nummer != "") {
                    if(matches < 3){
                        result++
                        matches++
                    } else {
                        result += worth*2
                        worth++

                    }
                }
            }
        }
        worth = 1
        matches = 1
    }
    println(result)
}
private fun getCardId(gameString: String): Int? {
    val regex = Regex("""Card\s+(\d+):""")
    val matchResult = regex.find(gameString)
    return matchResult?.groupValues?.get(1)?.toInt()
}
fun main() {
    part1(fileToList("day4"))
}