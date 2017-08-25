package sort.insertion

import sort.Sort
import java.util.*

/**
 * Insertion sort by Kvendyz
 * for j = 2 to A.length do
 *   key = A["j]
 *   i = j-1
 *   while (i > 0 and A["i] > key) do
 *     A[i + 1] = A[i]
 *     i = i - 1
 *   end while
 *   A[i+1] = key
 * end for
 */
class Insertion : Sort() {
    override fun sort(array: Array<Int>): Array<Int> {
        var element : Int
        val tmp :  Array<Int> = array
        val length : Int = array.size - 1
        for (i in 1..length){
            element = array[i]
            var j : Int = i - 1
            while(j >= 0 && array[j] > element){
                array[j + 1] = array[j]
                j = j.dec()
            }
            array[j + 1] = element
        }
        return tmp
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val insertion = Insertion()
            val array = Array<Int>(Random().nextInt(30), { i -> Random().nextInt(30)})
            array.forEach{print(it.toString() + " ")}
            println()
            insertion.sort(array).forEach{print(it.toString() + " ")}
        }
    }
}