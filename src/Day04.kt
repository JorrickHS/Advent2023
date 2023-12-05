private fun part1(inputList: List<String>) {
    var result = 0
    var worth = 1
    var matches = 0
    for (cards in inputList) {
        val gameId = getCardId(cards)
        val cardsNoIndex = cards.removeRange(0, 10)
        val allNumbers = cardsNoIndex.split("\n")
        allNumbers.forEach { nmr ->
            var card = nmr.split(" | ")
            card[0].split(" ").forEach { nummer ->
                if (card[1].contains(nummer) && nummer != "") {
                    matches++
                    //1e match = 1 punt
                    //2e match = 1 punt
                    //3e match = 2 punt
                    //4e match = 4 punt
                    //5e match = 8 punt
                    //etc...
                }
            }
        }
        worth = 1
    }
    println(matches)
}
private fun getCardId(gameString: String): Int? {
    val regex = Regex("""Card\s+(\d+):""")
    val matchResult = regex.find(gameString)
    return matchResult?.groupValues?.get(1)?.toInt()
}
fun main() {
    part1(fileToList("day4"))
}