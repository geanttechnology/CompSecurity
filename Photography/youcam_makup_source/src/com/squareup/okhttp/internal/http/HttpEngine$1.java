// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.d;
import okio.f;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine

final class  extends ResponseBody
{

    public long contentLength()
    {
        return 0L;
    }

    public MediaType contentType()
    {
        return null;
    }

    public f source()
    {
        return new d();
    }

    ()
    {
    }
}
