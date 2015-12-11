// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Encoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.newrelic.agent.android.instrumentation.io:
//            StreamCompleteListenerSource, StreamCompleteListenerManager, StreamCompleteEvent, StreamCompleteListener

public final class CountingInputStream extends InputStream
    implements StreamCompleteListenerSource
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final ByteBuffer buffer;
    private long count;
    private boolean enableBuffering;
    private final InputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    public CountingInputStream(InputStream inputstream)
    {
        count = 0L;
        listenerManager = new StreamCompleteListenerManager();
        enableBuffering = false;
        impl = inputstream;
        if (enableBuffering)
        {
            buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        } else
        {
            buffer = null;
            return;
        }
    }

    public CountingInputStream(InputStream inputstream, boolean flag)
    {
        count = 0L;
        listenerManager = new StreamCompleteListenerManager();
        enableBuffering = false;
        impl = inputstream;
        enableBuffering = flag;
        if (flag)
        {
            buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        } else
        {
            buffer = null;
            return;
        }
    }

    private boolean bufferEmpty()
    {
        return !buffer.hasRemaining();
    }

    private boolean bufferHasBytes(long l)
    {
        return (long)buffer.remaining() >= l;
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

    private int readBuffer()
    {
        if (bufferEmpty())
        {
            return -1;
        } else
        {
            return buffer.get();
        }
    }

    private int readBufferBytes(byte abyte0[])
    {
        return readBufferBytes(abyte0, 0, abyte0.length);
    }

    private int readBufferBytes(byte abyte0[], int i, int j)
    {
        if (bufferEmpty())
        {
            return -1;
        } else
        {
            int k = buffer.remaining();
            buffer.get(abyte0, i, j);
            return k - buffer.remaining();
        }
    }

    public void addStreamCompleteListener(StreamCompleteListener streamcompletelistener)
    {
        listenerManager.addStreamCompleteListener(streamcompletelistener);
    }

    public int available()
        throws IOException
    {
        int i = 0;
        if (enableBuffering)
        {
            i = buffer.remaining();
        }
        int j;
        try
        {
            j = impl.available();
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
        return j + i;
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

    public void fillBuffer()
    {
        if (buffer != null && buffer.hasArray()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
        int j = impl.read(buffer.array(), 0, buffer.capacity());
        i = j;
_L4:
        if (i <= 0)
        {
            buffer.limit(0);
            return;
        }
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        log.error(ioexception.toString());
        if (true) goto _L4; else goto _L3
_L3:
        if (i >= buffer.capacity()) goto _L1; else goto _L5
_L5:
        buffer.limit(i);
        return;
    }

    public String getBufferAsString()
    {
        if (buffer != null)
        {
            byte abyte0[] = new byte[buffer.limit()];
            for (int i = 0; i < buffer.limit(); i++)
            {
                abyte0[i] = buffer.get(i);
            }

            return Agent.getEncoder().encode(abyte0);
        } else
        {
            return "";
        }
    }

    public void mark(int i)
    {
        if (!markSupported())
        {
            return;
        } else
        {
            impl.mark(i);
            return;
        }
    }

    public boolean markSupported()
    {
        return impl.markSupported();
    }

    public int read()
        throws IOException
    {
        int j;
        if (enableBuffering && bufferHasBytes(1L))
        {
            int i = readBuffer();
            if (i >= 0)
            {
                count = count + 1L;
            }
            return i;
        }
        try
        {
            j = impl.read();
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        count = count + 1L;
        break MISSING_BLOCK_LABEL_76;
        notifyStreamComplete();
        return j;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        boolean flag = false;
        int k = abyte0.length;
        int j = k;
        int i = ((flag) ? 1 : 0);
        if (enableBuffering)
        {
            if (bufferHasBytes(k))
            {
                i = readBufferBytes(abyte0);
                if (i >= 0)
                {
                    count = count + (long)i;
                    return i;
                } else
                {
                    throw new RuntimeException("readBufferBytes failed");
                }
            }
            int l = buffer.remaining();
            j = k;
            i = ((flag) ? 1 : 0);
            if (l > 0)
            {
                i = readBufferBytes(abyte0, 0, l);
                if (i < 0)
                {
                    throw new RuntimeException("partial read from buffer failed");
                }
                j = k - i;
                count = count + (long)i;
            }
        }
        try
        {
            j = impl.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            log.error(abyte0.toString());
            System.out.println((new StringBuilder()).append("NOTIFY STREAM ERROR: ").append(abyte0).toString());
            abyte0.printStackTrace();
            notifyStreamError(abyte0);
            throw abyte0;
        }
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        count = count + (long)j;
        return j + i;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        notifyStreamComplete();
        return j;
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        boolean flag = false;
        int l = j;
        int i1 = l;
        int k = ((flag) ? 1 : 0);
        if (enableBuffering)
        {
            if (bufferHasBytes(l))
            {
                i = readBufferBytes(abyte0, i, j);
                if (i >= 0)
                {
                    count = count + (long)i;
                    return i;
                } else
                {
                    throw new RuntimeException("readBufferBytes failed");
                }
            }
            j = buffer.remaining();
            i1 = l;
            k = ((flag) ? 1 : 0);
            if (j > 0)
            {
                k = readBufferBytes(abyte0, i, j);
                if (k < 0)
                {
                    throw new RuntimeException("partial read from buffer failed");
                }
                i1 = l - k;
                count = count + (long)k;
            }
        }
        try
        {
            i = impl.read(abyte0, i + k, i1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            notifyStreamError(abyte0);
            throw abyte0;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        count = count + (long)i;
        return i + k;
        if (k > 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        notifyStreamComplete();
        return i;
        return k;
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamcompletelistener)
    {
        listenerManager.removeStreamCompleteListener(streamcompletelistener);
    }

    public void reset()
        throws IOException
    {
        if (!markSupported())
        {
            return;
        }
        try
        {
            impl.reset();
            return;
        }
        catch (IOException ioexception)
        {
            notifyStreamError(ioexception);
            throw ioexception;
        }
    }

    public void setBufferingEnabled(boolean flag)
    {
        enableBuffering = flag;
    }

    public long skip(long l)
        throws IOException
    {
label0:
        {
            long l1 = l;
            if (enableBuffering)
            {
                if (bufferHasBytes(l))
                {
                    buffer.position((int)l);
                    count = count + l;
                    return l;
                }
                l1 = l - (long)buffer.remaining();
                if (l1 <= 0L)
                {
                    break label0;
                }
                buffer.position(buffer.remaining());
            }
            try
            {
                l = impl.skip(l1);
                count = count + l;
            }
            catch (IOException ioexception)
            {
                notifyStreamError(ioexception);
                throw ioexception;
            }
            return l;
        }
        throw new RuntimeException("partial read from buffer (skip) failed");
    }

}
