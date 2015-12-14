// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.packetzoom.speed:
//            k

public class j extends InputStream
{

    private long a_long_fld;
    private k a_com_packetzoom_speed_k_fld;
    private InputStream a_java_io_InputStream_fld;

    j(InputStream inputstream, k k1)
    {
        a_long_fld = 0L;
        a_java_io_InputStream_fld = inputstream;
        a_com_packetzoom_speed_k_fld = k1;
    }

    public int available()
    {
        int i;
        try
        {
            i = a_java_io_InputStream_fld.available();
        }
        catch (IOException ioexception)
        {
            a_com_packetzoom_speed_k_fld.a(ioexception, a_long_fld);
            throw ioexception;
        }
        return i;
    }

    public void close()
    {
        try
        {
            a_java_io_InputStream_fld.close();
            a_com_packetzoom_speed_k_fld.a(a_long_fld);
            return;
        }
        catch (IOException ioexception)
        {
            a_com_packetzoom_speed_k_fld.a(ioexception, a_long_fld);
            throw ioexception;
        }
    }

    public void mark(int i)
    {
        a_java_io_InputStream_fld.mark(i);
    }

    public boolean markSupported()
    {
        return a_java_io_InputStream_fld.markSupported();
    }

    public int read()
    {
        int i;
        try
        {
            i = a_java_io_InputStream_fld.read();
        }
        catch (IOException ioexception)
        {
            a_com_packetzoom_speed_k_fld.a(ioexception, a_long_fld);
            throw ioexception;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        a_long_fld = a_long_fld + (long)i;
        return i;
        a_com_packetzoom_speed_k_fld.a(a_long_fld);
        return i;
    }

    public int read(byte abyte0[])
    {
        int i;
        try
        {
            i = a_java_io_InputStream_fld.read(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a_com_packetzoom_speed_k_fld.a(abyte0, a_long_fld);
            throw abyte0;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        a_long_fld = a_long_fld + (long)i;
        return i;
        a_com_packetzoom_speed_k_fld.a(a_long_fld);
        return i;
    }

    public int read(byte abyte0[], int i, int l)
    {
        try
        {
            i = a_java_io_InputStream_fld.read(abyte0, i, l);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a_com_packetzoom_speed_k_fld.a(abyte0, a_long_fld);
            throw abyte0;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        a_long_fld = a_long_fld + (long)i;
        return i;
        a_com_packetzoom_speed_k_fld.a(a_long_fld);
        return i;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        a_java_io_InputStream_fld.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a_com_packetzoom_speed_k_fld.a(((Exception) (obj)), a_long_fld);
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public long skip(long l)
    {
        return a_java_io_InputStream_fld.skip(l);
    }
}
