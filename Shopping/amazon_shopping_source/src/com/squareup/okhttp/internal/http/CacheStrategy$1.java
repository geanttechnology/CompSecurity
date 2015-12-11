// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            CacheStrategy

static final class  extends 
{

    public InputStream byteStream()
    {
        return Util.EMPTY_INPUT_STREAM;
    }

    public long contentLength()
    {
        return 0L;
    }

    public MediaType contentType()
    {
        return null;
    }

    public boolean ready()
        throws IOException
    {
        return true;
    }

    ()
    {
    }
}
