// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, ColorSplashForegroundView

final class a
    implements android.view.rSplashActivity._cls20
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        if (ColorSplashActivity.d(a))
        {
            return;
        } else
        {
            ((ColorSplashForegroundView)a.findViewById(0x7f1002bc)).a();
            a.b(false);
            return;
        }
    }

    ew(ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
