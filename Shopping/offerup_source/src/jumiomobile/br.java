// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

// Referenced classes of package jumiomobile:
//            bs, bq

class br
    implements Runnable
{

    final ImageView a;
    final int b;
    final ImageView c;
    final bq d;
    final bq e;

    br(bq bq, ImageView imageview, int i, ImageView imageview1, bq bq1)
    {
        e = bq;
        a = imageview;
        b = i;
        c = imageview1;
        d = bq1;
        super();
    }

    public void run()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(a, "alpha", new float[] {
            255F, 0.0F
        });
        objectanimator.setDuration(130L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(a, "translationY", new float[] {
            0.0F, (float)b
        });
        objectanimator1.setInterpolator(new DecelerateInterpolator());
        objectanimator1.setDuration(130L);
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(c, "alpha", new float[] {
            0.0F, 255F
        });
        objectanimator2.setDuration(160L);
        ObjectAnimator objectanimator3 = ObjectAnimator.ofFloat(c, "translationY", new float[] {
            (float)(-b), 0.0F
        });
        objectanimator1.setInterpolator(new AccelerateInterpolator());
        objectanimator3.setDuration(160L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator1, objectanimator, objectanimator3, objectanimator2
        });
        animatorset.addListener(new bs(this));
        animatorset.start();
    }
}
