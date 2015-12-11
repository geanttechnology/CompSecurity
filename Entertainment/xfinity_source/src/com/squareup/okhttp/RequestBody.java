// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.io.IOException;
import okio.BufferedSink;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class RequestBody
{

    public long contentLength()
        throws IOException
    {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedsink)
        throws IOException;
}
