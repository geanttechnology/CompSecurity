// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PostProposeActivity

public class to extends Animation
{

    private float from;
    private ProgressBar progressBar;
    final PostProposeActivity this$0;
    private float to;

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        f = from + (to - from) * f;
        if ((int)f >= progressBar.getMax()) goto _L2; else goto _L1
_L1:
        progressBar.setProgress((int)f);
_L4:
        return;
_L2:
        int i;
        uiImageHat.startAnimation(PostProposeActivity.access$000(PostProposeActivity.this));
        uiPbXp.clearAnimation();
        i = uiPbXp.getMax();
        if (currentSeuil != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        currentSeuil = 3500;
        uiPbXp.setMax(16500);
_L5:
        if (currentSeuil != 0x1e8480)
        {
            transformation = PostProposeActivity.this;
            ProgressBar progressbar = uiPbXp;
            from = 0.0F;
            f = to - (float)i;
            to = f;
            transformation = transformation. new <init>(progressbar, 0.0F, f);
            transformation.setDuration(1500L);
            uiPbXp.startAnimation(transformation);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (currentSeuil == 3500)
        {
            currentSeuil = 20000;
            uiPbXp.setMax(25000);
        } else
        if (currentSeuil == 20000)
        {
            currentSeuil = 45000;
            uiPbXp.setMax(45000);
        } else
        if (currentSeuil == 45000)
        {
            currentSeuil = 0x15f90;
            uiPbXp.setMax(54000);
        } else
        if (currentSeuil == 0x15f90)
        {
            currentSeuil = 0x23280;
            uiPbXp.setMax(0x4ab50);
        } else
        if (currentSeuil == 0x23280)
        {
            currentSeuil = 0x6ddd0;
            uiPbXp.setMax(0x6ddd0);
        } else
        if (currentSeuil == 0x6ddd0)
        {
            currentSeuil = 0xdbba0;
            uiPbXp.setMax(0x10c8e0);
        } else
        if (currentSeuil == 0xdbba0)
        {
            currentSeuil = 0x1e8480;
            uiPbXp.setMax(1);
            uiPbXp.setProgress(1);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public (ProgressBar progressbar, float f, float f1)
    {
        this$0 = PostProposeActivity.this;
        super();
        progressBar = progressbar;
        from = f;
        to = f1;
    }
}
