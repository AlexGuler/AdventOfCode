import java.io.File
import java.lang.Exception
import java.util.*

object Main {

    private const val fileName = "aoc1_1.txt"

    @JvmStatic
    fun main(args: Array<String>) {
        println("no")
    }

    fun uncommonFromSentences(A: String, B: String): Array<String> {
        val combine = "$A $B"
        val grouping = combine.split(" ").groupBy { it }
            .filter { it.value.size == 1 }
        return grouping.map { it.key }.toTypedArray()
    }

//    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
//        val d = IntArray(A.size)
//
//        for (i in 0 until A.size) {
//            var partitionMax = 0
//            var k = 1
//            while (k <= K && (k - 1) <= i) {
//                partitionMax = max(partitionMax, A[i - (k - 1)])
//                d[i] = max(d[i], (if (i >= k) d[i - k] else 0) + k * partitionMax)
//                ++k
//            }
//        }
//        println("d: ${d.toList()}")
//        return d[A.size - 1]
//    }

//    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
//        var i = K - 1
//        var finished = false
//        val subArr = IntArray(K)
//
//        while (i < A.size && !finished) {
//            if (i == A.size - 1) {
//                finished = true
//            }
//
//            // subArr[0] = A[i - 2]
//            // subArr[1] = A[i - 1]
//            // subArr[2] = A[i]
//            for (j in 0 until K) {
//                subArr[j] = A[i - j]
//            }
//
//            println(subArr.toList())
//
//            val max = subArr.max()!!
//
//            for (j in 0 until K) {
//                A[i - j] = max
//            }
//
//
//            i += K
//            while (i >= A.size) {
//                --i
//            }
//        }
//
//        println(A.toList())
//
//        return A.sum()
//    }

//    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
//        val endArr = IntArray(A.size) { 0 }
//        endArr[0] = A[0]
//        for (i in 1 until A.size) {
////            println(i)
//
//            var partitionNum = 0
//            var j = i
//            var counter = 0
//            while (true) {
//
//
//                partitionNum = max(partitionNum, endArr[i - 1] + A[j])
//
//                println(partitionNum)
//
//
//
////                endArr[j]
////                partitionNum = max(partitionNum, A[j] * K)
////                val max = A[j]
////                println(A[j] * K)
////                println("j $j | i: $i")
//
////                println("max: $max")
//
//                ++j
//                ++counter
//
//                if (counter % K == 0 || j >= A.size) {
//                    break
//                }
//            }
//
//            endArr[i] = partitionNum
//            println("--------------")
////            if (i == 2) {
////                break
////            }
//        }
//        println("-> ${endArr.toList()}")
//        return 1
//    }


//    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
//
//        var i = K - 1
//        var finished = false
//        val subArr = IntArray(K)
//
//        while (i < A.size && !finished) {
//            if (i == A.size - 1) {
//                finished = true
//            }
//
//            // subArr[0] = A[i - 2]
//            // subArr[1] = A[i - 1]
//            // subArr[2] = A[i]
//            for (j in 0 until K) {
//                subArr[j] = A[i - j]
//            }
//
//            println(subArr.toList())
//
//            val max = subArr.max()!!
//
//            for (j in 0 until K) {
//                A[i - j] = max
//            }
//
//
//            i += K
//            while (i >= A.size) {
//                --i
//            }
//        }
//
//        println(A.toList())
//
//        return A.sum()
//    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        /*
        How to build a Tree.

        val a = TreeNode(1)
        val b = TreeNode(7)
        val c = TreeNode(0)
        val d = TreeNode(7)
        val e = TreeNode(-8)

        a.left = b
        a.right = c
        b.left = d
        b.right = e
         */
    }

    /*
    for (j in 0 until 10) {
    print(j)
 }

 for loop in kotlin
     */
    private fun <T> Collection<T>.indexExists(index: Int): Boolean = index < size

    private fun Int.isEven(): Boolean = this % 2 == 0

    private fun Array<IntArray>.toGridString(): String {
        return this.joinToString(separator = "") { it.toList().toString() + "\n" }
    }

    private fun Array<BooleanArray>.toGridString(): String {
        return this.joinToString(separator = "") { it.toList().toString() + "\n" }
    }

    private fun String.groupByIndices(): Map<Char, List<Int>> {
        val map = mutableMapOf<Char, MutableList<Int>>()
        this.forEachIndexed { index, c ->
            val value = map[c]
            if (value != null) {
                value.add(index)
            } else {
                map[c] = mutableListOf(index)
            }
        }
        return map
    }
}


