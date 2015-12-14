// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.webkit.WebView;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ContestActivity, DeepLinkActivity

class a extends m
{

    final ContestActivity a;

    protected void a(com.cyberlink.beautycircle.model.oResult oresult)
    {
        if (oresult != null && oresult.result != null && !oresult.result.status.equals("Error") && !oresult.result.status.equals("Repeat"))
        {
            ContestActivity.a(a, oresult.result);
            ContestActivity.a(a).id = Long.valueOf(ContestActivity.b(a));
            a.s = oresult.result.joinContestURL;
            if (a.f != null && a.s != null)
            {
                oresult = AccountManager.b();
                oresult = NetworkEvent.a(a.s, oresult);
                a.f.loadUrl(oresult);
                DeepLinkActivity.f(oresult);
            }
            if (ContestActivity.c(a))
            {
                a.b().b(x.k);
                a.b().a(0xc4100000, x.a, x.j, 0);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.oResult)obj);
    }

    (ContestActivity contestactivity)
    {
        a = contestactivity;
        super();
    }
}
