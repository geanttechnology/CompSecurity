// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.bb;
import com.cyberlink.beautycircle.d;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ai, ShareOutUtils

final class b
    implements ai
{

    final areInfo a;
    final BaseFbActivity b;

    public void a()
    {
        if (com.cyberlink.beautycircle.utility.areInfo.ShareSource.b.equals(a.g))
        {
            com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "Yes", d.i, a.b.longValue()));
        }
        b.l();
        Globals.a(b.getString(m.bc_share_success));
        b.s();
    }

    public void a(WeiboException weiboexception)
    {
        if (com.cyberlink.beautycircle.utility.areInfo.ShareSource.b.equals(a.g))
        {
            com.perfectcorp.a.b.a(new bb(a.h, "share", a.i, "No", d.i, a.b.longValue()));
        }
        b.l();
        Globals.a(b.getString(m.bc_share_fail));
        e.e(new Object[] {
            weiboexception
        });
    }

    areInfo(areInfo areinfo, BaseFbActivity basefbactivity)
    {
        a = areinfo;
        b = basefbactivity;
        super();
    }
}
