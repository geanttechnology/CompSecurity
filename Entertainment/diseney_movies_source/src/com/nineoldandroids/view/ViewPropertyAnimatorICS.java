// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimator

class ViewPropertyAnimatorICS extends com.nineoldandroids.view.ViewPropertyAnimator
{

    private static final long RETURN_WHEN_NULL = -1L;
    private final WeakReference mNative;

    ViewPropertyAnimatorICS(View view)
    {
        mNative = new WeakReference(view.animate());
    }

    public com.nineoldandroids.view.ViewPropertyAnimator alpha(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.alpha(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator alphaBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.alphaBy(f);
        }
        return this;
    }

    public void cancel()
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.cancel();
        }
    }

    public long getDuration()
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            return viewpropertyanimator.getDuration();
        } else
        {
            return -1L;
        }
    }

    public long getStartDelay()
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            return viewpropertyanimator.getStartDelay();
        } else
        {
            return -1L;
        }
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotation(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotation(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotationBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotationBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotationX(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotationX(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotationXBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotationXBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotationY(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotationY(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator rotationYBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.rotationYBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator scaleX(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.scaleX(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator scaleXBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.scaleXBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator scaleY(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.scaleY(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator scaleYBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.scaleYBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator setDuration(long l)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.setDuration(l);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator setInterpolator(Interpolator interpolator)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.setInterpolator(interpolator);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator setListener(final com.nineoldandroids.animation.Animator.AnimatorListener listener)
    {
        ViewPropertyAnimator viewpropertyanimator;
label0:
        {
            viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
            if (viewpropertyanimator != null)
            {
                if (listener != null)
                {
                    break label0;
                }
                viewpropertyanimator.setListener(null);
            }
            return this;
        }
        viewpropertyanimator.setListener(new android.animation.Animator.AnimatorListener() {

            final ViewPropertyAnimatorICS this$0;
            final com.nineoldandroids.animation.Animator.AnimatorListener val$listener;

            public void onAnimationCancel(Animator animator)
            {
                listener.onAnimationCancel(null);
            }

            public void onAnimationEnd(Animator animator)
            {
                listener.onAnimationEnd(null);
            }

            public void onAnimationRepeat(Animator animator)
            {
                listener.onAnimationRepeat(null);
            }

            public void onAnimationStart(Animator animator)
            {
                listener.onAnimationStart(null);
            }

            
            {
                this$0 = ViewPropertyAnimatorICS.this;
                listener = animatorlistener;
                super();
            }
        });
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator setStartDelay(long l)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.setStartDelay(l);
        }
        return this;
    }

    public void start()
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.start();
        }
    }

    public com.nineoldandroids.view.ViewPropertyAnimator translationX(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.translationX(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator translationXBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.translationXBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator translationY(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.translationY(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator translationYBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.translationYBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator x(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.x(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator xBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.xBy(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator y(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.y(f);
        }
        return this;
    }

    public com.nineoldandroids.view.ViewPropertyAnimator yBy(float f)
    {
        ViewPropertyAnimator viewpropertyanimator = (ViewPropertyAnimator)mNative.get();
        if (viewpropertyanimator != null)
        {
            viewpropertyanimator.yBy(f);
        }
        return this;
    }
}
