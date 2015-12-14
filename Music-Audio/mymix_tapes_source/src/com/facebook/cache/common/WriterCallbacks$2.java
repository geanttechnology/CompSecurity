// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.facebook.cache.common:
//            WriterCallback, WriterCallbacks

static final class val.data
    implements WriterCallback
{

    final byte val$data[];

    public void write(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(val$data);
    }

    (byte abyte0[])
    {
        val$data = abyte0;
        super();
    }
}
