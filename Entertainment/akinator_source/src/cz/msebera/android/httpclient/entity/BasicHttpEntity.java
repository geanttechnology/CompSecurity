// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.entity:
//            AbstractHttpEntity

public class BasicHttpEntity extends AbstractHttpEntity
{

    private InputStream content;
    private long length;

    public BasicHttpEntity()
    {
        length = -1L;
    }

    public InputStream getContent()
        throws IllegalStateException
    {
        boolean flag;
        if (content != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Content has not been provided");
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
        return content != null;
    }

    public void setContent(InputStream inputstream)
    {
        content = inputstream;
    }

    public void setContentLength(long l)
    {
        length = l;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream;
        Args.notNull(outputstream, "Output stream");
        inputstream = getContent();
        byte abyte0[] = new byte[4096];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        inputstream.close();
        throw outputstream;
        inputstream.close();
        return;
    }
}
