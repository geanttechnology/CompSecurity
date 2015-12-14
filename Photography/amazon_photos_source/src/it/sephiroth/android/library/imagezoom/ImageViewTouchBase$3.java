// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.graphics.RectF;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class this._cls0
    implements com.nineoldandroids.animation.ener
{

    final ImageViewTouchBase this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        animator = getCenter(mSuppMatrix, true, true);
        if (((RectF) (animator)).left != 0.0F || ((RectF) (animator)).top != 0.0F)
        {
            scrollBy(((RectF) (animator)).left, ((RectF) (animator)).top);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    A()
    {
        this$0 = ImageViewTouchBase.this;
        super();
    }
}
