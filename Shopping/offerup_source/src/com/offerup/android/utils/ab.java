// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.utils:
//            ac, x

final class ab
    implements android.view.View.OnClickListener
{

    final x a;

    ab(x x1)
    {
        a = x1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ou_navdrawer_profilelogin_click");
        (new Handler()).postDelayed(new ac(this), 200L);
        x.d(a).a();
    }
}
