// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            RequestEntity

public class StringRequestEntity
    implements RequestEntity
{

    private String charset;
    private byte content[];
    private String contentType;

    public StringRequestEntity(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("The content cannot be null");
        } else
        {
            contentType = null;
            charset = null;
            content = s.getBytes();
            return;
        }
    }

    public StringRequestEntity(String s, String s1, String s2)
        throws UnsupportedEncodingException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("The content cannot be null");
        }
        contentType = s1;
        charset = s2;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        NameValuePair namevaluepair;
        HeaderElement aheaderelement[];
        int i;
        aheaderelement = HeaderElement.parseElements(s1);
        namevaluepair = null;
        i = 0;
_L7:
        if (i >= aheaderelement.length) goto _L4; else goto _L3
_L3:
        namevaluepair = aheaderelement[i].getParameterByName("charset");
        if (namevaluepair == null) goto _L5; else goto _L4
_L4:
        if (s2 == null && namevaluepair != null)
        {
            charset = namevaluepair.getValue();
        } else
        if (s2 != null && namevaluepair == null)
        {
            contentType = s1 + "; charset=" + s2;
        }
_L2:
        if (charset != null)
        {
            content = s.getBytes(charset);
            return;
        } else
        {
            content = s.getBytes();
            return;
        }
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String getCharset()
    {
        return charset;
    }

    public String getContent()
    {
        if (charset != null)
        {
            String s;
            try
            {
                s = new String(content, charset);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                return new String(content);
            }
            return s;
        } else
        {
            return new String(content);
        }
    }

    public long getContentLength()
    {
        return (long)content.length;
    }

    public String getContentType()
    {
        return contentType;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public void writeRequest(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        } else
        {
            outputstream.write(content);
            outputstream.flush();
            return;
        }
    }
}
