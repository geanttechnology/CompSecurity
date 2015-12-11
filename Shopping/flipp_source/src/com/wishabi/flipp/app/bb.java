// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            bn, FlyerActivity

final class bb
    implements bn
{

    final FlyerActivity a;

    bb(FlyerActivity flyeractivity)
    {
        a = flyeractivity;
        super();
    }

    public final void a(View view, com.wishabi.flipp.content.Flyer.Model model)
    {
        FlyerActivity.a(a, model);
        model = a.getActionBar();
        if (model != null)
        {
            model.setDisplayShowTitleEnabled(false);
            model.setDisplayShowCustomEnabled(true);
            model.setCustomView(view);
        }
        FlyerActivity.a(a);
    }
}
