// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wishabi.flipp.util.q;

// Referenced classes of package com.wishabi.flipp.app:
//            FlyerActivity

final class bc
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final FlyerActivity a;

    bc(FlyerActivity flyeractivity)
    {
        a = flyeractivity;
        super();
    }

    public final void onGlobalLayout()
    {
        ViewGroup viewgroup = (ViewGroup)a.getWindow().getDecorView();
        if (viewgroup instanceof FrameLayout)
        {
            FlyerActivity.a(a, FlyerActivity.b(a));
            ((TextView)FlyerActivity.c(a).findViewById(0x7f0b0142)).setText(a.getString(0x7f0e0100, new Object[] {
                q.a()
            }));
            viewgroup.addView(FlyerActivity.c(a));
            FlyerActivity.a(a);
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            viewgroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        } else
        {
            viewgroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        }
    }
}
