// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            FlyerToolbar, bh

final class bf
    implements android.view.View.OnClickListener
{

    final FlyerToolbar a;

    bf(FlyerToolbar flyertoolbar)
    {
        a = flyertoolbar;
        super();
    }

    public final void onClick(View view)
    {
        if (FlyerToolbar.c(a) != null)
        {
            FlyerToolbar.c(a).b();
        }
    }
}
