// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;

// Referenced classes of package org.apache.http.util:
//            ByteArrayBuffer, CharArrayBuffer

public final class EntityUtils
{

    public static String getContentCharSet(HttpEntity httpentity)
        throws ParseException
    {
        if (httpentity == null)
        {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
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

    public static byte[] toByteArray(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        if (httpentity == null)
        {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        inputstream = httpentity.getContent();
        if (inputstream == null)
        {
            return new byte[0];
        }
        if (httpentity.getContentLength() > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        int k = (int)httpentity.getContentLength();
        int i = k;
        if (k < 0)
        {
            i = 4096;
        }
        httpentity = new ByteArrayBuffer(i);
        byte abyte0[] = new byte[4096];
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        httpentity.append(abyte0, 0, j);
          goto _L1
        httpentity;
        inputstream.close();
        throw httpentity;
        inputstream.close();
        return httpentity.toByteArray();
    }

    public static String toString(HttpEntity httpentity)
        throws IOException, ParseException
    {
        return toString(httpentity, null);
    }

    public static String toString(HttpEntity httpentity, String s)
        throws IOException, ParseException
    {
        if (httpentity == null)
        {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        InputStream inputstream = httpentity.getContent();
        if (inputstream == null)
        {
            return "";
        }
        if (httpentity.getContentLength() > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        int k = (int)httpentity.getContentLength();
        int i = k;
        if (k < 0)
        {
            i = 4096;
        }
        String s1 = getContentCharSet(httpentity);
        httpentity = s1;
        if (s1 == null)
        {
            httpentity = s;
        }
        s = httpentity;
        if (httpentity == null)
        {
            s = "ISO-8859-1";
        }
        httpentity = new InputStreamReader(inputstream, s);
        s = new CharArrayBuffer(i);
        char ac[] = new char[1024];
_L1:
        int j = httpentity.read(ac);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        s.append(ac, 0, j);
          goto _L1
        s;
        httpentity.close();
        throw s;
        httpentity.close();
        return s.toString();
    }
}
