// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;
import android.widget.FrameLayout;
import com.socialin.android.dialog.a;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, ColorSplashForegroundView

final class a
    implements android.view.orSplashActivity._cls5
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        if (!ColorSplashActivity.d(a))
        {
            ((ColorSplashForegroundView)a.findViewById(0x7f1002bc)).setBrushSizeIndex(((Integer)view.getTag()).intValue());
            ((FrameLayout)view).setBackgroundResource(0x7f020556);
            if (ColorSplashActivity.j(a) != null)
            {
                ColorSplashActivity.j(a).dismiss();
                return;
            }
        }
    }

    iew(ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
