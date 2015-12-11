// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class asu
    implements ars
{

    private final ass a;
    private final long b = 0x500000L;
    private arx c;
    private File d;
    private FileOutputStream e;
    private long f;
    private long g;

    public asu(ass ass1, long l)
    {
        a = (ass)a.b(ass1);
    }

    private void b()
    {
        d = a.a(c.f, c.c + g, Math.min(c.e - g, b));
        e = new FileOutputStream(d);
        f = 0L;
    }

    private void c()
    {
        if (e != null)
        {
            e.flush();
            e.close();
            e = null;
            a.a(d);
            d = null;
        }
    }

    public final ars a(arx arx1)
    {
        boolean flag;
        if (arx1.e != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        try
        {
            c = arx1;
            g = 0L;
            b();
        }
        // Misplaced declaration of an exception variable
        catch (arx arx1)
        {
            throw new asv(arx1);
        }
        return this;
    }

    public final void a()
    {
        try
        {
            c();
            return;
        }
        catch (IOException ioexception)
        {
            throw new asv(ioexception);
        }
    }

    public final void a(byte abyte0[], int i, int j)
    {
        int k = 0;
_L2:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int l;
        try
        {
            if (f == b)
            {
                c();
                b();
            }
            l = (int)Math.min(j - k, b - f);
            e.write(abyte0, i + k, l);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new asv(abyte0);
        }
        k += l;
        f = f + (long)l;
        g = g + (long)l;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
