// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            Part

public class MultipartRequestEntity
    implements RequestEntity
{

    private static byte MULTIPART_CHARS[] = EncodingUtil.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    static Class class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity;
    private static final Log log;
    private byte multipartBoundary[];
    private HttpMethodParams params;
    protected Part parts[];

    public MultipartRequestEntity(Part apart[], HttpMethodParams httpmethodparams)
    {
        if (apart == null)
        {
            throw new IllegalArgumentException("parts cannot be null");
        }
        if (httpmethodparams == null)
        {
            throw new IllegalArgumentException("params cannot be null");
        } else
        {
            parts = apart;
            params = httpmethodparams;
            return;
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private static byte[] generateMultipartBoundary()
    {
        Random random = new Random();
        byte abyte0[] = new byte[random.nextInt(11) + 30];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)];
        }

        return abyte0;
    }

    public long getContentLength()
    {
        long l;
        try
        {
            l = Part.getLengthOfParts(parts, getMultipartBoundary());
        }
        catch (Exception exception)
        {
            log.error("An exception occurred while getting the length of the parts", exception);
            return 0L;
        }
        return l;
    }

    public String getContentType()
    {
        StringBuffer stringbuffer = new StringBuffer("multipart/form-data");
        stringbuffer.append("; boundary=");
        stringbuffer.append(EncodingUtil.getAsciiString(getMultipartBoundary()));
        return stringbuffer.toString();
    }

    protected byte[] getMultipartBoundary()
    {
        if (multipartBoundary == null)
        {
            String s = (String)params.getParameter("http.method.multipart.boundary");
            if (s != null)
            {
                multipartBoundary = EncodingUtil.getAsciiBytes(s);
            } else
            {
                multipartBoundary = generateMultipartBoundary();
            }
        }
        return multipartBoundary;
    }

    public boolean isRepeatable()
    {
        for (int i = 0; i < parts.length; i++)
        {
            if (!parts[i].isRepeatable())
            {
                return false;
            }
        }

        return true;
    }

    public void writeRequest(OutputStream outputstream)
        throws IOException
    {
        Part.sendParts(outputstream, parts, getMultipartBoundary());
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity");
            class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity;
        }
        log = LogFactory.getLog(class1);
    }
}
