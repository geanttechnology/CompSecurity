// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;


// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, MyGLSurfaceView

final class a
    implements Runnable
{

    private ColorSplashActivity a;

    public final void run()
    {
        ColorSplashActivity.h(a).requestRender();
    }

    (ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
