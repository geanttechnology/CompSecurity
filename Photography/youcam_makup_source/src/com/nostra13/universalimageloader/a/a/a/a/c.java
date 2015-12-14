// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            b

class c extends FilterOutputStream
{

    final b a;

    private c(b b1, OutputStream outputstream)
    {
        a = b1;
        super(outputstream);
    }

    c(b b1, OutputStream outputstream, a._cls1 _pcls1)
    {
        this(b1, outputstream);
    }

    public void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            b.a(a, true);
        }
    }

    public void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            b.a(a, true);
        }
    }

    public void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            b.a(a, true);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            b.a(a, true);
        }
    }
}
