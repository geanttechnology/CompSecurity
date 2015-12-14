// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;
import android.widget.CompoundButton;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, ColorSplashForegroundView

final class a
    implements android.view.rSplashActivity._cls18
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        if (ColorSplashActivity.d(a))
        {
            return;
        }
        ColorSplashForegroundView colorsplashforegroundview = (ColorSplashForegroundView)a.findViewById(0x7f1002bc);
        if (view.getId() == 0x7f10018e)
        {
            ((CompoundButton)a.findViewById(0x7f10018d)).setChecked(false);
            ((CompoundButton)a.findViewById(0x7f10018e)).setChecked(true);
            colorsplashforegroundview.setDrawMode(true);
            return;
        } else
        {
            ((CompoundButton)a.findViewById(0x7f10018d)).setChecked(true);
            ((CompoundButton)a.findViewById(0x7f10018e)).setChecked(false);
            colorsplashforegroundview.setDrawMode(false);
            return;
        }
    }

    ew(ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
