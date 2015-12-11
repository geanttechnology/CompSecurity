// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.parse:
//            ParseByteArrayHttpBody, ProgressCallback

class ParseCountingByteArrayHttpBody extends ParseByteArrayHttpBody
{

    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final ProgressCallback progressCallback;

    public ParseCountingByteArrayHttpBody(byte abyte0[], String s, ProgressCallback progresscallback)
    {
        super(abyte0, s);
        progressCallback = progresscallback;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        int i = 0;
        int j = content.length;
        do
        {
            if (i >= j)
            {
                break;
            }
            int k = Math.min(j - i, 4096);
            outputstream.write(content, i, k);
            outputstream.flush();
            if (progressCallback != null)
            {
                i += k;
                k = (i * 100) / j;
                progressCallback.done(Integer.valueOf(k));
            }
        } while (true);
    }
}
