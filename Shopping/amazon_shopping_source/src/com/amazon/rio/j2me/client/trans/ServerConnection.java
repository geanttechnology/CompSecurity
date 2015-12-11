// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.trans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.rio.j2me.client.trans:
//            IServiceConnection

public abstract class ServerConnection
    implements IServiceConnection
{

    public final Object CANCELLED_STATE = "CANCELLED";
    public final Object CLOSED_STATE = "CLOSED";
    public final Object EXECUTING_STATE = "EXECUTING";
    public final Object INVOKED_STATE = "INVOKED";
    public final Object READY_STATE = "READY";
    private Object state;
    private final String url;

    protected ServerConnection(String s)
    {
        state = READY_STATE;
        url = s;
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = state;
        obj1 = CLOSED_STATE;
        if (obj != obj1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        releaseNetworkConnection();
        state = CANCELLED_STATE;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = state;
        obj1 = CLOSED_STATE;
        if (obj != obj1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        releaseNetworkConnection();
        state = CLOSED_STATE;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract InputStream getInputStream()
        throws IOException;

    protected abstract OutputStream getOutputStream()
        throws IOException;

    public String getUrl()
    {
        return url;
    }

    protected abstract void initializeNetworkConnection(int i)
        throws IOException;

    protected abstract void releaseNetworkConnection();

    public InputStream send(byte abyte0[][])
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (state != READY_STATE)
        {
            throw new IOException((new StringBuilder()).append("ServerConnection.send() bad state.  Expected state=\"").append(READY_STATE).append("\": ").append(this).toString());
        }
        break MISSING_BLOCK_LABEL_57;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        state = EXECUTING_STATE;
        int i;
        int k;
        k = 0;
        i = 0;
_L2:
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        k += abyte0[i].length;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        initializeNetworkConnection(k);
        this;
        JVM INSTR monitorexit ;
        OutputStream outputstream = getOutputStream();
        for (int j = 0; j < abyte0.length; j++)
        {
            if (abyte0[j] != null && abyte0[j].length > 0)
            {
                outputstream.write(abyte0[j]);
            }
        }

        outputstream.flush();
        this;
        JVM INSTR monitorenter ;
        if (state != EXECUTING_STATE)
        {
            throw new IOException((new StringBuilder()).append("ServerConnection.send() bad state.  Expected state=\"").append(EXECUTING_STATE).append("\": ").append(this).toString());
        }
        break MISSING_BLOCK_LABEL_201;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        state = INVOKED_STATE;
        this;
        JVM INSTR monitorexit ;
        return getInputStream();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append("url=").append(url);
        stringbuffer.append(", ").append("state=").append(state);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }
}
