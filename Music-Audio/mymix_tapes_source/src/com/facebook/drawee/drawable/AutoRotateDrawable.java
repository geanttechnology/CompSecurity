// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;

// Referenced classes of package com.facebook.drawee.drawable:
//            ForwardingDrawable

public class AutoRotateDrawable extends ForwardingDrawable
    implements Runnable
{

    private static final int DEGREES_IN_FULL_ROTATION = 360;
    private static final int FRAME_INTERVAL_MS = 20;
    private boolean mClockwise;
    private int mInterval;
    private boolean mIsScheduled;
    float mRotationAngle;

    public AutoRotateDrawable(Drawable drawable, int i)
    {
        this(drawable, i, true);
    }

    public AutoRotateDrawable(Drawable drawable, int i, boolean flag)
    {
        super((Drawable)Preconditions.checkNotNull(drawable));
        mRotationAngle = 0.0F;
        mIsScheduled = false;
        mInterval = i;
        mClockwise = flag;
    }

    private int getIncrement()
    {
        return (int)((20F / (float)mInterval) * 360F);
    }

    private void scheduleNextFrame()
    {
        if (!mIsScheduled)
        {
            mIsScheduled = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20L);
        }
    }

    public void draw(Canvas canvas)
    {
        int i = canvas.save();
        Rect rect = getBounds();
        int j = rect.right;
        int k = rect.left;
        int l = rect.bottom;
        int i1 = rect.top;
        float f = mRotationAngle;
        if (!mClockwise)
        {
            f = 360F - mRotationAngle;
        }
        canvas.rotate(f, rect.left + (j - k) / 2, rect.top + (l - i1) / 2);
        super.draw(canvas);
        canvas.restoreToCount(i);
        scheduleNextFrame();
    }

    public void reset()
    {
        mRotationAngle = 0.0F;
        mIsScheduled = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    public void run()
    {
        mIsScheduled = false;
        mRotationAngle = mRotationAngle + (float)getIncrement();
        invalidateSelf();
    }

    public void setClockwise(boolean flag)
    {
        mClockwise = flag;
    }
}
