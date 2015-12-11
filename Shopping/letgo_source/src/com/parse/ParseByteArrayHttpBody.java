// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.parse:
//            ParseHttpBody

class ParseByteArrayHttpBody extends ParseHttpBody
{

    protected final byte content[];
    protected final InputStream contentInputStream;

    public ParseByteArrayHttpBody(String s, String s1)
        throws UnsupportedEncodingException
    {
        this(s.getBytes("UTF-8"), s1);
    }

    public ParseByteArrayHttpBody(byte abyte0[], String s)
    {
        super(s, abyte0.length);
        content = abyte0;
        contentInputStream = new ByteArrayInputStream(abyte0);
    }

    public InputStream getContent()
    {
        return contentInputStream;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        } else
        {
            outputstream.write(content);
            return;
        }
    }
}
