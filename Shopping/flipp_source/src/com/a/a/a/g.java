// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.a.a.a:
//            f

final class g extends FilterOutputStream
{

    final f a;

    private g(f f1, OutputStream outputstream)
    {
        a = f1;
        super(outputstream);
    }

    g(f f1, OutputStream outputstream, byte byte0)
    {
        this(f1, outputstream);
    }

    public final void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            a.c = true;
        }
    }

    public final void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            a.c = true;
        }
    }

    public final void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            a.c = true;
        }
    }

    public final void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a.c = true;
        }
    }
}
