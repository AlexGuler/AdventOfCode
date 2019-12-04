import java.io.File
import java.lang.RuntimeException
import java.util.*

object AoC2 {

    private const val part1File = "aoc2_1.txt"

    @JvmStatic
    fun main(args: Array<String>) {
        part2()
    }

    private fun part2() {
        /**
         * Notes:
         * For every noun increase it increases address 0 by 486000
         * For every verb increase it increases address 0 by itself (so if verb is 1 it will increase it by 1)
         *
         * Here is the equation we have to solve
         * 736669 + (noun * 486000) + verb = 19690720
         */
        val ANSWER = 19690720
        var noun = 0
        var current = 736669 + (noun * 486000)
        var leftOver = ANSWER - current

        while (leftOver > 486000) {
            ++noun
            current = 736669 + (noun * 486000)
            leftOver = ANSWER - current
        }

        val verb = leftOver
        val input = getInputFromFile(part1File)
        input[1] = noun
        input[2] = verb
        println("B: ${input.toList()}")
        doWork(input)
        println("A: ${input.toList()}")

        println("Answer: ${(100 * noun) + verb}")
    }

    private fun part1() {
        val input = getInputFromFile(part1File)
        input[1] = 12
        input[2] = 2
        println("B: ${input.toList()}")
        doWork(input)
        println("A: ${input.toList()}")
    }

    private fun doWork(input: Array<Int>) {
        var position = 0
        var opcode = input[position]

        while (opcode != 99) {
            val num1Pos = input[position + 1]
            val num2Pos = input[position + 2]
            val resultPos = input[position + 3]

            val result = doOperation(opcode, input[num1Pos], input[num2Pos])

            input[resultPos] = result
            position += 4
            opcode = input[position]
        }
    }

    private fun doOperation(opcode: Int, num1: Int, num2: Int): Int {
        return when (opcode) {
            1 -> num1 + num2
            2 -> num1 * num2
            else -> throw IllegalStateException("Unknown opcode: $opcode")
        }
    }

    private fun getInputFromFile(fileName: String): Array<Int> {
        try {
            val file = File("resources/$part1File")
            val scanner = Scanner(file)
            var str = ""
            var count = 0
            while (scanner.hasNext()) {
                ++count
                str += scanner.next()
            }

            val stringList = str.split(",")
            return Array(stringList.size) {
                stringList[it].toInt()
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    private fun testCasesPart1() {
        val testCases = mapOf(
            arrayOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50) to arrayOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50),
            arrayOf(1, 0, 0, 0, 99) to arrayOf(2, 0, 0, 0, 99),
            arrayOf(2, 3, 0, 3, 99) to arrayOf(2, 3, 0, 6, 99),
            arrayOf(2, 4, 4, 5, 99, 0) to arrayOf(2, 4, 4, 5, 99, 9801),
            arrayOf(1, 1, 1, 4, 99, 5, 6, 0, 99) to arrayOf(30, 1, 1, 4, 2, 5, 6, 0, 99)
        )

        testCases.forEach { (input, correct) ->
            doWork(input)
            println("A: ${input.toList()}")
            println("C: ${correct.toList()}")

            if (!input.contentEquals(correct)) {
                throw RuntimeException("${input.toList()} is not equal to ${correct.toList()}")
            }
        }
    }
}
