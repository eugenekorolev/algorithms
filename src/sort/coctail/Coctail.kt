package sort.coctail

import sort.Sort
import java.util.*

/**
 * Advanced bubble sort as Coctail sort
 * https://en.wikipedia.org/wiki/Cocktail_shaker_sort
 */
class Coctail : Sort() {

    override fun sort(array: Array<Int>): Array<Int> {
        var left = 1
        var right : Int = array.size - 1
        var tmp :  Array<Int> = array
        do{
            for (j in left..right){
                if (tmp[j - 1] > tmp[j]){
                    tmp = directSwap(tmp, j - 1, j)
                }
            }
            right = right.dec()
            for (j in right downTo left){
                if (tmp[j] < tmp[j - 1]){
                    tmp = backSwap(tmp, j, j - 1)
                }
            }
            left = left.inc()

        } while (left <= right)
        return tmp
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val coctail = Coctail()
            val array = Array<Int>(Random().nextInt(30), {i -> Random().nextInt(30)})
            coctail.sort(array).forEach(System.out::println)
        }
    }
}