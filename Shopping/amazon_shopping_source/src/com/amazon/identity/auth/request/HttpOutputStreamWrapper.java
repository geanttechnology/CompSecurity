// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;

public class HttpOutputStreamWrapper extends OutputStream
{

    private static final Object SYNC_OBEJCT[] = new Object[0];
    private final ByteArrayOutputStream mCollector = new ByteArrayOutputStream();
    private final URLConnection mConnection;
    private OutputStream mOutputStream;

    public HttpOutputStreamWrapper(URLConnection urlconnection)
    {
        mConnection = urlconnection;
    }

    public void close()
        throws IOException
    {
        if (mOutputStream != null)
        {
            mOutputStream.close();
        }
        super.close();
    }

    public void flush()
        throws IOException
    {
        if (mOutputStream != null)
        {
            mOutputStream.flush();
        }
        super.flush();
    }

    public void flushToUnderlyingStream()
        throws IOException
    {
        synchronized (SYNC_OBEJCT)
        {
            mOutputStream = mConnection.getOutputStream();
            mOutputStream.write(mCollector.toByteArray());
            flush();
        }
    }

    public byte[] getCurrentBytes()
    {
        byte abyte0[];
        synchronized (SYNC_OBEJCT)
        {
            abyte0 = mCollector.toByteArray();
        }
        return abyte0;
    }

    public void write(int i)
        throws IOException
    {
        Object aobj[] = SYNC_OBEJCT;
        aobj;
        JVM INSTR monitorenter ;
        if (mOutputStream == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        mOutputStream.write(i);
_L2:
        return;
        mCollector.write(i);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

}
