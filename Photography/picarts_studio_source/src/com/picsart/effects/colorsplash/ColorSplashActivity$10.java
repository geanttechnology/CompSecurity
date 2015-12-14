// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity

final class a
    implements Runnable
{

    private ColorSplashActivity a;

    public final void run()
    {
        Utils.b(a, 0x7f080429);
        a.finish();
    }

    (ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
