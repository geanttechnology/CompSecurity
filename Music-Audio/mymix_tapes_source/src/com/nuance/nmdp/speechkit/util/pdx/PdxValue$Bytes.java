// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.pdx;


// Referenced classes of package com.nuance.nmdp.speechkit.util.pdx:
//            PdxValue

public static final class a extends PdxValue
{

    private final byte a[];

    public final byte[] get()
    {
        return a;
    }

    public final String toString(String s)
    {
        s = new char[16];
        String _tmp = s;
        s[0] = '0';
        s[1] = '1';
        s[2] = '2';
        s[3] = '3';
        s[4] = '4';
        s[5] = '5';
        s[6] = '6';
        s[7] = '7';
        s[8] = '8';
        s[9] = '9';
        s[10] = 'a';
        s[11] = 'b';
        s[12] = 'c';
        s[13] = 'd';
        s[14] = 'e';
        s[15] = 'f';
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("0x");
        byte abyte0[] = a;
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte1 = abyte0[i];
            byte byte0 = (byte)(byte1 >> 4 & 0xf);
            byte1 &= 0xf;
            stringbuilder.append(s[byte0]);
            stringbuilder.append(s[byte1]);
        }

        return stringbuilder.toString();
    }

    public (byte abyte0[])
    {
        super(4);
        a = abyte0;
    }
}
