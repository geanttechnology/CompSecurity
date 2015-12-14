// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.RectF;
import android.view.ScaleGestureDetector;
import com.aviary.android.feather.common.utils.ApiHelper;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewVignette

public class this._cls0 extends android.view.GestureListener
{

    private float mRatio;
    final ImageViewVignette this$0;

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        while (ImageViewVignette.access$300(ImageViewVignette.this) !=  || !ApiHelper.AT_LEAST_11) 
        {
            return true;
        }
        float f1 = scalegesturedetector.getPreviousSpanX();
        float f2 = scalegesturedetector.getCurrentSpanX();
        float f3 = scalegesturedetector.getPreviousSpanY();
        float f4 = scalegesturedetector.getCurrentSpanY();
        float f = scalegesturedetector.getPreviousSpan() - scalegesturedetector.getCurrentSpan();
        if (mRatio > 0.5F && mRatio < 1.5F)
        {
            f2 = ImageViewVignette.access$400(ImageViewVignette.this).width() / ImageViewVignette.access$400(ImageViewVignette.this).height();
            if ((double)f2 >= 1.0D)
            {
                f1 = f;
                f /= f2;
            } else
            {
                f1 = f * f2;
            }
            onScroll(null, null, f1, f);
            return true;
        }
        if ((double)mRatio <= 0.75D)
        {
            onScroll(null, null, 0.0F, f3 - f4);
            return true;
        } else
        {
            onScroll(null, null, f1 - f2, 0.0F);
            return true;
        }
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        if (ApiHelper.AT_LEAST_11)
        {
            mRatio = scalegesturedetector.getCurrentSpanX() / scalegesturedetector.getCurrentSpanY();
            ImageViewVignette.access$500(ImageViewVignette.this, );
        }
        return super.onScaleBegin(scalegesturedetector);
    }

    public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
        super.onScaleEnd(scalegesturedetector);
    }

    public ()
    {
        this$0 = ImageViewVignette.this;
        super();
    }
}
