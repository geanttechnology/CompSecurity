// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            f

class a
    implements Runnable
{

    final f a;

    public void run()
    {
        if (f.a(a) != null)
        {
            f.b(a).removeCallbacks(f.a(a));
            f.a(a, null);
            if (f.c(a).isShowing())
            {
                AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
                alphaanimation.setDuration(300L);
                f.d(a).setAnimation(alphaanimation);
                f.d(a).startAnimation(alphaanimation);
                alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final f._cls1 a;

                    public void onAnimationEnd(Animation animation)
                    {
                        f.c(a.a).dismiss();
                        f.a(a.a, null);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                a = f._cls1.this;
                super();
            }
                });
            }
        }
    }

    _cls1.a(f f1)
    {
        a = f1;
        super();
    }
}
