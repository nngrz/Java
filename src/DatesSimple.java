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
/*
      - Save variable "resetFromy" (range 0-127, requiring 7 bits, as 2^7 = 128)
        into bits 9-15 of period by using (resetFromy & 0x7f) << 9)
      - Save variable "fromm" (range 0-15, requiring 4 bits, as 2^4 = 16)
        into bits 5-8 of period by using (fromm & 0x0f) << 5
      - Save variable "fromd" (range 0-31, requiring 5 bits, as 2^5 = 32)
        into bits 0-4 of period by using (fromd & 0x1f)
*/
        period = (resetFromy & 0x7f) << 9 | (fromm & 0x0f) << 5 | (fromd & 0x1f);
/*
        Because we want to store the "to" date on bits 0-15,
        and the "from" date is currently occupying those bits in period,
        we need to shift the "from" date to bits 16-31.
        This is achieved by left-shifting period by 16 bits.
*/
        period = period << 16;
//      pack the "to" date (toy/m/d) into the lower 16 bits of period.
        period = period | (resetToy & 0x7f) << 9 | (tom & 0x0f) << 5 | (tod & 0x1f);
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
