// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AsyncHttpClient, LogInterface

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "DataAsyncHttpRH";
    protected static final int PROGRESS_DATA_MESSAGE = 7;

    public DataAsyncHttpResponseHandler()
    {
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
        throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = abyte0.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, k);
            return abyte1;
        }
    }

    byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        byte abyte0[];
        InputStream inputstream;
        long l;
        Object obj = null;
        abyte0 = obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        inputstream = httpentity.getContent();
        abyte0 = obj;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        long l1 = httpentity.getContentLength();
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        l = l1;
        if (l1 < 0L)
        {
            l = 4096L;
        }
        httpentity = new ByteArrayBuffer((int)l);
        abyte0 = new byte[4096];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        httpentity.append(abyte0, 0, i);
        sendProgressDataMessage(copyOfRange(abyte0, 0, i));
        sendProgressMessage(0, l);
          goto _L1
        httpentity;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            throw httpentity;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        AsyncHttpClient.silentCloseInputStream(inputstream);
        abyte0 = httpentity.toByteArray();
        return abyte0;
    }

    protected void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 7: // '\007'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        if (message != null && message.length >= 1)
        {
            try
            {
                onProgressData((byte[])(byte[])message[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                AsyncHttpClient.log.e("DataAsyncHttpRH", "custom onProgressData contains an error", message);
            }
            return;
        } else
        {
            AsyncHttpClient.log.e("DataAsyncHttpRH", "PROGRESS_DATA_MESSAGE didn't got enough params");
            return;
        }
    }

    public void onProgressData(byte abyte0[])
    {
        AsyncHttpClient.log.d("DataAsyncHttpRH", "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte abyte0[])
    {
        sendMessage(obtainMessage(7, ((Object) (new Object[] {
            abyte0
        }))));
    }
}
