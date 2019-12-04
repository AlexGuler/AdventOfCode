import java.io.File
import java.lang.Exception
import java.util.*

object AoC1 {

    private const val part1File = "aoc1_1.txt"

    @JvmStatic
    fun main(args: Array<String>) {
        part1()
        part2()
    }

    private fun part2() {
        try {
            val file = File("resources/$part1File")
            val scanner = Scanner(file)

            var sum = 0
            while (scanner.hasNext()) {
                val next = scanner.next()
                sum += getRequiredRequiredRequiredRequired(next.toInt())
            }

            println("part2: $sum")
            assert(sum == 5337642)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getRequiredRequiredRequiredRequired(mass: Int): Int {
        var sum = getRequired(mass)
        var next = getRequired(sum)
        while(next > 0) {
            sum += next
            next = getRequired(next)
        }
        return sum
    }

    private fun part1() {

        try {
            val file = File("resources/$part1File")
            val scanner = Scanner(file)

            var sum = 0
            while (scanner.hasNext()) {
                val next = scanner.next()
                sum += getRequired(next.toInt())
            }

            println("part1: $sum")
            assert(sum == 3560353)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getRequired(mass: Int): Int {
        return (mass / 3) - 2
    }
}
