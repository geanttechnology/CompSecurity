// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.parse:
//            ParseFileHttpBody, ProgressCallback, ParseIOUtils

class ParseCountingFileHttpBody extends ParseFileHttpBody
{

    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int EOF = -1;
    private final ProgressCallback progressCallback;

    public ParseCountingFileHttpBody(File file, ProgressCallback progresscallback)
    {
        this(file, null, progresscallback);
    }

    public ParseCountingFileHttpBody(File file, String s, ProgressCallback progresscallback)
    {
        super(file, s);
        progressCallback = progresscallback;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        FileInputStream fileinputstream;
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        fileinputstream = new FileInputStream(file);
        byte abyte0[];
        long l2;
        abyte0 = new byte[4096];
        l2 = file.length();
        long l = 0L;
_L2:
        int i = fileinputstream.read(abyte0);
        if (-1 == i)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        outputstream.write(abyte0, 0, i);
        long l1;
        l1 = l + (long)i;
        l = l1;
        if (progressCallback == null) goto _L2; else goto _L1
_L1:
        int j = (int)((100L * l1) / l2);
        progressCallback.done(Integer.valueOf(j));
        l = l1;
          goto _L2
        outputstream;
        ParseIOUtils.closeQuietly(fileinputstream);
        throw outputstream;
        ParseIOUtils.closeQuietly(fileinputstream);
        return;
    }
}
