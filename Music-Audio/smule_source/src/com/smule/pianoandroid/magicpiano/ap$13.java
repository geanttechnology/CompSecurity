// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.TextView;
import com.smule.android.d.g;
import com.smule.android.f.j;
import com.smule.android.network.managers.a;
import com.smule.android.network.managers.ap;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap, aq, MagicApplication

class a
    implements Runnable
{

    final Map a;
    final com.smule.pianoandroid.magicpiano.ap b;

    public void run()
    {
        com.smule.pianoandroid.magicpiano.ap.a(b, com.smule.android.network.managers.a.a().a("piandroid.purchasePage", "layout", a));
        b.c.setText((CharSequence)ap.n(b).get("pageTitleKey"));
        b.d.setText((CharSequence)ap.n(b).get("pageFreeTitleKey"));
        ap.o(b);
        java.util.List list = ap.a().f();
        if (list != null)
        {
            com.smule.pianoandroid.magicpiano.ap.a(b, list);
        }
        com.smule.pianoandroid.magicpiano.ap.a(b, new aq(b));
        com.smule.pianoandroid.magicpiano.ap.a(b, 0);
        com.smule.pianoandroid.magicpiano.ap.a(b, new g());
        ap.f(b).a(b, ap.p(b));
        ap.q(b);
        ap.r(b);
        MagicApplication.getLoader().a("PurchaseActivity.LoadSubs");
    }

    pplication(com.smule.pianoandroid.magicpiano.ap ap1, Map map)
    {
        b = ap1;
        a = map;
        super();
    }
}
