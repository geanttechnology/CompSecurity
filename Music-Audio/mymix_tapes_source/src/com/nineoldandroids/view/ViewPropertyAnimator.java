// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimatorICS, ViewPropertyAnimatorHC, ViewPropertyAnimatorPreHC

public abstract class ViewPropertyAnimator
{

    private static final WeakHashMap ANIMATORS = new WeakHashMap(0);

    public ViewPropertyAnimator()
    {
    }

    public static ViewPropertyAnimator animate(View view)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)ANIMATORS.get(view);
        Object obj = viewpropertyanimator;
        if (viewpropertyanimator == null)
        {
            int i = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
            if (i >= 14)
            {
                obj = new ViewPropertyAnimatorICS(view);
            } else
            if (i >= 11)
            {
                obj = new ViewPropertyAnimatorHC(view);
            } else
            {
                obj = new ViewPropertyAnimatorPreHC(view);
            }
            ANIMATORS.put(view, obj);
        }
        return ((ViewPropertyAnimator) (obj));
    }

    public abstract ViewPropertyAnimator alpha(float f);

    public abstract ViewPropertyAnimator alphaBy(float f);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract ViewPropertyAnimator rotation(float f);

    public abstract ViewPropertyAnimator rotationBy(float f);

    public abstract ViewPropertyAnimator rotationX(float f);

    public abstract ViewPropertyAnimator rotationXBy(float f);

    public abstract ViewPropertyAnimator rotationY(float f);

    public abstract ViewPropertyAnimator rotationYBy(float f);

    public abstract ViewPropertyAnimator scaleX(float f);

    public abstract ViewPropertyAnimator scaleXBy(float f);

    public abstract ViewPropertyAnimator scaleY(float f);

    public abstract ViewPropertyAnimator scaleYBy(float f);

    public abstract ViewPropertyAnimator setDuration(long l);

    public abstract ViewPropertyAnimator setInterpolator(Interpolator interpolator);

    public abstract ViewPropertyAnimator setListener(com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener);

    public abstract ViewPropertyAnimator setStartDelay(long l);

    public abstract void start();

    public abstract ViewPropertyAnimator translationX(float f);

    public abstract ViewPropertyAnimator translationXBy(float f);

    public abstract ViewPropertyAnimator translationY(float f);

    public abstract ViewPropertyAnimator translationYBy(float f);

    public abstract ViewPropertyAnimator x(float f);

    public abstract ViewPropertyAnimator xBy(float f);

    public abstract ViewPropertyAnimator y(float f);

    public abstract ViewPropertyAnimator yBy(float f);

}
