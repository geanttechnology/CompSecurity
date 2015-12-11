// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            FwLog

public class StreamUtil
{

    public static final int FULL_STREAM = 0x7fffffff;
    private static final int logPriority = 5;
    private static final String logTag = "fwStreamUtil";

    public StreamUtil()
    {
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static DirectByteArrayInputStream convertToDirectByteArrayInputStream(InputStream inputstream)
        throws IOException
    {
        if (inputstream instanceof DirectByteArrayInputStream)
        {
            return (DirectByteArrayInputStream)inputstream;
        } else
        {
            return new DirectByteArrayInputStream(streamToBytes(inputstream));
        }
    }

    public static DirectByteArrayInputStream convertToDirectByteArrayInputStreamForParse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            inputstream = convertToDirectByteArrayInputStream(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        return inputstream;
    }

    public static JSONObject jsonObjectFromStream(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, JSONException
    {
        try
        {
            inputstream = new JSONObject(streamToString(inputstream));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        return inputstream;
    }

    public static void logCloseQuietly(String s, IOException ioexception)
    {
        FwLog.println(5, "fwStreamUtil", s);
    }

    private static ByteArrayOutputStream readToByteArrayStream(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = readToByteArrayStream(inputstream, 0x7fffffff);
        closeQuietly(inputstream);
        return bytearrayoutputstream;
        Exception exception;
        exception;
        closeQuietly(inputstream);
        throw exception;
    }

    private static ByteArrayOutputStream readToByteArrayStream(InputStream inputstream, int i)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        }
        byte abyte0[] = new byte[4096];
        int k = i;
        int j = i;
        if (i == 0x7fffffff)
        {
            k = abyte0.length;
            j = 0x7fffffff;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(k);
        do
        {
            if (j <= 0)
            {
                break;
            }
            i = inputstream.read(abyte0, 0, Math.min(j, abyte0.length));
            if (i == -1)
            {
                break;
            }
            bytearrayoutputstream.write(abyte0, 0, i);
            j -= i;
        } while (true);
        bytearrayoutputstream.close();
        return bytearrayoutputstream;
    }

    public static int streamToBytes(InputStream inputstream, byte abyte0[])
        throws IOException
    {
        int i = abyte0.length;
        do
        {
            if (i <= 0)
            {
                break;
            }
            int j = inputstream.read(abyte0, 0, i);
            if (j == -1)
            {
                break;
            }
            i -= j;
        } while (true);
        return abyte0.length - i;
    }

    public static byte[] streamToBytes(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        }
        byte abyte0[];
        if (!(inputstream instanceof DirectByteArrayInputStream))
        {
            break MISSING_BLOCK_LABEL_27;
        }
        abyte0 = ((DirectByteArrayInputStream)inputstream).bytesByReference();
        closeQuietly(inputstream);
        return abyte0;
        abyte0 = streamToBytes(inputstream, 0x7fffffff);
        closeQuietly(inputstream);
        return abyte0;
        Exception exception;
        exception;
        closeQuietly(inputstream);
        throw exception;
    }

    public static byte[] streamToBytes(InputStream inputstream, int i)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            return readToByteArrayStream(inputstream, i).toByteArray();
        }
    }

    public static byte[] streamToBytesForParse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            inputstream = streamToBytes(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        return inputstream;
    }

    public static Reader streamToReader(InputStream inputstream, String s)
        throws UnsupportedEncodingException
    {
        return new InputStreamReader(inputstream, s);
    }

    public static String streamToString(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        }
        if (inputstream instanceof DirectByteArrayInputStream)
        {
            return new String(streamToBytes(inputstream));
        } else
        {
            return readToByteArrayStream(inputstream).toString();
        }
    }

    public static Writer streamToWriter(OutputStream outputstream, String s)
        throws UnsupportedEncodingException
    {
        return new OutputStreamWriter(outputstream, s);
    }
}
