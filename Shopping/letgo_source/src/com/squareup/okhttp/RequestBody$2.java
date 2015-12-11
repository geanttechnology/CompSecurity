// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apw;
import android.support.v7.aqe;
import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType

static final class nit> extends RequestBody
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

    public void writeTo(apw apw1)
        throws IOException
    {
        android.support.v7.aqk aqk = null;
        android.support.v7.aqk aqk1 = aqe.a(val$file);
        aqk = aqk1;
        apw1.a(aqk1);
        Util.closeQuietly(aqk1);
        return;
        apw1;
        Util.closeQuietly(aqk);
        throw apw1;
    }

    (MediaType mediatype, File file1)
    {
        val$contentType = mediatype;
        val$file = file1;
        super();
    }
}
