package sort.bubble

import java.util.*


/**
 * Bubble sort by Kvendyz
 */
class Bubble:Sort{

    override fun swap(array: Array<Int>, startPos: Int, nextPos: Int): Array<Int> {
        val tmp = array[nextPos]
        array[nextPos] = array[startPos]
        array[startPos] = tmp
        return array
    }

    override fun sort(array: Array<Int>): Array<Int> {
        val arrayLength : Int = array.size
        for (i in 0..(arrayLength - 2)){
            var F = 0
            for (j in 0..(arrayLength - 2 - i)){
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1)
                    F = 1
                }
                if (F == 0) break
            }
        }
        return array
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val b = Bubble()
            val array = Array<Int>(8, {i -> Random().nextInt(30)})
            b.sort(array).forEach(System.out::println)
        }
    }
}


