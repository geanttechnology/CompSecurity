// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class asb
    implements art
{

    private final asq a;
    private RandomAccessFile b;
    private long c;
    private boolean d;

    public asb()
    {
        this(null);
    }

    private asb(asq asq1)
    {
        a = null;
    }

    public final int a(byte abyte0[], int i, int j)
    {
        if (c == 0L)
        {
            i = -1;
        } else
        {
            try
            {
                j = b.read(abyte0, i, (int)Math.min(c, j));
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new asc(abyte0);
            }
            i = j;
            if (j > 0)
            {
                c = c - (long)j;
                i = j;
                if (a != null)
                {
                    a.a(j);
                    return j;
                }
            }
        }
        return i;
    }

    public final long a(arx arx1)
    {
        long l;
        b = new RandomAccessFile(arx1.a.getPath(), "r");
        b.seek(arx1.d);
        if (arx1.e != -1L)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        l = b.length() - arx1.d;
_L1:
        c = l;
        d = true;
        if (a != null)
        {
            a.b();
        }
        return c;
        try
        {
            l = arx1.e;
        }
        // Misplaced declaration of an exception variable
        catch (arx arx1)
        {
            throw new asc(arx1);
        }
          goto _L1
    }

    public final void a()
    {
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        b.close();
        b = null;
        if (d)
        {
            d = false;
            if (a != null)
            {
                a.c();
            }
        }
        return;
        Object obj;
        obj;
        throw new asc(((IOException) (obj)));
        obj;
        b = null;
        if (d)
        {
            d = false;
            if (a != null)
            {
                a.c();
            }
        }
        throw obj;
    }
}
