// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;

// Referenced classes of package com.mopub.mobileads.resource:
//            BaseWidgetDrawable

public class ProgressBarDrawable extends BaseWidgetDrawable
{

    private final Paint mBackgroundPaint = new Paint();
    private int mCurrentProgress;
    private int mDuration;
    private int mLastProgress;
    private final int mNuggetWidth;
    private final Paint mProgressPaint = new Paint();
    private int mSkipOffset;
    private float mSkipRatio;

    public ProgressBarDrawable(Context context)
    {
        mBackgroundPaint.setColor(-1);
        mBackgroundPaint.setAlpha(128);
        mBackgroundPaint.setStyle(DrawableConstants.ProgressBar.BACKGROUND_STYLE);
        mBackgroundPaint.setAntiAlias(true);
        mProgressPaint.setColor(DrawableConstants.ProgressBar.PROGRESS_COLOR);
        mProgressPaint.setAlpha(255);
        mProgressPaint.setStyle(DrawableConstants.ProgressBar.PROGRESS_STYLE);
        mProgressPaint.setAntiAlias(true);
        mNuggetWidth = Dips.dipsToIntPixels(4F, context);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(getBounds(), mBackgroundPaint);
        float f = (float)mCurrentProgress / (float)mDuration;
        canvas.drawRect(getBounds().left, getBounds().top, (float)getBounds().right * f, getBounds().bottom, mProgressPaint);
        if (mSkipOffset > 0 && mSkipOffset < mDuration)
        {
            float f1 = getBounds().right;
            f1 = mSkipRatio * f1;
            canvas.drawRect(f1, getBounds().top, f1 + (float)mNuggetWidth, getBounds().bottom, mProgressPaint);
        }
    }

    public void forceCompletion()
    {
        mCurrentProgress = mDuration;
    }

    public int getCurrentProgress()
    {
        return mCurrentProgress;
    }

    public float getSkipRatio()
    {
        return mSkipRatio;
    }

    public void setDurationAndSkipOffset(int i, int j)
    {
        mDuration = i;
        mSkipOffset = j;
        mSkipRatio = (float)mSkipOffset / (float)mDuration;
    }

    public void setProgress(int i)
    {
        if (i < mLastProgress) goto _L2; else goto _L1
_L1:
        mCurrentProgress = i;
        mLastProgress = i;
_L4:
        invalidateSelf();
        return;
_L2:
        if (i != 0)
        {
            MoPubLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", new Object[] {
                Integer.valueOf(mLastProgress), Integer.valueOf(i)
            }));
            forceCompletion();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
