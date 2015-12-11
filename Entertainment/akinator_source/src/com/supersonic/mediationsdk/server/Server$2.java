// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.server;


// Referenced classes of package com.supersonic.mediationsdk.server:
//            Server

static final class val.hit
    implements Runnable
{

    final boolean val$hit;
    final String val$requestUrl;

    public void run()
    {
        Server.callRequestURL(val$requestUrl, val$hit);
    }

    (String s, boolean flag)
    {
        val$requestUrl = s;
        val$hit = flag;
        super();
    }
}
