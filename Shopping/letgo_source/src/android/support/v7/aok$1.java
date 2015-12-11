// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            aok

class <init> extends <init>
{

    final InputStream a;
    final OutputStream b;
    final aok c;

    public aok a()
        throws IOException
    {
        byte abyte0[] = new byte[aok.a(c)];
        do
        {
            int i = a.read(abyte0);
            if (i != -1)
            {
                b.write(abyte0, 0, i);
            } else
            {
                return c;
            }
        } while (true);
    }

    public Object b()
        throws c, IOException
    {
        return a();
    }

    (aok aok1, Closeable closeable, boolean flag, InputStream inputstream, OutputStream outputstream)
    {
        c = aok1;
        a = inputstream;
        b = outputstream;
        super(closeable, flag);
    }
}
