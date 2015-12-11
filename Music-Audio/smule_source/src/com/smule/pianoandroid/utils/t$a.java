// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.support.v4.app.FragmentActivity;
import com.smule.android.c.aa;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.magicpiano.ai;
import com.smule.pianoandroid.magicpiano.ak;
import com.smule.pianoandroid.magicpiano.b.p;
import com.smule.pianoandroid.magicpiano.i;

// Referenced classes of package com.smule.pianoandroid.utils:
//            t, i

class b
    implements ak, Runnable
{

    t a;
    ListingV2 b;
    final t c;

    public void a(ListingV2 listingv2, boolean flag)
    {
        if (c.a == null)
        {
            c.a = new i(c.c, c.c.getString(0x7f0c00dc));
            c.a.show();
        }
        c.a.a(0, c.c.getString(0x7f0c00dc), true);
        c.a.a(a);
        b = listingv2;
        c.b = new p(c.c, listingv2.song, a, c.a);
        t.a(c, 0);
        aa.c(t.f(), (new StringBuilder()).append("Downloading ").append(listingv2.productId).append(" for play").toString());
        c.b.execute(new Void[0]);
    }

    public void run()
    {
        ListingV2 listingv2 = i.d().a();
        if (listingv2.b() && !listingv2.isFree)
        {
            if (c.a != null)
            {
                c.a.dismiss();
                c.a = null;
            }
            ai.a(c.c, listingv2, false, this).show();
            return;
        } else
        {
            a(b, false);
            return;
        }
    }

    ListingV2(t t1, t t2, ListingV2 listingv2)
    {
        c = t1;
        super();
        a = t2;
        b = listingv2;
    }
}
