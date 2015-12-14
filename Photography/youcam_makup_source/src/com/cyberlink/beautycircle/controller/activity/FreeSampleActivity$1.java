// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.webkit.WebView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.x;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity, DeepLinkActivity

class a extends m
{

    final Long a;
    final FreeSampleActivity b;

    protected void a(com.cyberlink.beautycircle.model.network.ntInfoResult ntinforesult)
    {
        if (ntinforesult != null && ntinforesult.result != null)
        {
            FreeSampleActivity.a(b, ntinforesult.result);
            if (FreeSampleActivity.a(b) != null)
            {
                com.perfectcorp.a.b.a(new x(FreeSampleActivity.a(b).id.toString(), com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.b(b), FreeSampleActivity.a(b).serviceType));
            }
            if ("CONSULTATION".equals(FreeSampleActivity.a(b).serviceType) && ("Selected".equals(FreeSampleActivity.a(b).userStatus) || "Redeemed".equals(FreeSampleActivity.a(b).userStatus)))
            {
                c.a(b, Long.valueOf(com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.c(b)));
                b.finish();
            }
            b.s = NetworkEvent.a(ntinforesult.result.eventLink, com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.c(b), a);
            if (b.f != null && b.s != null)
            {
                b.f.loadUrl(b.s);
                DeepLinkActivity.f(b.s);
            }
            if (FreeSampleActivity.d(b) && "FREE_SAMPLE".equals(FreeSampleActivity.a(b).serviceType))
            {
                b.b().b(com.cyberlink.beautycircle.controller.fragment.x.l);
                b.b().a(0xc4100000, com.cyberlink.beautycircle.controller.fragment.x.a, com.cyberlink.beautycircle.controller.fragment.x.j, 0);
                return;
            }
            if (FreeSampleActivity.a(b).organizerLogo != null)
            {
                b.b().a(FreeSampleActivity.a(b).organizerLogo);
                return;
            }
            if (FreeSampleActivity.a(b).organizerName != null)
            {
                b.b().c(FreeSampleActivity.a(b).organizerName);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.ntInfoResult)obj);
    }

    Result(FreeSampleActivity freesampleactivity, Long long1)
    {
        b = freesampleactivity;
        a = long1;
        super();
    }
}
