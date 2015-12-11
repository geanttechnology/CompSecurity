// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;


public class TwitterVineApp
{

    public static final String API_KEY = transform1();
    public static final String API_SECRET = transform2();

    public TwitterVineApp()
    {
    }

    public static String transform1()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            return "";
        }
        byte abyte0[] = new byte[21];
        byte[] _tmp = abyte0;
        abyte0[0] = -79;
        abyte0[1] = -66;
        abyte0[2] = -66;
        abyte0[3] = -33;
        abyte0[4] = -65;
        abyte0[5] = -35;
        abyte0[6] = -84;
        abyte0[7] = -94;
        abyte0[8] = -97;
        abyte0[9] = -62;
        abyte0[10] = -50;
        abyte0[11] = -61;
        abyte0[12] = -55;
        abyte0[13] = -31;
        abyte0[14] = -92;
        abyte0[15] = -77;
        abyte0[16] = -48;
        abyte0[17] = -87;
        abyte0[18] = -93;
        abyte0[19] = -50;
        abyte0[20] = -98;
        StringBuilder stringbuilder = new StringBuilder(abyte0.length);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((char)(21 - abyte0[i]));
        }

        return stringbuilder.toString();
    }

    public static String transform2()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            return "";
        }
        byte abyte0[] = new byte[42];
        byte[] _tmp = abyte0;
        abyte0[0] = -32;
        abyte0[1] = -54;
        abyte0[2] = -65;
        abyte0[3] = -34;
        abyte0[4] = -29;
        abyte0[5] = -31;
        abyte0[6] = -27;
        abyte0[7] = -33;
        abyte0[8] = -48;
        abyte0[9] = -50;
        abyte0[10] = -63;
        abyte0[11] = -62;
        abyte0[12] = -80;
        abyte0[13] = -56;
        abyte0[14] = -94;
        abyte0[15] = -52;
        abyte0[16] = -89;
        abyte0[17] = -91;
        abyte0[18] = -53;
        abyte0[19] = -29;
        abyte0[20] = -82;
        abyte0[21] = -51;
        abyte0[22] = -47;
        abyte0[23] = -44;
        abyte0[24] = -55;
        abyte0[25] = -30;
        abyte0[26] = -50;
        abyte0[27] = -84;
        abyte0[28] = -51;
        abyte0[29] = -84;
        abyte0[30] = -52;
        abyte0[31] = -60;
        abyte0[32] = -31;
        abyte0[33] = -89;
        abyte0[34] = -80;
        abyte0[35] = -77;
        abyte0[36] = -45;
        abyte0[37] = -85;
        abyte0[38] = -97;
        abyte0[39] = -76;
        abyte0[40] = -101;
        abyte0[41] = -94;
        StringBuilder stringbuilder = new StringBuilder(abyte0.length);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((char)(21 - abyte0[i]));
        }

        return stringbuilder.toString();
    }

}
