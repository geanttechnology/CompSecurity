// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import okio.e;
import okio.l;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

final class nit> extends RequestBody
{

    final MediaType val$contentType;
    final File val$file;

    public long contentLength()
    {
        return val$file.length();
    }

    public MediaType contentType()
    {
        return val$contentType;
    }

    public void writeTo(e e1)
    {
        okio.r r = null;
        okio.r r1 = l.a(val$file);
        r = r1;
        e1.a(r1);
        Util.closeQuietly(r1);
        return;
        e1;
        Util.closeQuietly(r);
        throw e1;
    }

    ()
    {
        val$contentType = mediatype;
        val$file = file1;
        super();
    }
}
