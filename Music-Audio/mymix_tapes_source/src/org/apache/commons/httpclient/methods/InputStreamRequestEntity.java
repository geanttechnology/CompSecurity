// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            RequestEntity

public class InputStreamRequestEntity
    implements RequestEntity
{

    public static final int CONTENT_LENGTH_AUTO = -2;
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
    private byte buffer[];
    private InputStream content;
    private long contentLength;
    private String contentType;

    public InputStreamRequestEntity(InputStream inputstream)
    {
        this(inputstream, ((String) (null)));
    }

    public InputStreamRequestEntity(InputStream inputstream, long l)
    {
        this(inputstream, l, null);
    }

    public InputStreamRequestEntity(InputStream inputstream, long l, String s)
    {
        buffer = null;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("The content cannot be null");
        } else
        {
            content = inputstream;
            contentLength = l;
            contentType = s;
            return;
        }
    }

    public InputStreamRequestEntity(InputStream inputstream, String s)
    {
        this(inputstream, -2L, s);
    }

    private void bufferContent()
    {
        while (buffer != null || content == null) 
        {
            return;
        }
        Object obj;
        byte abyte0[];
        obj = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int i = content.read(abyte0);
label0:
        {
            if (i < 0)
            {
                break label0;
            }
            try
            {
                ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                LOG.error(((IOException) (obj)).getMessage(), ((Throwable) (obj)));
                buffer = null;
                content = null;
                contentLength = 0L;
                return;
            }
        }
          goto _L1
        buffer = ((ByteArrayOutputStream) (obj)).toByteArray();
        content = null;
        contentLength = buffer.length;
        return;
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

    public InputStream getContent()
    {
        return content;
    }

    public long getContentLength()
    {
        if (contentLength == -2L && buffer == null)
        {
            bufferContent();
        }
        return contentLength;
    }

    public String getContentType()
    {
        return contentType;
    }

    public boolean isRepeatable()
    {
        return buffer != null;
    }

    public void writeRequest(OutputStream outputstream)
        throws IOException
    {
label0:
        {
            if (content != null)
            {
                byte abyte0[] = new byte[4096];
                int i = 0;
                do
                {
                    int j = content.read(abyte0);
                    if (j < 0)
                    {
                        break;
                    }
                    outputstream.write(abyte0, 0, j);
                    i += j;
                } while (true);
            } else
            {
                if (buffer == null)
                {
                    break label0;
                }
                outputstream.write(buffer);
            }
            return;
        }
        throw new IllegalStateException("Content must be set before entity is written");
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$InputStreamRequestEntity == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.InputStreamRequestEntity");
            class$org$apache$commons$httpclient$methods$InputStreamRequestEntity = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$InputStreamRequestEntity;
        }
        LOG = LogFactory.getLog(class1);
    }
}
