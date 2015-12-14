// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class val.destY
    implements com.nineoldandroids.animation.rUpdateListener
{

    final ImageViewTouchBase this$0;
    final float val$destX;
    final float val$destY;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        zoomTo(f, val$destX, val$destY);
    }

    stener()
    {
        this$0 = final_imageviewtouchbase;
        val$destX = f;
        val$destY = F.this;
        super();
    }
}
