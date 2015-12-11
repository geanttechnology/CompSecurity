// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.entity:
//            AbstractHttpEntity, ContentType

public class InputStreamEntity extends AbstractHttpEntity
{

    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inputstream)
    {
        this(inputstream, -1L);
    }

    public InputStreamEntity(InputStream inputstream, long l)
    {
        this(inputstream, l, null);
    }

    public InputStreamEntity(InputStream inputstream, long l, ContentType contenttype)
    {
        content = (InputStream)Args.notNull(inputstream, "Source input stream");
        length = l;
        if (contenttype != null)
        {
            setContentType(contenttype.toString());
        }
    }

    public InputStreamEntity(InputStream inputstream, ContentType contenttype)
    {
        this(inputstream, -1L, contenttype);
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
        return true;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream;
        Args.notNull(outputstream, "Output stream");
        inputstream = content;
        byte abyte0[] = new byte[4096];
        if (length >= 0L) goto _L2; else goto _L1
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        inputstream.close();
        throw outputstream;
_L2:
        long l = length;
_L8:
        if (l <= 0L) goto _L4; else goto _L5
_L5:
        i = inputstream.read(abyte0, 0, (int)Math.min(4096L, l));
        if (i != -1) goto _L6; else goto _L4
_L4:
        inputstream.close();
        return;
_L6:
        outputstream.write(abyte0, 0, i);
        l -= i;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
