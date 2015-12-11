// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import d.i;
import d.q;
import java.io.File;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

final class nit> extends RequestBody
{

    final MediaType val$contentType;
    final File val$file;

    public final long contentLength()
    {
        return val$file.length();
    }

    public final MediaType contentType()
    {
        return val$contentType;
    }

    public final void writeTo(i j)
    {
        d.ab ab = null;
        d.ab ab1 = q.a(val$file);
        ab = ab1;
        j.a(ab1);
        Util.closeQuietly(ab1);
        return;
        j;
        Util.closeQuietly(ab);
        throw j;
    }

    ()
    {
        val$contentType = mediatype;
        val$file = file1;
        super();
    }
}
