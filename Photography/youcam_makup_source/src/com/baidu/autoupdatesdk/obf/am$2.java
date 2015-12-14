// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            am

final class ext extends DefaultConnectionKeepAliveStrategy
{

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        long l1 = super.getKeepAliveDuration(httpresponse, httpcontext);
        long l = l1;
        if (l1 == -1L)
        {
            l = 30000L;
        }
        return l;
    }

    ext()
    {
    }
}
