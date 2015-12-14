// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            f

class g extends FilterOutputStream
{

    final f a;

    private g(f f1, OutputStream outputstream)
    {
        a = f1;
        super(outputstream);
    }

    g(f f1, OutputStream outputstream, e._cls1 _pcls1)
    {
        this(f1, outputstream);
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
            f.a(a, true);
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
            f.a(a, true);
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
            f.a(a, true);
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
            f.a(a, true);
        }
    }
}
