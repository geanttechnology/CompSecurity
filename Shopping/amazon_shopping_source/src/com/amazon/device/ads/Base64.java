// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Utils

public class Base64
{

    private static final String ENCODE_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public Base64()
    {
    }

    public static byte[] decode(String s)
    {
        byte abyte0[];
        int i;
        int j;
        int j1;
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("Encoded String must not be null or white space");
        }
        j1 = getDecodedLength(s);
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("Encoded String decodes to zero bytes");
        }
        abyte0 = new byte[j1];
        i = 0;
        j = 0;
        break MISSING_BLOCK_LABEL_47;
_L2:
        return abyte0;
_L10:
        if (j >= s.length() || i >= j1 || j % 4 == 0 && s.length() < j + 4) goto _L2; else goto _L1
_L1:
        int k1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(s.charAt(j));
        if (k1 == -1) goto _L2; else goto _L3
_L3:
        j % 4;
        JVM INSTR tableswitch 0 3: default 132
    //                   0 139
    //                   1 150
    //                   2 195
    //                   3 242;
           goto _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_242;
_L4:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L11:
        j++;
        if (true) goto _L10; else goto _L9
_L9:
        abyte0[i] = (byte)(k1 << 2);
          goto _L11
_L6:
        int k = i + 1;
        abyte0[i] = (byte)(abyte0[i] | (byte)(k1 >> 4 & 3));
        i = k;
        if (k < j1)
        {
            abyte0[k] = (byte)(k1 << 4);
            i = k;
        }
          goto _L11
_L7:
        int l = i + 1;
        abyte0[i] = (byte)(abyte0[i] | (byte)(k1 >> 2 & 0xf));
        i = l;
        if (l < j1)
        {
            abyte0[l] = (byte)(k1 << 6);
            i = l;
        }
          goto _L11
        int i1 = i + 1;
        abyte0[i] = (byte)(abyte0[i] | (byte)(k1 & 0x3f));
        i = i1;
          goto _L11
    }

    private static int getDecodedLength(String s)
    {
        int j = s.indexOf("=");
        int i = 0;
        if (j > -1)
        {
            i = s.length() - j;
        }
        return ((s.length() + 3) / 4) * 3 - i;
    }
}
