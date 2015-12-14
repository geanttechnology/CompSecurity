// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.sina.weibo.sdk.net:
//            AsyncWeiboRunner, HttpManager, RequestListener, WeiboParameters

class val.listener extends Thread
{

    final AsyncWeiboRunner this$0;
    private final String val$httpMethod;
    private final RequestListener val$listener;
    private final WeiboParameters val$params;
    private final String val$url;

    public void run()
    {
        String s = HttpManager.openUrl(AsyncWeiboRunner.access$0(AsyncWeiboRunner.this), val$url, val$httpMethod, val$params);
        if (val$listener != null)
        {
            val$listener.onComplete(s);
        }
_L1:
        return;
        WeiboException weiboexception;
        weiboexception;
        if (val$listener != null)
        {
            val$listener.onWeiboException(weiboexception);
            return;
        }
          goto _L1
    }

    n()
    {
        this$0 = final_asyncweiborunner;
        val$url = s;
        val$httpMethod = s1;
        val$params = weiboparameters;
        val$listener = RequestListener.this;
        super();
    }
}
