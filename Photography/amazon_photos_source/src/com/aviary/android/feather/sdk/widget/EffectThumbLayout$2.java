// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            EffectThumbLayout

class this._cls0
    implements com.nineoldandroids.animation.tener
{

    final EffectThumbLayout this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (EffectThumbLayout.access$000(EffectThumbLayout.this) != null)
        {
            EffectThumbLayout.access$000(EffectThumbLayout.this).setVisibility(0);
            ObjectAnimator.ofInt(EffectThumbLayout.access$000(EffectThumbLayout.this), "alpha", new int[] {
                0, 255
            }).start();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = EffectThumbLayout.this;
        super();
    }
}
