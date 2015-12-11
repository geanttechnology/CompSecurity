// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
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
        return i + j;
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
        if (buffer == null || !buffer.hasArray())
        {
            return;
        }
        ByteBuffer bytebuffer = buffer;
        bytebuffer;
        JVM INSTR monitorenter ;
        int i = impl.read(buffer.array(), 0, buffer.capacity());
_L3:
        if (i > 0) goto _L2; else goto _L1
_L1:
        buffer.limit(0);
_L5:
        bytebuffer;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        bytebuffer;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        log.error(((IOException) (obj)).toString());
        i = 0;
          goto _L3
_L2:
        if (i >= buffer.capacity()) goto _L5; else goto _L4
_L4:
        buffer.limit(i);
          goto _L5
    }

    public String getBufferAsString()
    {
        if (buffer == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        ByteBuffer bytebuffer = buffer;
        bytebuffer;
        JVM INSTR monitorenter ;
        byte abyte0[] = new byte[buffer.limit()];
        int i = 0;
_L2:
        if (i >= buffer.limit())
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0[i] = buffer.get(i);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s = new String(abyte0);
        bytebuffer;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        bytebuffer;
        JVM INSTR monitorexit ;
        throw exception;
        return "";
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
        if (!enableBuffering) goto _L2; else goto _L1
_L1:
        Object obj = buffer;
        obj;
        JVM INSTR monitorenter ;
        int i;
        if (!bufferHasBytes(1L))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = readBuffer();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        count = count + 1L;
        obj;
        JVM INSTR monitorexit ;
        return i;
        obj;
        JVM INSTR monitorexit ;
_L2:
        try
        {
            i = impl.read();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            notifyStreamError(((Exception) (obj)));
            throw obj;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        count = count + 1L;
        return i;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        notifyStreamComplete();
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i;
        int j;
        int k;
        boolean flag;
        j = 0;
        flag = false;
        k = abyte0.length;
        i = k;
        if (!enableBuffering) goto _L2; else goto _L1
_L1:
        ByteBuffer bytebuffer = buffer;
        bytebuffer;
        JVM INSTR monitorenter ;
        long l1 = k;
        if (!bufferHasBytes(l1))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        i = readBufferBytes(abyte0);
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        count = count + (long)i;
        bytebuffer;
        JVM INSTR monitorexit ;
        return i;
        throw new IOException("readBufferBytes failed");
        abyte0;
        bytebuffer;
        JVM INSTR monitorexit ;
        throw abyte0;
        int l = buffer.remaining();
        i = k;
        j = ((flag) ? 1 : 0);
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        j = readBufferBytes(abyte0, 0, l);
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        throw new IOException("partial read from buffer failed");
        i = k - j;
        count = count + (long)j;
        bytebuffer;
        JVM INSTR monitorexit ;
_L2:
        try
        {
            i = impl.read(abyte0, j, i);
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
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        count = count + (long)i;
        return i + j;
        if (j > 0)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        notifyStreamComplete();
        return i;
        return j;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k;
        int l;
        boolean flag;
        k = 0;
        flag = false;
        l = j;
        if (!enableBuffering) goto _L2; else goto _L1
_L1:
        ByteBuffer bytebuffer = buffer;
        bytebuffer;
        JVM INSTR monitorenter ;
        long l1 = j;
        if (!bufferHasBytes(l1))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        i = readBufferBytes(abyte0, i, j);
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        count = count + (long)i;
        bytebuffer;
        JVM INSTR monitorexit ;
        return i;
        throw new IOException("readBufferBytes failed");
        abyte0;
        bytebuffer;
        JVM INSTR monitorexit ;
        throw abyte0;
        int i1 = buffer.remaining();
        k = ((flag) ? 1 : 0);
        l = j;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        k = readBufferBytes(abyte0, i, i1);
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        throw new IOException("partial read from buffer failed");
        l = j - k;
        count = count + (long)k;
        bytebuffer;
        JVM INSTR monitorexit ;
_L2:
        try
        {
            i = impl.read(abyte0, i + k, l);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            notifyStreamError(abyte0);
            throw abyte0;
        }
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        count = count + (long)i;
        return i + k;
        if (k > 0)
        {
            break MISSING_BLOCK_LABEL_203;
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
        long l1;
        l1 = l;
        if (enableBuffering)
        {
label0:
            {
                synchronized (buffer)
                {
                    if (!bufferHasBytes(l))
                    {
                        break label0;
                    }
                    buffer.position((int)l);
                    count = count + l;
                }
                return l;
            }
        }
          goto _L1
        l1 = l - (long)buffer.remaining();
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        buffer.position(buffer.remaining());
        obj;
        JVM INSTR monitorexit ;
_L1:
        try
        {
            l = impl.skip(l1);
            count = count + l;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            notifyStreamError(((Exception) (obj)));
            throw obj;
        }
        return l;
        throw new IOException("partial read from buffer (skip) failed");
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
