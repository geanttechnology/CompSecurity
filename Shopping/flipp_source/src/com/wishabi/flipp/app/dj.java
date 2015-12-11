// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            af, HelpActivity, MainActivity, PrintCouponActivity

final class dj
    implements af
{

    final MainActivity a;

    dj(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void a()
    {
        a.startActivity(new Intent(a, com/wishabi/flipp/app/HelpActivity));
    }

    public final void a(String s)
    {
        a.a(s);
        MainActivity.b(a).a(false);
    }

    public final void b()
    {
        a.startActivity(PrintCouponActivity.a());
    }
}
