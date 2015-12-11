// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;

import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

// Referenced classes of package com.aio.downloader.pager:
//            OutlineContainer

class this._cls0
    implements Runnable
{

    final OutlineContainer this$0;

    public void run()
    {
        long l = AnimationUtils.currentAnimationTimeMillis() - OutlineContainer.access$0(OutlineContainer.this);
        if (l >= 500L)
        {
            OutlineContainer.access$1(OutlineContainer.this, 0.0F);
            invalidate();
            stop();
            return;
        } else
        {
            OutlineContainer.access$1(OutlineContainer.this, OutlineContainer.access$2(OutlineContainer.this).getInterpolation(1.0F - (float)l / 500F));
            invalidate();
            postDelayed(OutlineContainer.access$3(OutlineContainer.this), 16L);
            return;
        }
    }

    ()
    {
        this$0 = OutlineContainer.this;
        super();
    }
}
