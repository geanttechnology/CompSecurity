// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Referenced classes of package com.amazon.device.ads:
//            bl, co, cn

class bn extends bl
{

    private static final String d = com/amazon/device/ads/bn.getSimpleName();
    final cn b;
    InputStream c;
    private BufferedReader e;

    bn()
    {
        new co();
        b = co.a(d);
    }

    private void i()
    {
        if (e == null)
        {
            throw new IllegalStateException("Could not read from the file because no file has been opened yet. Please set the file, then call open() before attempting to read.");
        } else
        {
            return;
        }
    }

    public void close()
    {
        c();
        e = null;
        c = null;
    }

    protected final Closeable d()
    {
        return c;
    }

    protected final Closeable e()
    {
        return e;
    }

    public final boolean f()
    {
        if (a == null)
        {
            b.d("A file must be set before it can be opened.", null);
            return false;
        }
        if (c != null)
        {
            b.d("The file is already open.", null);
            return false;
        }
        FileInputStream fileinputstream;
        try
        {
            fileinputstream = new FileInputStream(a);
        }
        catch (Exception exception)
        {
            return false;
        }
        c = new BufferedInputStream(fileinputstream);
        e = new BufferedReader(new InputStreamReader(c));
        return true;
    }

    public final byte[] g()
    {
        i();
        byte abyte0[];
        int j;
        int k;
        try
        {
            abyte0 = new byte[(int)a.length()];
        }
        catch (IOException ioexception)
        {
            b.d("Error reading bytes from input file: %s", new Object[] {
                ioexception.getMessage()
            });
            return null;
        }
        j = 0;
        if (j >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        k = abyte0.length;
        k = c.read(abyte0, j, k - j);
        if (k > 0)
        {
            j += k;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        return abyte0;
    }

    public final String h()
    {
        i();
        String s;
        try
        {
            s = e.readLine();
        }
        catch (IOException ioexception)
        {
            b.d("Error reading line from file.", null);
            return null;
        }
        return s;
    }

}
