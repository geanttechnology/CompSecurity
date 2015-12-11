// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            ConnectionReleaseTrigger, EofSensorWatcher

public class EofSensorInputStream extends InputStream
    implements ConnectionReleaseTrigger
{

    private final EofSensorWatcher eofWatcher;
    private boolean selfClosed;
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream inputstream, EofSensorWatcher eofsensorwatcher)
    {
        Args.notNull(inputstream, "Wrapped stream");
        wrappedStream = inputstream;
        selfClosed = false;
        eofWatcher = eofsensorwatcher;
    }

    public void abortConnection()
        throws IOException
    {
        selfClosed = true;
        checkAbort();
    }

    public int available()
        throws IOException
    {
        int i = 0;
        if (isReadAllowed())
        {
            try
            {
                i = wrappedStream.available();
            }
            catch (IOException ioexception)
            {
                checkAbort();
                throw ioexception;
            }
        }
        return i;
    }

    protected void checkAbort()
        throws IOException
    {
        boolean flag;
        if (wrappedStream == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        flag = true;
        if (eofWatcher != null)
        {
            flag = eofWatcher.streamAbort(wrappedStream);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        wrappedStream.close();
        wrappedStream = null;
        return;
        Exception exception;
        exception;
        wrappedStream = null;
        throw exception;
    }

    protected void checkClose()
        throws IOException
    {
        boolean flag;
        if (wrappedStream == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        flag = true;
        if (eofWatcher != null)
        {
            flag = eofWatcher.streamClosed(wrappedStream);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        wrappedStream.close();
        wrappedStream = null;
        return;
        Exception exception;
        exception;
        wrappedStream = null;
        throw exception;
    }

    protected void checkEOF(int i)
        throws IOException
    {
        boolean flag;
        if (wrappedStream == null || i >= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        flag = true;
        if (eofWatcher != null)
        {
            flag = eofWatcher.eofDetected(wrappedStream);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        wrappedStream.close();
        wrappedStream = null;
        return;
        Exception exception;
        exception;
        wrappedStream = null;
        throw exception;
    }

    public void close()
        throws IOException
    {
        selfClosed = true;
        checkClose();
    }

    InputStream getWrappedStream()
    {
        return wrappedStream;
    }

    protected boolean isReadAllowed()
        throws IOException
    {
        if (selfClosed)
        {
            throw new IOException("Attempted read on closed stream.");
        }
        return wrappedStream != null;
    }

    boolean isSelfClosed()
    {
        return selfClosed;
    }

    public int read()
        throws IOException
    {
        int i = -1;
        if (isReadAllowed())
        {
            try
            {
                i = wrappedStream.read();
                checkEOF(i);
            }
            catch (IOException ioexception)
            {
                checkAbort();
                throw ioexception;
            }
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = -1;
        if (isReadAllowed())
        {
            try
            {
                k = wrappedStream.read(abyte0, i, j);
                checkEOF(k);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                checkAbort();
                throw abyte0;
            }
        }
        return k;
    }

    public void releaseConnection()
        throws IOException
    {
        close();
    }
}
