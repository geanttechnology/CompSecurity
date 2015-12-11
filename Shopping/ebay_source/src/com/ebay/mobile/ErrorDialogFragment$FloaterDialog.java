// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.ebay.mobile:
//            ErrorDialogFragment

private final class this._cls0 extends Dialog
    implements android.view.og, android.view.animation.
{

    private boolean dismissed;
    private boolean retry;
    private Animation runningAnimation;
    final ErrorDialogFragment this$0;

    public void cancel()
    {
        if (!dismissed)
        {
            if (runningAnimation != null)
            {
                runningAnimation.cancel();
            }
            dismissed = true;
            retry = false;
            if (!startAnimation(false))
            {
                super.cancel();
                return;
            }
        }
    }

    public void onAnimationEnd(Animation animation)
    {
        runningAnimation = null;
        animation = floaterView;
        if (animation != null)
        {
            animation.setAnimation(null);
        }
        if (dismissed)
        {
            if (animation != null)
            {
                animation.setVisibility(8);
            }
            dismissAllowingStateLoss();
            dismissMessage(retry);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        runningAnimation = animation;
    }

    public void onClick(View view)
    {
        boolean flag = true;
        if (!dismissed)
        {
            if (runningAnimation != null)
            {
                runningAnimation.cancel();
            }
            dismissed = true;
            if (view.getId() != 0x7f100195)
            {
                flag = false;
            }
            retry = flag;
            if (!startAnimation(false))
            {
                super.dismiss();
                return;
            }
        }
    }

    public boolean startAnimation(boolean flag)
    {
        int j = 0;
        View view = floaterView;
        if (view == null)
        {
            return false;
        }
        Object obj;
        TranslateAnimation translateanimation;
        int i;
        if (flag)
        {
            i = -1;
        } else
        {
            i = 0;
        }
        if (!flag)
        {
            j = -1;
        }
        translateanimation = new TranslateAnimation(1, 0, 1, 0, 1, i, 1, j);
        translateanimation.setAnimationListener(this);
        translateanimation.setDuration(500L);
        if (flag)
        {
            obj = new DecelerateInterpolator();
        } else
        {
            obj = new AccelerateInterpolator();
        }
        translateanimation.setInterpolator(((android.view.animation.Interpolator) (obj)));
        translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
        view.startAnimation(translateanimation);
        return true;
    }

    public (Context context, int i)
    {
        this$0 = ErrorDialogFragment.this;
        super(context, i);
    }
}
