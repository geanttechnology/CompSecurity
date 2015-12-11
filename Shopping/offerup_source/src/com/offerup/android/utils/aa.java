// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import com.b.a.a.j;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.utils:
//            z, x

final class aa
    implements Runnable
{

    private int a;
    private z b;

    aa(z z1, int i)
    {
        b = z1;
        a = i;
        super();
    }

    public final void run()
    {
        switch (a)
        {
        default:
            return;

        case 0: // '\0'
            com.offerup.android.tracker.a.b("ou_navdrawer_home_click");
            x.e(b.a).m();
            return;

        case 1: // '\001'
            com.offerup.android.tracker.a.b("ou_navdrawer_categories_click");
            x.e(b.a).l();
            return;

        case 2: // '\002'
            com.offerup.android.tracker.a.b("ou_navdrawer_alert_click");
            x.e(b.a).d();
            return;

        case 3: // '\003'
            com.offerup.android.tracker.a.b("ou_navdrawer_myoffers_click");
            x.e(b.a).b(j.a().n());
            return;

        case 4: // '\004'
            com.offerup.android.tracker.a.b("ou_navdrawer_helpcenter_click");
            break;
        }
        x.e(b.a).f();
    }
}
