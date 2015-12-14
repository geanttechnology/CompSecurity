// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        ColorSplashActivity.b(a.a).setVisibility(4);
        ColorSplashActivity.c(a.a).dismiss();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$1

/* anonymous class */
    final class ColorSplashActivity._cls1 extends Handler
    {

        final ColorSplashActivity a;

        public final void handleMessage(Message message)
        {
            switch (message.arg1)
            {
            default:
                return;

            case 0: // '\0'
                message.arg1 = -1;
                a.runOnUiThread(new ColorSplashActivity._cls1._cls1());
                return;

            case 1: // '\001'
                (new Handler()).postDelayed(new ColorSplashActivity._cls1._cls2(this), 100L);
                break;
            }
            message.arg1 = -1;
        }

            
            {
                a = colorsplashactivity;
                super();
            }

        // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$1$1

/* anonymous class */
        final class ColorSplashActivity._cls1._cls1
            implements Runnable
        {

            private ColorSplashActivity._cls1 a;

            public final void run()
            {
                if (!a.a.isFinishing() && ColorSplashActivity.a(a.a) != null)
                {
                    Message message = ColorSplashActivity.a(a.a).obtainMessage();
                    message.what = 1;
                    message.arg1 = 1;
                    ColorSplashActivity.a(a.a).sendMessage(message);
                }
            }

                    
                    {
                        a = ColorSplashActivity._cls1.this;
                        super();
                    }
        }

    }

}
