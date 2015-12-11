// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class dad
    implements Closeable
{

    private final DataInputStream a;

    public dad(InputStream inputstream)
    {
        a = new DataInputStream(inputstream);
    }

    public final exf a()
    {
        int i;
        do
        {
            i = a.readInt();
        } while (i == 0);
        if (i <= 0 || i > 0x400000)
        {
            throw new IOException((new StringBuilder("Wrong len ")).append(i).toString());
        } else
        {
            byte abyte0[] = new byte[i];
            a.readFully(abyte0);
            exf exf1 = new exf();
            exf1.a(abyte0);
            return exf1;
        }
    }

    public final void close()
    {
        a.close();
    }
}
