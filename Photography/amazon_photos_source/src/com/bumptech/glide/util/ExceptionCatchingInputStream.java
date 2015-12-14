// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.util:
//            Util

public class ExceptionCatchingInputStream extends InputStream
{

    private static final Queue QUEUE = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    ExceptionCatchingInputStream()
    {
    }

    public static ExceptionCatchingInputStream obtain(InputStream inputstream)
    {
        ExceptionCatchingInputStream exceptioncatchinginputstream;
        synchronized (QUEUE)
        {
            exceptioncatchinginputstream = (ExceptionCatchingInputStream)QUEUE.poll();
        }
        obj = exceptioncatchinginputstream;
        if (exceptioncatchinginputstream == null)
        {
            obj = new ExceptionCatchingInputStream();
        }
        ((ExceptionCatchingInputStream) (obj)).setInputStream(inputstream);
        return ((ExceptionCatchingInputStream) (obj));
        inputstream;
        obj;
        JVM INSTR monitorexit ;
        throw inputstream;
    }

    public int available()
        throws IOException
    {
        return wrapped.available();
    }

    public void close()
        throws IOException
    {
        wrapped.close();
    }

    public IOException getException()
    {
        return exception;
    }

    public void mark(int i)
    {
        wrapped.mark(i);
    }

    public boolean markSupported()
    {
        return wrapped.markSupported();
    }

    public int read()
        throws IOException
    {
        int i;
        try
        {
            i = wrapped.read();
        }
        catch (IOException ioexception)
        {
            exception = ioexception;
            return -1;
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i;
        try
        {
            i = wrapped.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            exception = abyte0;
            return -1;
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        try
        {
            i = wrapped.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            exception = abyte0;
            return -1;
        }
        return i;
    }

    public void release()
    {
        exception = null;
        wrapped = null;
        synchronized (QUEUE)
        {
            QUEUE.offer(this);
        }
        return;
        exception1;
        queue;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public void reset()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        wrapped.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        throw exception1;
    }

    void setInputStream(InputStream inputstream)
    {
        wrapped = inputstream;
    }

    public long skip(long l)
        throws IOException
    {
        try
        {
            l = wrapped.skip(l);
        }
        catch (IOException ioexception)
        {
            exception = ioexception;
            return 0L;
        }
        return l;
    }

}
