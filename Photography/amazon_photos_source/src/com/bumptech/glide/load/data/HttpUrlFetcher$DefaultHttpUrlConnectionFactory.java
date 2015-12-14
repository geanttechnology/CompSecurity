// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.bumptech.glide.load.data:
//            HttpUrlFetcher

private static class <init>
    implements <init>
{

    public HttpURLConnection build(URL url)
        throws IOException
    {
        return (HttpURLConnection)url.openConnection();
    }

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }
}
