// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.commons.httpclient:
//            ResponseConsumedWatcher

class AutoCloseInputStream extends FilterInputStream
{

    private boolean selfClosed;
    private boolean streamOpen;
    private ResponseConsumedWatcher watcher;

    public AutoCloseInputStream(InputStream inputstream, ResponseConsumedWatcher responseconsumedwatcher)
    {
        super(inputstream);
        streamOpen = true;
        selfClosed = false;
        watcher = null;
        watcher = responseconsumedwatcher;
    }

    private void checkClose(int i)
        throws IOException
    {
        if (i == -1)
        {
            notifyWatcher();
        }
    }

    private boolean isReadAllowed()
        throws IOException
    {
        if (!streamOpen && selfClosed)
        {
            throw new IOException("Attempted read on closed stream.");
        } else
        {
            return streamOpen;
        }
    }

    private void notifyWatcher()
        throws IOException
    {
        if (streamOpen)
        {
            super.close();
            streamOpen = false;
            if (watcher != null)
            {
                watcher.responseConsumed();
            }
        }
    }

    public int available()
        throws IOException
    {
        int i = 0;
        if (isReadAllowed())
        {
            i = super.available();
        }
        return i;
    }

    public void close()
        throws IOException
    {
        if (!selfClosed)
        {
            selfClosed = true;
            notifyWatcher();
        }
    }

    public int read()
        throws IOException
    {
        int i = -1;
        if (isReadAllowed())
        {
            i = super.read();
            checkClose(i);
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i = -1;
        if (isReadAllowed())
        {
            i = super.read(abyte0);
            checkClose(i);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = -1;
        if (isReadAllowed())
        {
            k = super.read(abyte0, i, j);
            checkClose(k);
        }
        return k;
    }
}
