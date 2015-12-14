// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, b, c

final class a
    implements android.view.rSplashActivity._cls15
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        boolean flag = true;
        if (ColorSplashActivity.f(a) && !ColorSplashActivity.d(a))
        {
            int i;
            int j;
            if (view.getId() == 0x7f1002b5)
            {
                i = 0x7f1002b4;
                j = 0;
            } else
            if (view.getId() == 0x7f1002b7)
            {
                i = 0x7f1002b6;
                j = 1;
            } else
            if (view.getId() == 0x7f1002b9)
            {
                j = 2;
                i = 0x7f1002b8;
            } else
            {
                i = 0;
                j = 0;
            }
            if (ColorSplashActivity.g(a) != null && ColorSplashActivity.g(a).b != null)
            {
                a.a(i);
                ColorSplashActivity.g(a).b.b(j);
                view = ColorSplashActivity.g(a).b;
                if (((c) (view)).h[((c) (view)).l] > 0.0F)
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    a.c(false);
                    return;
                }
            }
        }
    }

    (ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
