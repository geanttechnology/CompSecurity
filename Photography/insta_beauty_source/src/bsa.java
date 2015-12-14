// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bsa
{

    private static final char a = (char)Integer.parseInt("00000011", 2);
    private static final char b = (char)Integer.parseInt("00001111", 2);
    private static final char c = (char)Integer.parseInt("00111111", 2);
    private static final char d = (char)Integer.parseInt("11111100", 2);
    private static final char e = (char)Integer.parseInt("11110000", 2);
    private static final char f = (char)Integer.parseInt("11000000", 2);
    private static final char g[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '+', '/'
    };

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer;
        char c1;
        int j;
        int k;
        k = 0;
        stringbuffer = new StringBuffer((int)((double)abyte0.length * 1.3400000000000001D) + 3);
        c1 = '\0';
        j = 0;
_L11:
        char c2;
        if (k >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j %= 8;
        c2 = c1;
_L8:
        if (j >= 8)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        c1 = c2;
        j;
        JVM INSTR tableswitch 0 6: default 92
    //                   0 116
    //                   1 95
    //                   2 132
    //                   3 95
    //                   4 145
    //                   5 95
    //                   6 192;
           goto _L1 _L2 _L3 _L4 _L3 _L5 _L3 _L6
_L6:
        break MISSING_BLOCK_LABEL_192;
_L2:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        c1 = c2;
_L9:
        stringbuffer.append(g[c1]);
        j += 6;
        c2 = c1;
        if (true) goto _L8; else goto _L7
_L7:
        c1 = (char)((char)(abyte0[k] & d) >>> 2);
          goto _L9
_L4:
        c1 = (char)(abyte0[k] & c);
          goto _L9
_L5:
        c2 = (char)((char)(abyte0[k] & b) << 2);
        c1 = c2;
        if (k + 1 < abyte0.length)
        {
            c1 = (char)(c2 | (abyte0[k + 1] & f) >>> 6);
        }
          goto _L9
        c2 = (char)((char)(abyte0[k] & a) << 4);
        c1 = c2;
        if (k + 1 < abyte0.length)
        {
            c1 = (char)(c2 | (abyte0[k + 1] & e) >>> 4);
        }
          goto _L9
        k++;
        c1 = c2;
        if (true) goto _L11; else goto _L10
_L10:
        if (stringbuffer.length() % 4 != 0)
        {
            for (int i = 4 - stringbuffer.length() % 4; i > 0; i--)
            {
                stringbuffer.append("=");
            }

        }
        return stringbuffer.toString();
    }

}
