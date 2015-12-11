// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPEventLog, TPCFHttp

public class TPFilterInputStream extends FilterInputStream
{

    String error_message;
    boolean isClosed;
    int totalBytes;
    TPEventLog tpEventLog;
    TPCFHttp tpcfHttp;

    protected TPFilterInputStream(InputStream inputstream, TPEventLog tpeventlog, TPCFHttp tpcfhttp)
    {
        super(inputstream);
        isClosed = false;
        totalBytes = 0;
        tpEventLog = tpeventlog;
        tpcfHttp = tpcfhttp;
    }

    public void close()
        throws IOException
    {
        if (isClosed)
        {
            return;
        }
        isClosed = true;
        if (tpEventLog != null)
        {
            tpEventLog.data_completed_time = (int)((new Date()).getTime() - tpEventLog.start_time);
            tpEventLog.bytes_downloaded = totalBytes;
            if (error_message == null)
            {
                tpEventLog.error_string = "Success";
            } else
            {
                tpEventLog.error_string = error_message;
            }
            tpEventLog.endLoggingEvent();
        }
        if (tpcfHttp != null)
        {
            tpcfHttp.releasePort();
        }
        in.close();
    }

    public void mark(int i)
        throws UnsupportedOperationException
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        if (!isClosed) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        int j;
        try
        {
            j = in.read();
        }
        catch (IOException ioexception)
        {
            error_message = ioexception.getMessage();
            close();
            throw ioexception;
        }
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        totalBytes = totalBytes + 1;
_L5:
        i = j;
        if (tpEventLog == null) goto _L4; else goto _L3
_L3:
        tpEventLog.storePktTimeSeries(j);
        return j;
        close();
          goto _L5
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (!isClosed) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        try
        {
            j = in.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            error_message = abyte0.getMessage();
            close();
            throw abyte0;
        }
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        totalBytes = totalBytes + j;
_L5:
        i = j;
        if (tpEventLog == null) goto _L4; else goto _L3
_L3:
        tpEventLog.storePktTimeSeries(j);
        return j;
        close();
          goto _L5
    }

    public void reset()
        throws IOException, UnsupportedOperationException
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
