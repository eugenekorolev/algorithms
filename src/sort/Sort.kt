package sort

/**
 * Head Interface for sort algorithms by Kvendyz
 * https://en.wikipedia.org/wiki/Sorting_algorithm
 */
abstract class Sort {
    abstract fun sort(array : Array<Int>):Array<Int>
    fun directSwap(array : Array<Int>, startPos : Int, nextPos : Int):Array<Int>{
        val tmp = array[nextPos]
        array[nextPos] = array[startPos]
        array[startPos] = tmp
        return array
    }
    fun backSwap(array : Array<Int>, startPos : Int, nextPos : Int):Array<Int>{
        val tmp = array[startPos]
        array[startPos] = array[nextPos]
        array[nextPos] = tmp
        return array
    }
}