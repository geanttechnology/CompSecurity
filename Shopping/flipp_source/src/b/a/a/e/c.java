// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;
import java.io.DataInput;
import java.io.IOException;

// Referenced classes of package b.a.a.e:
//            i, f, a

public final class c
{

    static long a(DataInput datainput)
    {
        int j = datainput.readUnsignedByte();
        switch (j >> 6)
        {
        default:
            return (long)((j << 26) >> 26) * 0x1b7740L;

        case 1: // '\001'
            return (long)((j << 26) >> 2 | datainput.readUnsignedByte() << 16 | datainput.readUnsignedByte() << 8 | datainput.readUnsignedByte()) * 60000L;

        case 2: // '\002'
            return (((long)j << 58) >> 26 | (long)(datainput.readUnsignedByte() << 24) | (long)(datainput.readUnsignedByte() << 16) | (long)(datainput.readUnsignedByte() << 8) | (long)datainput.readUnsignedByte()) * 1000L;

        case 3: // '\003'
            return datainput.readLong();
        }
    }

    public static i a(DataInput datainput, String s)
    {
        switch (datainput.readUnsignedByte())
        {
        default:
            throw new IOException("Invalid encoding");

        case 70: // 'F'
            s = new b.a.a.e.i(s, datainput.readUTF(), (int)a(datainput), (int)a(datainput));
            datainput = s;
            if (s.equals(i.a))
            {
                datainput = i.a;
            }
            return datainput;

        case 67: // 'C'
            return b.a.a.e.a.a(f.a(datainput, s));

        case 80: // 'P'
            return f.a(datainput, s);
        }
    }
}
