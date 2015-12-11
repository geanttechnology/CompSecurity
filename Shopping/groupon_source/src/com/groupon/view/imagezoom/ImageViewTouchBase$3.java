// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.os.Handler;
import com.groupon.view.imagezoom.easing.Cubic;

// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouchBase

class val.destY
    implements Runnable
{

    final ImageViewTouchBase this$0;
    final float val$deltaScale;
    final float val$destX;
    final float val$destY;
    final float val$durationMs;
    final float val$oldScale;
    final long val$startTime;

    public void run()
    {
        long l = System.currentTimeMillis();
        float f = Math.min(val$durationMs, l - val$startTime);
        float f1 = (float)ImageViewTouchBase.access$000(ImageViewTouchBase.this).easeInOut(f, 0.0D, val$deltaScale, val$durationMs);
        zoomTo(val$oldScale + f1, val$destX, val$destY);
        if (f < val$durationMs)
        {
            ImageViewTouchBase.access$100(ImageViewTouchBase.this).post(this);
            return;
        } else
        {
            onZoomAnimationCompleted(getScale());
            center(true, true);
            return;
        }
    }

    ()
    {
        this$0 = final_imageviewtouchbase;
        val$durationMs = f;
        val$startTime = l;
        val$deltaScale = f1;
        val$oldScale = f2;
        val$destX = f3;
        val$destY = F.this;
        super();
    }
}
