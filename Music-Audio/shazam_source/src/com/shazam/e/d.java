// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.e;


// Referenced classes of package com.shazam.e:
//            a, b

public final class d
    implements a
{

    private final b a;

    public d(b b1)
    {
        a = b1;
    }

    public final Object a(Object obj)
    {
        boolean flag = false;
        byte abyte0[] = ((String)obj).getBytes();
        int l = (abyte0.length / 8 + 1) * 8;
        byte abyte1[] = new byte[l];
        obj = new byte[l];
        StringBuilder stringbuilder = new StringBuilder(1024);
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        for (int i = abyte0.length; i < l; i++)
        {
            abyte1[i] = 0;
        }

        for (int j = 0; j < l; j += 8)
        {
            b.a(abyte1, j, ((byte []) (obj)), j);
        }

        stringbuilder.append("#0x");
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            byte byte0 = obj[k];
            char ac[] = new char[16];
            char[] _tmp = ac;
            ac[0] = '0';
            ac[1] = '1';
            ac[2] = '2';
            ac[3] = '3';
            ac[4] = '4';
            ac[5] = '5';
            ac[6] = '6';
            ac[7] = '7';
            ac[8] = '8';
            ac[9] = '9';
            ac[10] = 'A';
            ac[11] = 'B';
            ac[12] = 'C';
            ac[13] = 'D';
            ac[14] = 'E';
            ac[15] = 'F';
            stringbuilder.append((new StringBuilder()).append(ac[byte0 >> 4 & 0xf]).append(ac[byte0 & 0xf]).toString());
        }

        return stringbuilder.toString();
    }
}
