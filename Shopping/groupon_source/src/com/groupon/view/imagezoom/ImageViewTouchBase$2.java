// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;

import android.graphics.RectF;
import android.os.Handler;
import com.groupon.view.imagezoom.easing.Cubic;

// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouchBase

class old_y
    implements Runnable
{

    double old_x;
    double old_y;
    final ImageViewTouchBase this$0;
    final double val$durationMs;
    final double val$dx;
    final double val$dy;
    final long val$startTime;

    public void run()
    {
        long l = System.currentTimeMillis();
        double d = Math.min(val$durationMs, l - val$startTime);
        double d1 = ImageViewTouchBase.access$000(ImageViewTouchBase.this).easeOut(d, 0.0D, val$dx, val$durationMs);
        double d2 = ImageViewTouchBase.access$000(ImageViewTouchBase.this).easeOut(d, 0.0D, val$dy, val$durationMs);
        panBy(d1 - old_x, d2 - old_y);
        old_x = d1;
        old_y = d2;
        if (d < val$durationMs)
        {
            ImageViewTouchBase.access$100(ImageViewTouchBase.this).post(this);
        } else
        {
            RectF rectf = getCenter(ImageViewTouchBase.access$200(ImageViewTouchBase.this), true, true);
            if (rectf.left != 0.0F || rectf.top != 0.0F)
            {
                scrollBy(rectf.left, rectf.top);
                return;
            }
        }
    }

    ()
    {
        this$0 = final_imageviewtouchbase;
        val$durationMs = d;
        val$startTime = l;
        val$dx = d1;
        val$dy = D.this;
        super();
        old_x = 0.0D;
        old_y = 0.0D;
    }
}
