// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.newrelic.agent.android.instrumentation.io:
//            StreamCompleteListenerSource, StreamCompleteListenerManager, StreamCompleteEvent, StreamCompleteListener

public final class CountingOutputStream extends OutputStream
    implements StreamCompleteListenerSource
{

    private long count;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

    public CountingOutputStream(OutputStream outputstream)
    {
        count = 0L;
        impl = outputstream;
    }

    private void notifyStreamComplete()
    {
        if (!listenerManager.isComplete())
        {
            listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, count));
        }
    }

    private void notifyStreamError(Exception exception)
    {
        if (!listenerManager.isComplete())
        {
            listenerManager.notifyStreamError(new StreamCompleteEvent(this, count, exception));
        }
    }

    public void addStreamCompleteListener(StreamCompleteListener streamcompletelistener)
    {
        listenerManager.addStreamCompleteListener(streamcompletelistener);
    }

    public void close()
        throws IOException
    {
        try
        {
            impl.close();
            notifyStreamComplete();
            return;
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
    }

    public void flush()
        throws IOException
    {
        try
        {
            impl.flush();
            return;
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
    }

    public long getCount()
    {
        return count;
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamcompletelistener)
    {
        listenerManager.removeStreamCompleteListener(streamcompletelistener);
    }

    public void write(int i)
        throws IOException
    {
        try
        {
            impl.write(i);
            count = count + 1L;
            return;
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        try
        {
            impl.write(abyte0);
            count = count + (long)abyte0.length;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            notifyStreamError(abyte0);
        }
        throw abyte0;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        try
        {
            impl.write(abyte0, i, j);
            count = count + (long)j;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            notifyStreamError(abyte0);
        }
        throw abyte0;
    }
}
