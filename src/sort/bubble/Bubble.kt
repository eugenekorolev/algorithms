package sort.bubble



/**
 * Created by машинко on 24.08.2017.
 */
class Bubble:Sort{
    override fun sort(array: List<Int>): List<Int> {
        val arrayLength : Int = array.size;
        var hm = array.toTypedArray();
        for (i in 0..(arrayLength - 2)){
            var F = 0;
            for (j in 0..(arrayLength - i)){
                if (hm[i] < hm[i + 1]){
                    var tmp = hm[i + 1]
                    hm[i + 1] = hm[i]
                    hm[i] = tmp
                    F = 1
                }
                if (F == 0) break
            }
        }
        return hm.asList()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val b = Bubble();
            var list = b.sort(b.asList(1, 2, 5, 3, 2, -7, 3, 6))
            println(list)
        }
    }

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts)
            result.add(t)
        return result
    }
}