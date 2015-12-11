// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.util;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

// Referenced classes of package cz.msebera.android.httpclient.util:
//            Args, ByteArrayBuffer, CharArrayBuffer

public final class EntityUtils
{

    private EntityUtils()
    {
    }

    public static void consume(HttpEntity httpentity)
        throws IOException
    {
        if (httpentity != null && httpentity.isStreaming())
        {
            httpentity = httpentity.getContent();
            if (httpentity != null)
            {
                httpentity.close();
                return;
            }
        }
    }

    public static void consumeQuietly(HttpEntity httpentity)
    {
        try
        {
            consume(httpentity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            return;
        }
    }

    public static String getContentCharSet(HttpEntity httpentity)
        throws ParseException
    {
        Args.notNull(httpentity, "Entity");
        Object obj = null;
        String s = obj;
        if (httpentity.getContentType() != null)
        {
            httpentity = httpentity.getContentType().getElements();
            s = obj;
            if (httpentity.length > 0)
            {
                httpentity = httpentity[0].getParameterByName("charset");
                s = obj;
                if (httpentity != null)
                {
                    s = httpentity.getValue();
                }
            }
        }
        return s;
    }

    public static String getContentMimeType(HttpEntity httpentity)
        throws ParseException
    {
        Args.notNull(httpentity, "Entity");
        Object obj = null;
        String s = obj;
        if (httpentity.getContentType() != null)
        {
            httpentity = httpentity.getContentType().getElements();
            s = obj;
            if (httpentity.length > 0)
            {
                s = httpentity[0].getName();
            }
        }
        return s;
    }

    public static byte[] toByteArray(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        boolean flag;
        flag = false;
        Args.notNull(httpentity, "Entity");
        inputstream = httpentity.getContent();
        if (inputstream == null)
        {
            return null;
        }
        if (httpentity.getContentLength() <= 0x7fffffffL)
        {
            flag = true;
        }
        int j;
        Args.check(flag, "HTTP entity too large to be buffered in memory");
        j = (int)httpentity.getContentLength();
        int i;
        i = j;
        if (j < 0)
        {
            i = 4096;
        }
        byte abyte0[];
        httpentity = new ByteArrayBuffer(i);
        abyte0 = new byte[4096];
_L1:
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        httpentity.append(abyte0, 0, i);
          goto _L1
        httpentity;
        inputstream.close();
        throw httpentity;
        httpentity = httpentity.toByteArray();
        inputstream.close();
        return httpentity;
    }

    public static String toString(HttpEntity httpentity)
        throws IOException, ParseException
    {
        return toString(httpentity, (Charset)null);
    }

    public static String toString(HttpEntity httpentity, String s)
        throws IOException, ParseException
    {
        if (s != null)
        {
            s = Charset.forName(s);
        } else
        {
            s = null;
        }
        return toString(httpentity, ((Charset) (s)));
    }

    public static String toString(HttpEntity httpentity, Charset charset)
        throws IOException, ParseException
    {
        InputStream inputstream;
        boolean flag;
        flag = false;
        Args.notNull(httpentity, "Entity");
        inputstream = httpentity.getContent();
        if (inputstream == null)
        {
            return null;
        }
        if (httpentity.getContentLength() <= 0x7fffffffL)
        {
            flag = true;
        }
        long l;
        Args.check(flag, "HTTP entity too large to be buffered in memory");
        l = httpentity.getContentLength();
        char ac[];
        int i;
        int j = (int)l;
        i = j;
        if (j < 0)
        {
            i = 4096;
        }
        ac = null;
        ContentType contenttype = ContentType.get(httpentity);
        httpentity = ac;
        if (contenttype == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        httpentity = contenttype.getCharset();
        Object obj = httpentity;
        if (httpentity == null)
        {
            obj = charset;
        }
        httpentity = ((HttpEntity) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        httpentity = HTTP.DEF_CONTENT_CHARSET;
        httpentity = new InputStreamReader(inputstream, httpentity);
        charset = new CharArrayBuffer(i);
        obj = new char[1024];
_L1:
        i = httpentity.read(((char []) (obj)));
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        charset.append(((char []) (obj)), 0, i);
          goto _L1
        httpentity;
        inputstream.close();
        throw httpentity;
        httpentity;
        throw new UnsupportedEncodingException(httpentity.getMessage());
        httpentity = charset.toString();
        inputstream.close();
        return httpentity;
    }

    public static void updateEntity(HttpResponse httpresponse, HttpEntity httpentity)
        throws IOException
    {
        Args.notNull(httpresponse, "Response");
        consume(httpresponse.getEntity());
        httpresponse.setEntity(httpentity);
    }
}
