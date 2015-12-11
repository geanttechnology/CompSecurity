// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.http;

import android.util.Log;
import com.amazon.blueshift.bluefront.android.SpeechClientException;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.amazon.blueshift.bluefront.android.http:
//            Part

public final class MultipartRequest
{

    private static final String BOUNDARY_PREFIX = "--";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String MULTIPART_FORMDATA = "multipart/form-data; boundary=";
    private static final String NEW_LINE = "\r\n";
    private static final String TAG = com/amazon/blueshift/bluefront/android/http/MultipartRequest.getCanonicalName();
    private final String mBoundary;
    private final HttpsURLConnection mConnection;
    private final Part mParts[];

    transient MultipartRequest(HttpsURLConnection httpsurlconnection, String s, Part apart[])
    {
        Preconditions.checkNotNull(httpsurlconnection, "Connection cannot be null");
        Preconditions.checkNotNull(apart, "Parts cannot be null.");
        boolean flag;
        if (apart.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Parts cannot be empty");
        mConnection = httpsurlconnection;
        mBoundary = s;
        mParts = apart;
    }

    public transient MultipartRequest(HttpsURLConnection httpsurlconnection, Part apart[])
    {
        this(httpsurlconnection, Long.toHexString(System.currentTimeMillis()), apart);
    }

    private byte[] readInputStream(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = ByteStreams.toByteArray(inputstream);
        Closeables.close(inputstream, true);
        return abyte0;
        Exception exception;
        exception;
        Closeables.close(inputstream, true);
        throw exception;
    }

    public byte[] execute()
        throws SpeechClientException
    {
        Object obj;
        Object obj1;
        Part part;
        obj = (new StringBuilder("multipart/form-data; boundary=")).append(mBoundary).toString();
        mConnection.setRequestProperty("Content-Type", ((String) (obj)));
        mConnection.setDoOutput(true);
        obj1 = null;
        part = null;
        obj = obj1;
        mConnection.connect();
        obj = obj1;
        obj1 = new BufferedOutputStream(mConnection.getOutputStream());
        int j;
        obj = mParts;
        j = obj.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        part = obj[i];
        sendBoundary(((OutputStream) (obj1)));
        part.writePart(((OutputStream) (obj1)));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        sendFooter(((OutputStream) (obj1)));
        ((OutputStream) (obj1)).close();
        obj = fetchResponse(mConnection);
        if (obj1 != null)
        {
            try
            {
                ((OutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                Log.w(TAG, "Failed to close request stream");
            }
        }
        mConnection.disconnect();
        return ((byte []) (obj));
        obj1;
        obj = part;
_L6:
        throw new SpeechClientException("Failed to execute HTTP request", ((Throwable) (obj1)));
        obj1;
_L4:
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.w(TAG, "Failed to close request stream");
            }
        }
        mConnection.disconnect();
        throw obj1;
        Object obj2;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    byte[] fetchResponse(HttpsURLConnection httpsurlconnection)
        throws SpeechClientException
    {
        Preconditions.checkNotNull(httpsurlconnection, "No connection when fetching response");
        int i;
        try
        {
            i = httpsurlconnection.getResponseCode();
            Log.v(TAG, (new StringBuilder()).append("response code: ").append(i).toString());
        }
        // Misplaced declaration of an exception variable
        catch (HttpsURLConnection httpsurlconnection)
        {
            throw new SpeechClientException("Processing Timeout", httpsurlconnection);
        }
        // Misplaced declaration of an exception variable
        catch (HttpsURLConnection httpsurlconnection)
        {
            throw new SpeechClientException("Failed to read response", httpsurlconnection);
        }
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        return readInputStream(new BufferedInputStream(httpsurlconnection.getInputStream()));
        httpsurlconnection = new String(readInputStream(new BufferedInputStream(httpsurlconnection.getErrorStream())), Charsets.UTF_8.displayName());
        Log.v(TAG, (new StringBuilder()).append("Non-successful response: ").append(httpsurlconnection).toString());
        throw new SpeechClientException((new StringBuilder(i)).append(": ").append(httpsurlconnection).toString());
    }

    void sendBoundary(OutputStream outputstream)
        throws IOException
    {
        outputstream.write((new StringBuilder("--")).append(mBoundary).append("\r\n").toString().getBytes(Charsets.UTF_8.displayName()));
    }

    void sendFooter(OutputStream outputstream)
        throws IOException
    {
        outputstream.write((new StringBuilder("--")).append(mBoundary).append("--").append("\r\n").toString().getBytes(Charsets.UTF_8.displayName()));
    }

}
