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
    implements android.view.animation.nListener
{

    final a a;

    public void onAnimationEnd(Animation animation)
    {
        MagicActivity.w(a.a).setVisibility(8);
        MagicActivity.w(a.a).clearAnimation();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls9(_cls9 _pcls9)
    {
        a = _pcls9;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/MagicActivity$8

/* anonymous class */
    class MagicActivity._cls8
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
                animation.setAnimationListener(new MagicActivity._cls8._cls1(this));
                MagicActivity.w(b).startAnimation(animation);
            }
        }

            
            {
                b = magicactivity;
                a = i;
                super();
            }
    }

}
