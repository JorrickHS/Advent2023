private fun getGameID(gameString: String): Int {
    return gameString.substringAfter("Game ").substringBefore(":").toInt()
}

private fun part1(inputList: List<String>) {
    var result = 0
    var bool = true

    for (game in inputList) {
        val removeIndex = game.split(": ")[1]
        val parts = removeIndex.split("; ")
        for (part in parts) {
            val colorCount = part.split(", ")
            for (colorString in colorCount) {
                val color = colorString.substringAfterLast(" ")
                val count = colorString.substringBefore(" ").toInt()
                when (color) {
                    "red" -> if (count > 12) {
                        bool = false
                    }

                    "green" -> if (count > 13) {
                        bool = false
                    }

                    "blue" -> if (count > 14) {
                        bool = false
                    }
                }
            }
        }
        if (bool) {
            result += getGameID(game)
        }
        bool = true
    }
    println("P1: $result")
}

private fun part2(inputList: List<String>) {
    var result = 0
    var redCount = 0
    var greenCount = 0
    var blueCount = 0

    for (game in inputList) {
        val removeIndex = game.split(": ")[1]
        val parts = removeIndex.split("; ")
        for (part in parts) {
            val colorCount = part.split(", ")
            for (colorString in colorCount) {
                val color = colorString.substringAfterLast(" ")
                val count = colorString.substringBefore(" ").toInt()
                when (color) {
                    "red" -> if (count > redCount) {
                        redCount = count
                    }
                    "green" -> if (count > greenCount) {
                        greenCount = count
                    }
                    "blue" -> if (count > blueCount) {
                        blueCount = count
                    }
                }
            }
        }
        result += (redCount * greenCount * blueCount)
        redCount = 0
        greenCount = 0
        blueCount = 0
    }
    println("P2: $result")
}

fun main() {
    val gameList = fileToList("day2")
    part1(gameList)
    part2(gameList)
}
