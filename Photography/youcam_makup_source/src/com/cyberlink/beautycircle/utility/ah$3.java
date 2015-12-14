// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.model.WeiboAccountInfo;
import com.perfectcorp.model.Model;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ah, ai

class a
    implements RequestListener
{

    final ai a;
    final ah b;

    public void onComplete(String s)
    {
        ah.a(b, (WeiboAccountInfo)Model.a(com/cyberlink/beautycircle/model/WeiboAccountInfo, s));
        if (a != null)
        {
            a.a();
        }
    }

    public void onWeiboException(WeiboException weiboexception)
    {
        if (a != null)
        {
            a.a(weiboexception);
        }
    }

    ion(ah ah1, ai ai1)
    {
        b = ah1;
        a = ai1;
        super();
    }
}
