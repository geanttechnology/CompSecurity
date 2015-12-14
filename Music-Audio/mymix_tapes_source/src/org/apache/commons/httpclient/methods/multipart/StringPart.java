// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            PartBase

public class StringPart extends PartBase
{

    public static final String DEFAULT_CHARSET = "US-ASCII";
    public static final String DEFAULT_CONTENT_TYPE = "text/plain";
    public static final String DEFAULT_TRANSFER_ENCODING = "8bit";
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$multipart$StringPart;
    private byte content[];
    private String value;

    public StringPart(String s, String s1)
    {
        this(s, s1, null);
    }

    public StringPart(String s, String s1, String s2)
    {
        String s3 = s2;
        if (s2 == null)
        {
            s3 = "US-ASCII";
        }
        super(s, "text/plain", s3, "8bit");
        if (s1 == null)
        {
            throw new IllegalArgumentException("Value may not be null");
        }
        if (s1.indexOf('\0') != -1)
        {
            throw new IllegalArgumentException("NULs may not be present in string parts");
        } else
        {
            value = s1;
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

    private byte[] getContent()
    {
        if (content == null)
        {
            content = EncodingUtil.getBytes(value, getCharSet());
        }
        return content;
    }

    protected long lengthOfData()
        throws IOException
    {
        LOG.trace("enter lengthOfData()");
        return (long)getContent().length;
    }

    protected void sendData(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendData(OutputStream)");
        outputstream.write(getContent());
    }

    public void setCharSet(String s)
    {
        super.setCharSet(s);
        content = null;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$multipart$StringPart == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.multipart.StringPart");
            class$org$apache$commons$httpclient$methods$multipart$StringPart = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$multipart$StringPart;
        }
        LOG = LogFactory.getLog(class1);
    }
}
