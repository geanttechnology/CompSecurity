// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import com.socialin.camera.opengl.a;
import com.socialin.camera.opengl.h;

// Referenced classes of package com.socialin.picsin.camera.view:
//            ColorSplashForegroundView

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        ColorSplashForegroundView.e(a.a).c = false;
    }

    erState(erState erstate)
    {
        a = erstate;
        super();
    }

    // Unreferenced inner class com/socialin/picsin/camera/view/ColorSplashForegroundView$1

/* anonymous class */
    final class ColorSplashForegroundView._cls1
        implements Runnable
    {

        final ColorSplashForegroundView a;

        public final void run()
        {
            a.invalidate(com.socialin.picsin.camera.view.ColorSplashForegroundView.a(a));
            ColorSplashForegroundView.b(a);
            if (ColorSplashForegroundView.c(a) <= 0.01F)
            {
                com.socialin.picsin.camera.view.ColorSplashForegroundView.a(a, ColorSplashForegroundView.PickerState.CLOSED);
                if (ColorSplashForegroundView.d(a) != null && ColorSplashForegroundView.e(a) != null && ColorSplashForegroundView.e(a).c())
                {
                    ColorSplashForegroundView.d(a).queueEvent(new ColorSplashForegroundView._cls1._cls1(this));
                    h h1 = ColorSplashForegroundView.e(a);
                    if (h1.a != null)
                    {
                        h1.a.a(1, true, false, true);
                    }
                }
                return;
            } else
            {
                ColorSplashForegroundView.f(a).postDelayed(this, 50L);
                return;
            }
        }

            
            {
                a = colorsplashforegroundview;
                super();
            }
    }

}
