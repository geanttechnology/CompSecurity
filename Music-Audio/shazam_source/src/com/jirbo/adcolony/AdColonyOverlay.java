// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            e, q, v

public class AdColonyOverlay extends e
{

    Rect R;
    int S;

    public AdColonyOverlay()
    {
        R = new Rect();
        S = 0;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getWindowManager().getDefaultDisplay();
        s = configuration.getWidth();
        t = configuration.getHeight();
        q.s = true;
        configuration = new View(this);
        configuration.setBackgroundColor(0xff000000);
        if (d && C.P)
        {
            L.setLayoutParams(new android.widget.FrameLayout.LayoutParams(s, t - C.m, 17));
            K.addView(configuration, new android.widget.FrameLayout.LayoutParams(s, t, 17));
            (new Handler()).postDelayed(new Runnable(configuration) {

                final View a;
                final AdColonyOverlay b;

                public final void run()
                {
                    b.K.removeView(a);
                }

            
            {
                b = AdColonyOverlay.this;
                a = view;
                super();
            }
            }, 1500L);
        }
        C.a();
    }
}
