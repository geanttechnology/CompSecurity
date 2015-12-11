// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.common.util.EbaySecureDataEncoder;
import com.ebay.nautilus.kernel.NautilusKernel;

public class ObfuscatedData
{

    public static final String decryptedAppId;
    public static final String decryptedCertId;
    public static final String decryptedDevId;
    public static final String decryptedPayPalAppId;

    private ObfuscatedData()
    {
    }

    static 
    {
        if (NautilusKernel.isQaMode())
        {
            decryptedAppId = "AndrApp";
            decryptedDevId = "AndrDev";
            decryptedCertId = "AndrCert";
            decryptedPayPalAppId = "APP-3U265555Y6923733N";
        } else
        {
            byte abyte0[] = new byte[36];
            byte[] _tmp = abyte0;
            abyte0[0] = -35;
            abyte0[1] = -110;
            abyte0[2] = 105;
            abyte0[3] = -10;
            abyte0[4] = -68;
            abyte0[5] = 110;
            abyte0[6] = -91;
            abyte0[7] = -71;
            abyte0[8] = 89;
            abyte0[9] = 23;
            abyte0[10] = 117;
            abyte0[11] = -8;
            abyte0[12] = -124;
            abyte0[13] = -119;
            abyte0[14] = 5;
            abyte0[15] = -85;
            abyte0[16] = 51;
            abyte0[17] = -108;
            abyte0[18] = -84;
            abyte0[19] = -29;
            abyte0[20] = 5;
            abyte0[21] = 46;
            abyte0[22] = 113;
            abyte0[23] = 102;
            abyte0[24] = 60;
            abyte0[25] = -7;
            abyte0[26] = -37;
            abyte0[27] = 63;
            abyte0[28] = -88;
            abyte0[29] = 86;
            abyte0[30] = -107;
            abyte0[31] = 27;
            abyte0[32] = -10;
            abyte0[33] = -29;
            abyte0[34] = -38;
            abyte0[35] = -33;
            byte abyte1[] = new byte[36];
            byte[] _tmp1 = abyte1;
            abyte1[0] = 40;
            abyte1[1] = 97;
            abyte1[2] = -82;
            abyte1[3] = -23;
            abyte1[4] = 21;
            abyte1[5] = -6;
            abyte1[6] = 11;
            abyte1[7] = -74;
            abyte1[8] = 4;
            abyte1[9] = 30;
            abyte1[10] = -26;
            abyte1[11] = -41;
            abyte1[12] = -72;
            abyte1[13] = 38;
            abyte1[14] = -104;
            abyte1[15] = -121;
            abyte1[16] = -35;
            abyte1[17] = -111;
            abyte1[18] = 14;
            abyte1[19] = 51;
            abyte1[20] = 108;
            abyte1[21] = -19;
            abyte1[22] = 52;
            abyte1[23] = 15;
            abyte1[24] = 114;
            abyte1[25] = 71;
            abyte1[26] = -47;
            abyte1[27] = -59;
            abyte1[28] = -38;
            abyte1[29] = -103;
            abyte1[30] = 64;
            abyte1[31] = 60;
            abyte1[32] = 123;
            abyte1[33] = -79;
            abyte1[34] = 38;
            abyte1[35] = -107;
            byte abyte2[] = new byte[36];
            byte[] _tmp2 = abyte2;
            abyte2[0] = 86;
            abyte2[1] = 99;
            abyte2[2] = 43;
            abyte2[3] = 76;
            abyte2[4] = -128;
            abyte2[5] = 25;
            abyte2[6] = -24;
            abyte2[7] = -102;
            abyte2[8] = 62;
            abyte2[9] = -49;
            abyte2[10] = 88;
            abyte2[11] = 71;
            abyte2[12] = -128;
            abyte2[13] = -41;
            abyte2[14] = 42;
            abyte2[15] = -53;
            abyte2[16] = 117;
            abyte2[17] = 126;
            abyte2[18] = 87;
            abyte2[19] = -27;
            abyte2[20] = 8;
            abyte2[21] = -94;
            abyte2[22] = -83;
            abyte2[23] = 15;
            abyte2[24] = 112;
            abyte2[25] = 1;
            abyte2[26] = 101;
            abyte2[27] = -2;
            abyte2[28] = 59;
            abyte2[29] = 127;
            abyte2[30] = -29;
            abyte2[31] = 66;
            abyte2[32] = 41;
            abyte2[33] = 24;
            abyte2[34] = -88;
            abyte2[35] = -88;
            byte abyte3[] = new byte[36];
            byte[] _tmp3 = abyte3;
            abyte3[0] = -15;
            abyte3[1] = -32;
            abyte3[2] = -84;
            abyte3[3] = 13;
            abyte3[4] = -36;
            abyte3[5] = 4;
            abyte3[6] = 27;
            abyte3[7] = -78;
            abyte3[8] = 116;
            abyte3[9] = 20;
            abyte3[10] = -66;
            abyte3[11] = 43;
            abyte3[12] = -30;
            abyte3[13] = 73;
            abyte3[14] = -86;
            abyte3[15] = -86;
            abyte3[16] = 19;
            abyte3[17] = -80;
            abyte3[18] = 53;
            abyte3[19] = 13;
            abyte3[20] = -128;
            abyte3[21] = 17;
            abyte3[22] = -49;
            abyte3[23] = -25;
            abyte3[24] = -53;
            abyte3[25] = 7;
            abyte3[26] = 45;
            abyte3[27] = 9;
            abyte3[28] = -98;
            abyte3[29] = -32;
            abyte3[30] = 42;
            abyte3[31] = -77;
            abyte3[32] = 122;
            abyte3[33] = 38;
            abyte3[34] = -15;
            abyte3[35] = -68;
            EbaySecureDataEncoder ebaysecuredataencoder = new EbaySecureDataEncoder();
            ebaysecuredataencoder.decode(abyte0);
            ebaysecuredataencoder.decode(abyte1);
            ebaysecuredataencoder.decode(abyte2);
            ebaysecuredataencoder.decode(abyte3);
            decryptedAppId = new String(abyte0);
            decryptedDevId = new String(abyte1);
            decryptedCertId = new String(abyte2);
            decryptedPayPalAppId = new String(abyte3, 0, 21);
        }
    }
}
