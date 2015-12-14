// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.facebook.cache.common:
//            WriterCallback, WriterCallbacks

static final class val.is
    implements WriterCallback
{

    final InputStream val$is;

    public void write(OutputStream outputstream)
        throws IOException
    {
        ByteStreams.copy(val$is, outputstream);
    }

    (InputStream inputstream)
    {
        val$is = inputstream;
        super();
    }
}
