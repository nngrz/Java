public class DatesSimple {
    public static void main(String[] args) {
        int fromy = 2000, fromm = 2, fromd = 3;
        int toy = 2127, tom = 11, tod = 29;

        System.out.println("**** Original\n" +
                "From " + fromy + "/" +
                fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod);
//      pack
        int period = 0;
        int resetFromy = fromy - 2000; // adjust the fromy to be in range [0, 127]
        int resetToy = toy - 2000; // adjust the toy to be in range [0, 127]
//      pack the "from" date (fromy/m/d) into a 16 bits integer
        int packedDate = (resetFromy & 0x7f) << 9 | (fromm & 0x0f) << 5 | (fromd & 0x1f);
//      shift the packedDate to the left 16 bits to be at higher bits
        packedDate = packedDate << 16;
//      pack the "to" date (toy/m/d) into the lower 16 bits of packedDate.
        packedDate = packedDate | (resetToy & 0x7f) << 9 | (tom & 0x0f) << 5 | (tod & 0x1f);
        period = packedDate;
        fromy = fromm = fromd = toy = tom = tod = 0;

//      unpack the "from" date
        fromy = (((period >> 16) >> 9) & 0x7f) + 2000;
        fromm = ((period >> 16) >> 5) & 0x0f;
        fromd = ((period >> 16)) & 0x1f;
//      unpack the "to" date
        toy = ((period >> 9) & 0x7f) + 2000;
        tom = (period >> 5) & 0x0f;
        tod = (period) & 0x1f;

        System.out.println("**** Reconstructed\n" +
                "From " + fromy + "/" +
                fromm + "/" + fromd + " to " +
                toy + "/" + tom + "/" + tod);
    }
}
