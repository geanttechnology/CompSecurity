// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

// Referenced classes of package com.offerup.android.utils:
//            ag, x

final class af
    implements android.view.View.OnClickListener
{

    final x a;

    af(x x1)
    {
        a = x1;
        super();
    }

    public final void onClick(View view)
    {
        (new Handler()).postDelayed(new ag(this), 200L);
        x.d(a).a();
    }
}
