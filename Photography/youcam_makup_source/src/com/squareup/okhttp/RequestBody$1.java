// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import okio.e;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

final class nit> extends RequestBody
{

    final byte val$content[];
    final MediaType val$contentType;

    public long contentLength()
    {
        return (long)val$content.length;
    }

    public MediaType contentType()
    {
        return val$contentType;
    }

    public void writeTo(e e1)
    {
        e1.c(val$content);
    }

    ()
    {
        val$contentType = mediatype;
        val$content = abyte0;
        super();
    }
}
