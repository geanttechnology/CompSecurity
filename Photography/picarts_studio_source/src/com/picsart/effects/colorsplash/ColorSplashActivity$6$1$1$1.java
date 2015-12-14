// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.socialin.android.dialog.g;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, a, MyGLSurfaceView, ColorSplashForegroundView

final class a
    implements Runnable
{

    private ams a;

    public final void run()
    {
        Object obj = ColorSplashActivity.l(a.a.a.a);
        obj.l = true;
        obj.m = 0;
        obj.k = 0;
        obj = new android.widget.nit>(ColorSplashActivity.m(a.a.a.a), ColorSplashActivity.n(a.a.a.a));
        ColorSplashActivity.h(a.a.a.a).setLayoutParams(((android.view.ceView.setLayoutParams) (obj)));
    }

    A(A a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$6

/* anonymous class */
    final class ColorSplashActivity._cls6
        implements android.view.View.OnClickListener
    {

        final ColorSplashActivity a;

        public final void onClick(View view)
        {
            if (!ColorSplashActivity.d(a))
            {
                ColorSplashActivity.k(a);
                if (ColorSplashActivity.e(a) != null)
                {
                    ColorSplashActivity.e(a).setOrigBitmapAndCanvas(null, null);
                }
                a.findViewById(0x7f1001a8).setVisibility(8);
                if (ColorSplashActivity.l(a).s != 0)
                {
                    if (ColorSplashActivity.l(a).i == ColorSplashActivity.m(a) && ColorSplashActivity.l(a).j == ColorSplashActivity.n(a))
                    {
                        if (!a.isFinishing() && ColorSplashActivity.a(a) != null)
                        {
                            view = ColorSplashActivity.a(a).obtainMessage();
                            view.what = 1;
                            view.arg1 = 0;
                            ColorSplashActivity.a(a).sendMessage(view);
                            return;
                        }
                    } else
                    {
                        a.findViewById(0x7f100127).setVisibility(8);
                        ColorSplashActivity.b(a).setVisibility(0);
                        (new Handler()).postDelayed(new ColorSplashActivity._cls6._cls1(this), 200L);
                        if (ColorSplashActivity.c(a) == null)
                        {
                            ColorSplashActivity.a(a, new g(a));
                            ColorSplashActivity.c(a).setMessage(a.getString(0x7f080679));
                            ColorSplashActivity.c(a).setProgressStyle(0);
                        }
                        ColorSplashActivity.c(a).show();
                        return;
                    }
                } else
                {
                    a.setResult(0);
                    a.finish();
                    return;
                }
            }
        }

            
            {
                a = colorsplashactivity;
                super();
            }
    }


    // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$6$1

/* anonymous class */
    final class ColorSplashActivity._cls6._cls1
        implements Runnable
    {

        final ColorSplashActivity._cls6 a;

        public final void run()
        {
            ColorSplashActivity.h(a.a).queueEvent(new ColorSplashActivity._cls6._cls1._cls1(this));
        }

            
            {
                a = _pcls6;
                super();
            }
    }


    // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$6$1$1

/* anonymous class */
    final class ColorSplashActivity._cls6._cls1._cls1
        implements Runnable
    {

        final ColorSplashActivity._cls6._cls1 a;

        public final void run()
        {
            a.a.a.runOnUiThread(new ColorSplashActivity._cls6._cls1._cls1._cls1(this));
        }

            
            {
                a = _pcls1;
                super();
            }
    }

}
