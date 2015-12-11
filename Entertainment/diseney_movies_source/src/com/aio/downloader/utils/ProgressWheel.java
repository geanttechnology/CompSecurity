// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class ProgressWheel extends View
{
    static class WheelSavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public WheelSavedState createFromParcel(Parcel parcel)
            {
                return new WheelSavedState(parcel, null);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public WheelSavedState[] newArray(int i)
            {
                return new WheelSavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int barColor;
        int barWidth;
        int circleRadius;
        boolean fillRadius;
        boolean isSpinning;
        boolean linearProgress;
        float mProgress;
        float mTargetProgress;
        int rimColor;
        int rimWidth;
        float spinSpeed;

        public void writeToParcel(Parcel parcel, int i)
        {
            boolean flag = true;
            super.writeToParcel(parcel, i);
            parcel.writeFloat(mProgress);
            parcel.writeFloat(mTargetProgress);
            if (isSpinning)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
            parcel.writeFloat(spinSpeed);
            parcel.writeInt(barWidth);
            parcel.writeInt(barColor);
            parcel.writeInt(rimWidth);
            parcel.writeInt(rimColor);
            parcel.writeInt(circleRadius);
            if (linearProgress)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
            if (fillRadius)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
        }


        private WheelSavedState(Parcel parcel)
        {
            boolean flag1 = true;
            super(parcel);
            mProgress = parcel.readFloat();
            mTargetProgress = parcel.readFloat();
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isSpinning = flag;
            spinSpeed = parcel.readFloat();
            barWidth = parcel.readInt();
            barColor = parcel.readInt();
            rimWidth = parcel.readInt();
            rimColor = parcel.readInt();
            circleRadius = parcel.readInt();
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            linearProgress = flag;
            if (parcel.readByte() != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            fillRadius = flag;
        }

        WheelSavedState(Parcel parcel, WheelSavedState wheelsavedstate)
        {
            this(parcel);
        }

        WheelSavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final String TAG = com/aio/downloader/utils/ProgressWheel.getSimpleName();
    private int barColor;
    private float barExtraLength;
    private boolean barGrowingFromFront;
    private final int barLength;
    private final int barMaxLength;
    private Paint barPaint;
    private double barSpinCycleTime;
    private int barWidth;
    private RectF circleBounds;
    private int circleRadius;
    private boolean fillRadius;
    private boolean isSpinning;
    private long lastTimeAnimated;
    private boolean linearProgress;
    private float mProgress;
    private float mTargetProgress;
    private final long pauseGrowingTime;
    private long pausedTimeWithoutGrowing;
    private int rimColor;
    private Paint rimPaint;
    private int rimWidth;
    private float spinSpeed;
    private double timeStartGrowing;

    public ProgressWheel(Context context)
    {
        super(context);
        circleRadius = 28;
        barWidth = 4;
        rimWidth = 4;
        barLength = 16;
        barMaxLength = 270;
        fillRadius = false;
        timeStartGrowing = 0.0D;
        barSpinCycleTime = 460D;
        barExtraLength = 0.0F;
        barGrowingFromFront = true;
        pausedTimeWithoutGrowing = 0L;
        pauseGrowingTime = 200L;
        barColor = 0xaa000000;
        rimColor = 0xffffff;
        barPaint = new Paint();
        rimPaint = new Paint();
        circleBounds = new RectF();
        spinSpeed = 230F;
        lastTimeAnimated = 0L;
        mProgress = 0.0F;
        mTargetProgress = 0.0F;
        isSpinning = false;
    }

    public ProgressWheel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        circleRadius = 28;
        barWidth = 4;
        rimWidth = 4;
        barLength = 16;
        barMaxLength = 270;
        fillRadius = false;
        timeStartGrowing = 0.0D;
        barSpinCycleTime = 460D;
        barExtraLength = 0.0F;
        barGrowingFromFront = true;
        pausedTimeWithoutGrowing = 0L;
        pauseGrowingTime = 200L;
        barColor = 0xaa000000;
        rimColor = 0xffffff;
        barPaint = new Paint();
        rimPaint = new Paint();
        circleBounds = new RectF();
        spinSpeed = 230F;
        lastTimeAnimated = 0L;
        mProgress = 0.0F;
        mTargetProgress = 0.0F;
        isSpinning = false;
        parseAttributes(context.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.ProgressWheel));
    }

    private void parseAttributes(TypedArray typedarray)
    {
        android.util.DisplayMetrics displaymetrics = getContext().getResources().getDisplayMetrics();
        barWidth = (int)TypedValue.applyDimension(1, barWidth, displaymetrics);
        rimWidth = (int)TypedValue.applyDimension(1, rimWidth, displaymetrics);
        circleRadius = (int)TypedValue.applyDimension(1, circleRadius, displaymetrics);
        circleRadius = (int)typedarray.getDimension(6, circleRadius);
        fillRadius = typedarray.getBoolean(7, false);
        barWidth = (int)typedarray.getDimension(8, barWidth);
        rimWidth = (int)typedarray.getDimension(3, rimWidth);
        spinSpeed = typedarray.getFloat(4, spinSpeed / 360F) * 360F;
        barSpinCycleTime = typedarray.getInt(5, (int)barSpinCycleTime);
        barColor = typedarray.getColor(1, barColor);
        rimColor = typedarray.getColor(2, rimColor);
        linearProgress = typedarray.getBoolean(9, false);
        if (typedarray.getBoolean(0, false))
        {
            spin();
        }
        typedarray.recycle();
    }

    private void setupBounds(int i, int j)
    {
        int l = getPaddingTop();
        int i1 = getPaddingBottom();
        int j1 = getPaddingLeft();
        int k1 = getPaddingRight();
        if (!fillRadius)
        {
            int k = Math.min(Math.min(i - j1 - k1, j - i1 - l), circleRadius * 2 - barWidth * 2);
            i = (i - j1 - k1 - k) / 2 + j1;
            j = (j - l - i1 - k) / 2 + l;
            circleBounds = new RectF(barWidth + i, barWidth + j, (i + k) - barWidth, (j + k) - barWidth);
            return;
        } else
        {
            circleBounds = new RectF(barWidth + j1, barWidth + l, i - k1 - barWidth, j - i1 - barWidth);
            return;
        }
    }

    private void setupPaints()
    {
        barPaint.setColor(barColor);
        barPaint.setAntiAlias(true);
        barPaint.setStyle(android.graphics.Paint.Style.STROKE);
        barPaint.setStrokeWidth(barWidth);
        rimPaint.setColor(rimColor);
        rimPaint.setAntiAlias(true);
        rimPaint.setStyle(android.graphics.Paint.Style.STROKE);
        rimPaint.setStrokeWidth(rimWidth);
    }

    private void updateBarLength(long l)
    {
        if (pausedTimeWithoutGrowing >= 200L)
        {
            timeStartGrowing = timeStartGrowing + (double)l;
            float f;
            if (timeStartGrowing > barSpinCycleTime)
            {
                timeStartGrowing = timeStartGrowing - barSpinCycleTime;
                pausedTimeWithoutGrowing = 0L;
                boolean flag;
                if (barGrowingFromFront)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                barGrowingFromFront = flag;
            }
            f = (float)Math.cos((timeStartGrowing / barSpinCycleTime + 1.0D) * 3.1415926535897931D) / 2.0F + 0.5F;
            if (barGrowingFromFront)
            {
                barExtraLength = f * 254F;
                return;
            } else
            {
                f = 254F * (1.0F - f);
                mProgress = mProgress + (barExtraLength - f);
                barExtraLength = f;
                return;
            }
        } else
        {
            pausedTimeWithoutGrowing = pausedTimeWithoutGrowing + l;
            return;
        }
    }

    public int getBarColor()
    {
        return barColor;
    }

    public int getBarWidth()
    {
        return barWidth;
    }

    public int getCircleRadius()
    {
        return circleRadius;
    }

    public float getProgress()
    {
        if (isSpinning)
        {
            return -1F;
        } else
        {
            return mProgress / 360F;
        }
    }

    public int getRimColor()
    {
        return rimColor;
    }

    public int getRimWidth()
    {
        return rimWidth;
    }

    public float getSpinSpeed()
    {
        return spinSpeed / 360F;
    }

    public boolean isSpinning()
    {
        return isSpinning;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawArc(circleBounds, 360F, 360F, false, rimPaint);
        boolean flag = false;
        if (isSpinning)
        {
            flag = true;
            long l = SystemClock.uptimeMillis() - lastTimeAnimated;
            float f = ((float)l * spinSpeed) / 1000F;
            updateBarLength(l);
            mProgress = mProgress + f;
            if (mProgress > 360F)
            {
                mProgress = mProgress - 360F;
            }
            lastTimeAnimated = SystemClock.uptimeMillis();
            f = mProgress;
            float f3 = barExtraLength;
            canvas.drawArc(circleBounds, f - 90F, 16F + f3, false, barPaint);
        } else
        {
            if (mProgress != mTargetProgress)
            {
                flag = true;
                float f1 = (float)(SystemClock.uptimeMillis() - lastTimeAnimated) / 1000F;
                float f4 = spinSpeed;
                mProgress = Math.min(mProgress + f1 * f4, mTargetProgress);
                lastTimeAnimated = SystemClock.uptimeMillis();
            }
            float f5 = 0.0F;
            float f2 = mProgress;
            if (!linearProgress)
            {
                f5 = (float)(1.0D - Math.pow(1.0F - mProgress / 360F, 2.0F * 2.0F)) * 360F;
                f2 = (float)(1.0D - Math.pow(1.0F - mProgress / 360F, 2.0F)) * 360F;
            }
            canvas.drawArc(circleBounds, f5 - 90F, f2, false, barPaint);
        }
        if (flag)
        {
            invalidate();
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int l = circleRadius + getPaddingLeft() + getPaddingRight();
        int k = circleRadius + getPaddingTop() + getPaddingBottom();
        int i1 = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        if (i1 != 0x40000000)
        {
            if (i1 == 0x80000000)
            {
                i = Math.min(l, i);
            } else
            {
                i = l;
            }
        }
        if (j1 != 0x40000000 && i1 != 0x40000000)
        {
            if (j1 == 0x80000000)
            {
                j = Math.min(k, j);
            } else
            {
                j = k;
            }
        }
        setMeasuredDimension(i, j);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof WheelSavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        } else
        {
            parcelable = (WheelSavedState)parcelable;
            super.onRestoreInstanceState(parcelable.getSuperState());
            mProgress = ((WheelSavedState) (parcelable)).mProgress;
            mTargetProgress = ((WheelSavedState) (parcelable)).mTargetProgress;
            isSpinning = ((WheelSavedState) (parcelable)).isSpinning;
            spinSpeed = ((WheelSavedState) (parcelable)).spinSpeed;
            barWidth = ((WheelSavedState) (parcelable)).barWidth;
            barColor = ((WheelSavedState) (parcelable)).barColor;
            rimWidth = ((WheelSavedState) (parcelable)).rimWidth;
            rimColor = ((WheelSavedState) (parcelable)).rimColor;
            circleRadius = ((WheelSavedState) (parcelable)).circleRadius;
            linearProgress = ((WheelSavedState) (parcelable)).linearProgress;
            fillRadius = ((WheelSavedState) (parcelable)).fillRadius;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        WheelSavedState wheelsavedstate = new WheelSavedState(super.onSaveInstanceState());
        wheelsavedstate.mProgress = mProgress;
        wheelsavedstate.mTargetProgress = mTargetProgress;
        wheelsavedstate.isSpinning = isSpinning;
        wheelsavedstate.spinSpeed = spinSpeed;
        wheelsavedstate.barWidth = barWidth;
        wheelsavedstate.barColor = barColor;
        wheelsavedstate.rimWidth = rimWidth;
        wheelsavedstate.rimColor = rimColor;
        wheelsavedstate.circleRadius = circleRadius;
        wheelsavedstate.linearProgress = linearProgress;
        wheelsavedstate.fillRadius = fillRadius;
        return wheelsavedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        setupBounds(i, j);
        setupPaints();
        invalidate();
    }

    public void resetCount()
    {
        mProgress = 0.0F;
        mTargetProgress = 0.0F;
        invalidate();
    }

    public void setBarColor(int i)
    {
        barColor = i;
        setupPaints();
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setBarWidth(int i)
    {
        barWidth = i;
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setCircleRadius(int i)
    {
        circleRadius = i;
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setInstantProgress(float f)
    {
        if (isSpinning)
        {
            mProgress = 0.0F;
            isSpinning = false;
        }
        float f1;
        if (f > 1.0F)
        {
            f1 = f - 1.0F;
        } else
        {
            f1 = f;
            if (f < 0.0F)
            {
                f1 = 0.0F;
            }
        }
        if (f1 == mTargetProgress)
        {
            return;
        } else
        {
            mTargetProgress = Math.min(f1 * 360F, 360F);
            mProgress = mTargetProgress;
            lastTimeAnimated = SystemClock.uptimeMillis();
            invalidate();
            return;
        }
    }

    public void setLinearProgress(boolean flag)
    {
        linearProgress = flag;
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setProgress(float f)
    {
        if (isSpinning)
        {
            mProgress = 0.0F;
            isSpinning = false;
        }
        if (f <= 1.0F) goto _L2; else goto _L1
_L1:
        float f1 = f - 1.0F;
_L4:
        if (f1 == mTargetProgress)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        f1 = f;
        if (f < 0.0F)
        {
            f1 = 0.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mProgress == mTargetProgress)
        {
            lastTimeAnimated = SystemClock.uptimeMillis();
        }
        mTargetProgress = Math.min(f1 * 360F, 360F);
        invalidate();
        return;
    }

    public void setRimColor(int i)
    {
        rimColor = i;
        setupPaints();
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setRimWidth(int i)
    {
        rimWidth = i;
        if (!isSpinning)
        {
            invalidate();
        }
    }

    public void setSpinSpeed(float f)
    {
        spinSpeed = 360F * f;
    }

    public void spin()
    {
        lastTimeAnimated = SystemClock.uptimeMillis();
        isSpinning = true;
        invalidate();
    }

    public void stopSpinning()
    {
        isSpinning = false;
        mProgress = 0.0F;
        mTargetProgress = 0.0F;
        invalidate();
    }

}
