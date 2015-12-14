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

final class a extends Handler
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
            a.runOnUiThread(new Runnable() {

                private ColorSplashActivity._cls1 a;

                public final void run()
                {
                    if (!a.a.isFinishing() && ColorSplashActivity.a(a.a) != null)
                    {
                        Message message1 = ColorSplashActivity.a(a.a).obtainMessage();
                        message1.what = 1;
                        message1.arg1 = 1;
                        ColorSplashActivity.a(a.a).sendMessage(message1);
                    }
                }

            
            {
                a = ColorSplashActivity._cls1.this;
                super();
            }
            });
            return;

        case 1: // '\001'
            (new Handler()).postDelayed(new Runnable() {

                private ColorSplashActivity._cls1 a;

                public final void run()
                {
                    ColorSplashActivity.b(a.a).setVisibility(4);
                    ColorSplashActivity.c(a.a).dismiss();
                }

            
            {
                a = ColorSplashActivity._cls1.this;
                super();
            }
            }, 100L);
            break;
        }
        message.arg1 = -1;
    }

    _cls2.a(ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
