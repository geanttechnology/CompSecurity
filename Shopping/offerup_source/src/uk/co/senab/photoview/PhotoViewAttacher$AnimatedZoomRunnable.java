// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.view.animation.Interpolator;

// Referenced classes of package uk.co.senab.photoview:
//            PhotoViewAttacher, Compat

class mZoomEnd
    implements Runnable
{

    private final float mFocalX;
    private final float mFocalY;
    private final long mStartTime = System.currentTimeMillis();
    private final float mZoomEnd;
    private final float mZoomStart;
    final PhotoViewAttacher this$0;

    private float interpolate()
    {
        float f = Math.min(1.0F, ((float)(System.currentTimeMillis() - mStartTime) * 1.0F) / 200F);
        return PhotoViewAttacher.sInterpolator.getInterpolation(f);
    }

    public void run()
    {
        android.widget.ImageView imageview = getImageView();
        if (imageview != null)
        {
            float f = interpolate();
            float f1 = (mZoomStart + (mZoomEnd - mZoomStart) * f) / getScale();
            PhotoViewAttacher.access$200(PhotoViewAttacher.this).postScale(f1, f1, mFocalX, mFocalY);
            PhotoViewAttacher.access$300(PhotoViewAttacher.this);
            if (f < 1.0F)
            {
                Compat.postOnAnimation(imageview, this);
                return;
            }
        }
    }

    public (float f, float f1, float f2, float f3)
    {
        this$0 = PhotoViewAttacher.this;
        super();
        mFocalX = f2;
        mFocalY = f3;
        mZoomStart = f;
        mZoomEnd = f1;
    }
}
