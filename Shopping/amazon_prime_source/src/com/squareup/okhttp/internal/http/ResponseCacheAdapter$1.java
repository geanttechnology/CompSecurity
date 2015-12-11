// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            ResponseCacheAdapter, Headers

static final class val.body extends val.body
{

    final InputStream val$body;
    final Headers val$okHeaders;

    public InputStream byteStream()
    {
        return val$body;
    }

    (Headers headers, InputStream inputstream)
    {
        val$okHeaders = headers;
        val$body = inputstream;
        super();
    }
}
