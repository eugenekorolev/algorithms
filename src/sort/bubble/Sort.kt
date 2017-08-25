package sort.bubble

/**
 * Head Interface for sort algorithms by Kvendyz
 */
interface Sort {
    fun sort(array : Array<Int>):Array<Int>
    fun swap(array : Array<Int>, startPos : Int, nextPos : Int):Array<Int>
}