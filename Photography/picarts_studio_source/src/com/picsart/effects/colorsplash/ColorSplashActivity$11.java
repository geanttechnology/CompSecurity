// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import com.socialin.android.photo.imgop.ImageOpCommon;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity

final class a
    implements Runnable
{

    private ColorSplashActivity a;

    public final void run()
    {
        if (!a.isFinishing())
        {
            ColorSplashActivity.o(a);
        } else
        if (ColorSplashActivity.p(a) != null)
        {
            ImageOpCommon.freeNativeBuffer(ColorSplashActivity.p(a));
            ColorSplashActivity.q(a);
            return;
        }
    }

    (ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
