// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;

// Referenced classes of package com.mopub.mobileads.resource:
//            BaseWidgetDrawable

public class RadialCountdownDrawable extends BaseWidgetDrawable
{

    private final Paint mArcPaint = new Paint();
    private final Paint mCirclePaint = new Paint();
    private int mInitialCountdownMilliseconds;
    private int mSecondsRemaining;
    private float mSweepAngle;
    private final Paint mTextPaint = new Paint();
    private Rect mTextRect;

    public RadialCountdownDrawable(Context context)
    {
        int i = Dips.dipsToIntPixels(3F, context);
        float f = Dips.dipsToFloatPixels(18F, context);
        mCirclePaint.setColor(-1);
        mCirclePaint.setAlpha(128);
        mCirclePaint.setStyle(DrawableConstants.RadialCountdown.BACKGROUND_STYLE);
        mCirclePaint.setStrokeWidth(i);
        mCirclePaint.setAntiAlias(true);
        mArcPaint.setColor(-1);
        mArcPaint.setAlpha(255);
        mArcPaint.setStyle(DrawableConstants.RadialCountdown.PROGRESS_STYLE);
        mArcPaint.setStrokeWidth(i);
        mArcPaint.setAntiAlias(true);
        mTextPaint.setColor(-1);
        mTextPaint.setTextAlign(DrawableConstants.RadialCountdown.TEXT_ALIGN);
        mTextPaint.setTextSize(f);
        mTextPaint.setAntiAlias(true);
        mTextRect = new Rect();
    }

    public void draw(Canvas canvas)
    {
        int i = getBounds().centerX();
        int j = getBounds().centerY();
        int k = Math.min(i, j);
        canvas.drawCircle(i, j, k, mCirclePaint);
        i = mSecondsRemaining;
        drawTextWithinBounds(canvas, mTextPaint, mTextRect, String.valueOf(i));
        canvas.drawArc(new RectF(getBounds()), -90F, mSweepAngle, false, mArcPaint);
    }

    public int getInitialCountdownMilliseconds()
    {
        return mInitialCountdownMilliseconds;
    }

    public void setInitialCountdown(int i)
    {
        mInitialCountdownMilliseconds = i;
    }

    public void updateCountdownProgress(int i)
    {
        mSecondsRemaining = (int)Numbers.convertMillisecondsToSecondsRoundedUp(mInitialCountdownMilliseconds - i);
        mSweepAngle = (360F * (float)i) / (float)mInitialCountdownMilliseconds;
        invalidateSelf();
    }
}
