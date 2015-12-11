// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

// Referenced classes of package jumiomobile:
//            lp, mc, nh, nd, 
//            lm, ha, lq

class mb
    implements android.view.View.OnClickListener
{

    final lp a;

    private mb(lp lp1)
    {
        a = lp1;
        super();
    }

    mb(lp lp1, lq lq)
    {
        this(lp1);
    }

    public void onClick(View view)
    {
        view.setEnabled(false);
        view = ObjectAnimator.ofFloat(lp.a(a), "alpha", new float[] {
            1.0F, 0.0F
        });
        view.setDuration(200L);
        view.setInterpolator(new AccelerateDecelerateInterpolator());
        view.addListener(new mc(this));
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(lp.a(a), "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(200L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(lp.b(a), "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator1.setDuration(200L);
        objectanimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(view).with(objectanimator1).before(objectanimator);
        animatorset.start();
        lp.c(a).setUploadStatus(nh.a);
        a.a.getController().j();
    }
}
