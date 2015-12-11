// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.communication:
//            IInputStream

public class ServiceSideInputStreamProxy extends InputStream
    implements android.os.IBinder.DeathRecipient
{

    public static final int MAX_ALLOWED_BYTES_READ_ACROSS_IPC = 0x19000;
    private static final DPLogger log = new DPLogger("TComm.ServiceSideInputStreamProxy");
    private IInputStream mInputStream;

    public ServiceSideInputStreamProxy(IInputStream iinputstream)
    {
        mInputStream = iinputstream;
        iinputstream = iinputstream.asBinder();
        try
        {
            iinputstream.linkToDeath(this, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IInputStream iinputstream)
        {
            log.verbose("constructor", "Binder has already died.  Swallowing and allowing read call path to discover this", new Object[] {
                iinputstream
            });
        }
        binderDied();
    }

    public int available()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (mInputStream == null)
        {
            log.warn("available", "Client-side callback object is now stale", new Object[0]);
            throw new IOException("Client-side callback object is now stale");
        }
        break MISSING_BLOCK_LABEL_38;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        IInputStream iinputstream = mInputStream;
        this;
        JVM INSTR monitorexit ;
        int i;
        try
        {
            i = iinputstream.available();
        }
        catch (RemoteException remoteexception)
        {
            throw new IOException(remoteexception);
        }
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        throw new IOException("IOException in client-side InputStream");
        if (i != -3)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        throw new IOException("Client caused exception on application side - ignore");
        return i;
    }

    public void binderDied()
    {
        this;
        JVM INSTR monitorenter ;
        mInputStream = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (mInputStream == null)
        {
            log.warn("close", "Client-side callback object is now stale", new Object[0]);
            throw new IOException("Client-side callback object is now stale");
        }
        break MISSING_BLOCK_LABEL_38;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        IInputStream iinputstream = mInputStream;
        this;
        JVM INSTR monitorexit ;
        boolean flag;
        flag = iinputstream.close();
        iinputstream.asBinder().unlinkToDeath(this, 0);
        this;
        JVM INSTR monitorenter ;
        mInputStream = null;
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            try
            {
                throw new IOException("IOException in client-side InputStream");
            }
            // Misplaced declaration of an exception variable
            catch (IInputStream iinputstream)
            {
                throw new IOException(iinputstream);
            }
        }
        break MISSING_BLOCK_LABEL_104;
        iinputstream;
        this;
        JVM INSTR monitorexit ;
        throw iinputstream;
    }

    public int read()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (mInputStream == null)
        {
            log.warn("read()", "Client-side callback object is now stale", new Object[0]);
            throw new IOException("Client-side callback object is now stale");
        }
        break MISSING_BLOCK_LABEL_38;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        IInputStream iinputstream = mInputStream;
        this;
        JVM INSTR monitorexit ;
        int i;
        try
        {
            i = iinputstream.readByte();
        }
        catch (RemoteException remoteexception)
        {
            throw new IOException(remoteexception);
        }
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        throw new IOException("IOException in client-side InputStream");
        if (i != -3)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        throw new IOException("Client caused exception on application side - ignore");
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
        if (i < 0 || j < 0 || i > abyte0.length)
        {
            throw new IndexOutOfBoundsException(DPFormattedMessage.toDPFormat("read(byte[],int,int)", "Index out of bounds", new Object[] {
                "array.length", Integer.valueOf(abyte0.length), "offset", Integer.valueOf(i), "length", Integer.valueOf(j)
            }));
        }
        if (j != 0) goto _L2; else goto _L1
_L1:
        j = 0;
_L6:
        return j;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (mInputStream == null)
        {
            log.warn("read(byte[],int,int)", "Client-side callback object is now stale", new Object[0]);
            throw new IOException("Client-side callback object is now stale");
        }
        break MISSING_BLOCK_LABEL_117;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        IInputStream iinputstream = mInputStream;
        this;
        JVM INSTR monitorexit ;
        int k = 0;
_L4:
        int l;
        int k1;
        if (j > 0x19000)
        {
            l = 0x19000;
        } else
        {
            l = j;
        }
        log.debug("read(byte[],int,int)", "About to read", new Object[] {
            "bytesToRead", Integer.valueOf(l), "Size of buffer", Integer.valueOf(abyte0.length), "totalBytesRead", Integer.valueOf(k), "remainingBytesToRead", Integer.valueOf(j)
        });
        k1 = iinputstream.readBytesIntoOffset(abyte0, i + k, l);
        if (k1 == -2)
        {
            try
            {
                throw new IOException("IOException in client-side InputStream");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                log.error("read(byte[],int,int)", "RemoteException occurred reading from InputStream", new Object[] {
                    abyte0
                });
            }
            throw new IOException(abyte0);
        }
        if (k1 != -3)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        throw new IOException("Client caused exception on application side - ignore");
        if (k1 == -1)
        {
            if (k > 0)
            {
                return k;
            } else
            {
                return k1;
            }
        }
        int i1 = k + k1;
        int j1 = j - k1;
        j = i1;
        if (k1 < l)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = j1;
        k = i1;
        if (j1 <= 0)
        {
            return i1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

}
