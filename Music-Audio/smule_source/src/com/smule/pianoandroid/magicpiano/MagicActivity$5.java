// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity, u

class a
    implements Runnable
{

    final MagicActivity a;

    public void run()
    {
        a.findViewById(0x7f0a0141).setVisibility(0);
        ((TextView)a.findViewById(0x7f0a0143)).setText(MagicActivity.j(a));
        ((TextView)a.findViewById(0x7f0a0144)).setText(MagicActivity.k(a));
        Animation animation = AnimationUtils.loadAnimation(a, 0x7f040017);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final MagicActivity._cls5 a;

            public void onAnimationEnd(Animation animation2)
            {
                a.a.findViewById(0x7f0a0141).setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation2)
            {
            }

            public void onAnimationStart(Animation animation2)
            {
            }

            
            {
                a = MagicActivity._cls5.this;
                super();
            }
        });
        MagicActivity.m(a).startAnimation(animation);
        if (PianoCoreBridge.isJoin())
        {
            MagicActivity.a(a, a.findViewById(0x7f0a0145));
            MagicActivity.n(a).setVisibility(0);
            MagicActivity.a(a, (TextView)a.findViewById(0x7f0a0146));
            MagicActivity.d(a, 3);
            MagicActivity.p(a).setText(Integer.toString(MagicActivity.o(a)));
            MagicActivity.a(a, new u(a, 4500L, 1000L));
            MagicActivity.q(a).start();
            MagicActivity.l(a);
            MagicActivity.n(a).findViewById(0x7f0a0148).startAnimation(AnimationUtils.loadAnimation(a, 0x7f04000d));
            Animation animation1 = AnimationUtils.loadAnimation(a, 0x7f04000f);
            animation1.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final MagicActivity._cls5 a;

                public void onAnimationEnd(Animation animation2)
                {
                    MagicActivity.n(a.a).setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation2)
                {
                }

                public void onAnimationStart(Animation animation2)
                {
                }

            
            {
                a = MagicActivity._cls5.this;
                super();
            }
            });
            MagicActivity.n(a).startAnimation(animation1);
        }
    }

    _cls2.a(MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
