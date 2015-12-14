// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.os.Bundle;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ah, ai

class a
    implements WeiboAuthListener
{

    final ai a;
    final ah b;

    public void onCancel()
    {
        if (a != null)
        {
            a.a(new WeiboException("Cancelled"));
        }
    }

    public void onComplete(Bundle bundle)
    {
        if (bundle != null)
        {
            ah.a(b, Oauth2AccessToken.parseAccessToken(bundle));
            ah.a(b, bundle);
            if (a != null)
            {
                a.a();
            }
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
