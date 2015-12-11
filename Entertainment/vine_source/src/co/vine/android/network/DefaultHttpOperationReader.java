// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package co.vine.android.network:
//            HttpOperationReader, CountingOutputStream, ProgressListener, HttpResult

public class DefaultHttpOperationReader
    implements HttpOperationReader
{

    private final byte mBuffer[];
    private final OutputStream mOutputStream;
    private final ProgressListener mProgressListener;

    public DefaultHttpOperationReader()
    {
        this(null, null);
    }

    public DefaultHttpOperationReader(OutputStream outputstream, ProgressListener progresslistener)
    {
        mBuffer = new byte[2048];
        mOutputStream = outputstream;
        mProgressListener = progresslistener;
    }

    public void onHandleError(HttpResult httpresult)
    {
    }

    public final void readInput(int i, int j, InputStream inputstream)
        throws IOException
    {
        Object obj;
        byte abyte0[];
        Exception exception;
        if (mOutputStream != null && mProgressListener != null)
        {
            obj = new CountingOutputStream(mOutputStream, j, mProgressListener);
        } else
        {
            obj = mOutputStream;
        }
        abyte0 = mBuffer;
        if (j >= 0) goto _L2; else goto _L1
_L1:
        i = inputstream.read(abyte0, 0, abyte0.length);
        if (i == -1) goto _L4; else goto _L3
_L3:
        if (obj == null) goto _L1; else goto _L5
_L5:
        ((OutputStream) (obj)).write(abyte0, 0, i);
          goto _L1
        exception;
        while (inputstream.read(abyte0, 0, abyte0.length) != -1) ;
        int k;
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).flush();
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        throw exception;
_L2:
        i = j;
_L6:
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = inputstream.read(abyte0, 0, Math.min(i, abyte0.length));
        if (k != -1)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        throw new IOException((new StringBuilder()).append("Invalid content length: ").append(i).toString());
        if (k <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i - k;
        i = j;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((OutputStream) (obj)).write(abyte0, 0, k);
        i = j;
        if (true) goto _L6; else goto _L4
_L4:
        while (inputstream.read(abyte0, 0, abyte0.length) != -1) ;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        ((OutputStream) (obj)).flush();
        ((OutputStream) (obj)).close();
        return;
        inputstream;
    }
}
