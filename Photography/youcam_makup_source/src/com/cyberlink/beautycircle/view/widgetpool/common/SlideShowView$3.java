// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.view.View;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            SlideShowView, UICImageView

class a
    implements Runnable
{

    final SlideShowView a;

    public void run()
    {
        if (SlideShowView.a(a).size() < 2)
        {
            return;
        }
        Object obj1 = (View)SlideShowView.a(a).get(SlideShowView.c(a));
        int i = (SlideShowView.c(a) + 1) % SlideShowView.a(a).size();
        Object obj = (UICImageView)SlideShowView.a(a).get(i);
        if (!((UICImageView) (obj)).a())
        {
            ((UICImageView) (obj)).setImageURI((Uri)((UICImageView) (obj)).getTag());
            return;
        } else
        {
            SlideShowView.a(a, i);
            ((UICImageView) (obj)).setVisibility(0);
            float f = a.getWidth();
            float f1 = f / 3F;
            float f2 = f1 / 3F;
            obj = ObjectAnimator.ofFloat(obj, "translationX", new float[] {
                f, f1, f2, 0.0F
            }).setDuration(SlideShowView.d(a));
            obj1 = ObjectAnimator.ofFloat(obj1, "translationX", new float[] {
                0.0F, f1 + (0.0F - f), (0.0F - f) + f2, 0.0F - f
            }).setDuration(SlideShowView.d(a));
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                obj1, obj
            });
            animatorset.start();
            a.postDelayed(SlideShowView.e(a), SlideShowView.f(a));
            return;
        }
    }

    (SlideShowView slideshowview)
    {
        a = slideshowview;
        super();
    }
}
