package sort.bubble

import sort.Sort
import java.util.*

/**
 * Bubble sort by Kvendyz
 * https://en.wikipedia.org/wiki/Bubble_sort
 *  ЦИКЛ ДЛЯ J=1 ДО N-1 ШАГ 1
 *      F=0
 *      ЦИКЛ ДЛЯ I=1 ДО N-J ШАГ 1
 *         ЕСЛИ A[I] > A[I+1] ТО ОБМЕН A[I],A[I+1]:F=1
 *         СЛЕДУЮЩЕЕ I
 *         ЕСЛИ F=0 ТО ВЫХОД ИЗ ЦИКЛА
 *     СЛЕДУЮЩЕЕ J
 */
class Bubble: Sort() {

    override fun sort(array: Array<Int>): Array<Int> {
        val lastIndex : Int = array.size - 2
        var swappedElements : Boolean
        do{
            swappedElements = false
            for (j in 0..lastIndex){
                if (array[j] > array[j + 1]){
                    directSwap(array, j, j + 1)
                    swappedElements = true
                }
            }
        } while (swappedElements)
        return array
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val bubble = Bubble()
            val array = Array<Int>(Random().nextInt(30), {i -> Random().nextInt(30)})
            bubble.sort(array).forEach(System.out::println)
        }
    }
}


