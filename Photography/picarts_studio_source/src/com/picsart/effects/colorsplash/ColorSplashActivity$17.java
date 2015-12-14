// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity

final class a
    implements android.view.rSplashActivity._cls17
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        if (!ColorSplashActivity.d(a))
        {
            view = a.findViewById(0x7f100133);
            if (view.getVisibility() != 0)
            {
                view.startAnimation(AnimationUtils.loadAnimation(a, 0x7f040017));
                view.setVisibility(0);
                return;
            }
            if (view.getVisibility() != 8)
            {
                view.startAnimation(AnimationUtils.loadAnimation(a, 0x7f040016));
                view.setVisibility(8);
                return;
            }
        }
    }

    (ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
