// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.net.HttpURLConnection;

// Referenced classes of package com.parse:
//            ParseURLConnectionHttpClient

static final class val.connection
    implements Runnable
{

    final HttpURLConnection val$connection;

    public void run()
    {
        val$connection.disconnect();
    }

    (HttpURLConnection httpurlconnection)
    {
        val$connection = httpurlconnection;
        super();
    }
}
