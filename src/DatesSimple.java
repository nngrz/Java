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
        int resetFromy = fromy - 2000;
        int resetToy = toy - 2000;

        int packedDate = (resetFromy & 0x7f) << 9 | (fromm & 0x0f) << 5 | (fromd & 0x1f);
        packedDate <<= 16;
        packedDate |= (resetToy & 0x7f) << 9 | (tom & 0x0f) << 5 | (tod & 0x1f);
        period = packedDate;
        fromy = fromm = fromd = toy = tom = tod = 0;

//      unpack
        int[] dates = new int[6];
//      unpack the "from" date
        dates[0] = (((period >> 16) >> 9) & 0x7f) + 2000;
        dates[1] = ((period >> 16) >> 5) & 0x0f;
        dates[2] = ((period >> 16)) & 0x1f;
//      unpack the "to" date
        dates[3] = ((period >> 9) & 0x7f) + 2000;
        dates[4] = (period >> 5) & 0x0f;
        dates[5] = (period) & 0x1f;

        fromy = dates[0];
        fromm = dates[1];
        fromd = dates[2];
        toy = dates[3];
        tom = dates[4];
        tod = dates[5];

        System.out.println("**** Reconstructed\n" +
                            "From " + fromy + "/" +
                            fromm + "/" + fromd + " to " +
                            toy + "/" + tom + "/" + tod);
    }
}
