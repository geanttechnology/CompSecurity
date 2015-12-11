// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.util;

import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.util:
//            ByteArrayBuffer

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
            return null;
        }
        if (httpentity.getContentLength() > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        break MISSING_BLOCK_LABEL_57;
        httpentity;
        inputstream.close();
        throw httpentity;
        int j = (int)httpentity.getContentLength();
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
            break MISSING_BLOCK_LABEL_114;
        }
        httpentity.append(abyte0, 0, i);
          goto _L1
        httpentity = httpentity.toByteArray();
        inputstream.close();
        return httpentity;
    }
}
