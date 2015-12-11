// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.io.DataInput;

// Referenced classes of package com.d.a:
//            q, a

final class ak extends q
{

    long a;
    long b;
    String c;
    String d;
    long e;
    Long f;
    byte g[];
    a h;

    ak()
    {
    }

    ak(DataInput datainput)
    {
        a(datainput);
    }

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < abyte0.length) 
        {
            int j = abyte0[i] >> 4 & 0xf;
            if (j < 10)
            {
                stringbuilder.append((char)(j + 48));
            } else
            {
                stringbuilder.append((char)((j + 65) - 10));
            }
            j = abyte0[i] & 0xf;
            if (j < 10)
            {
                stringbuilder.append((char)(j + 48));
            } else
            {
                stringbuilder.append((char)((j + 65) - 10));
            }
            i++;
        }
        return stringbuilder.toString();
    }

    final void a(DataInput datainput)
    {
        a = datainput.readLong();
        b = datainput.readLong();
        d = datainput.readUTF();
        c = datainput.readUTF();
        e = datainput.readLong();
        f = Long.valueOf(datainput.readLong());
        g = new byte[datainput.readUnsignedByte()];
        datainput.readFully(g);
    }

    public final String toString()
    {
        return (new StringBuilder("ad {id=")).append(a).append(", name='").append(d).append("', cookie: '").append(a(g)).append("'}").toString();
    }
}
