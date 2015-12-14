// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package org.apache.http.entity:
//            AbstractHttpEntity

public class InputStreamEntity extends AbstractHttpEntity
{

    private boolean consumed;
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inputstream, long l)
    {
        consumed = false;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Source input stream may not be null");
        } else
        {
            content = inputstream;
            length = l;
            return;
        }
    }

    public void consumeContent()
        throws IOException
    {
        consumed = true;
        content.close();
    }

    public InputStream getContent()
        throws IOException
    {
        return content;
    }

    public long getContentLength()
    {
        return length;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return !consumed;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream;
        byte abyte0[];
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        inputstream = content;
        abyte0 = new byte[2048];
        if (length >= 0L) goto _L2; else goto _L1
_L1:
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                break;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
          goto _L3
_L2:
        long l = length;
_L7:
        if (l <= 0L) goto _L3; else goto _L4
_L4:
        int j = inputstream.read(abyte0, 0, (int)Math.min(2048L, l));
        if (j != -1) goto _L5; else goto _L3
_L3:
        consumed = true;
        return;
_L5:
        outputstream.write(abyte0, 0, j);
        l -= j;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
