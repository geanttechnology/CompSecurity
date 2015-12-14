// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ai, ah

class c
    implements ai
{

    final String a;
    final Uri b;
    final ai c;
    final ah d;

    public void a()
    {
        ah.a(d, ah.a(d), a, b, c);
    }

    public void a(WeiboException weiboexception)
    {
        if (c != null)
        {
            c.a(weiboexception);
        }
    }

    ion(ah ah1, String s, Uri uri, ai ai1)
    {
        d = ah1;
        a = s;
        b = uri;
        c = ai1;
        super();
    }
}
