// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apx;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, MediaType

static final class nit> extends ResponseBody
{

    final apx val$content;
    final long val$contentLength;
    final MediaType val$contentType;

    public long contentLength()
    {
        return val$contentLength;
    }

    public MediaType contentType()
    {
        return val$contentType;
    }

    public apx source()
    {
        return val$content;
    }

    (MediaType mediatype, long l, apx apx)
    {
        val$contentType = mediatype;
        val$contentLength = l;
        val$content = apx;
        super();
    }
}
