// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final int a;
    final MagicActivity b;

    public void run()
    {
        if (a == 1)
        {
            MagicActivity.w(b).setVisibility(0);
            Animation animation = AnimationUtils.loadAnimation(b, 0x7f04000c);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final MagicActivity._cls8 a;

                public void onAnimationEnd(Animation animation1)
                {
                    MagicActivity.w(a.b).setVisibility(8);
                    MagicActivity.w(a.b).clearAnimation();
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                a = MagicActivity._cls8.this;
                super();
            }
            });
            MagicActivity.w(b).startAnimation(animation);
        }
    }

    _cls1.a(MagicActivity magicactivity, int i)
    {
        b = magicactivity;
        a = i;
        super();
    }
}
