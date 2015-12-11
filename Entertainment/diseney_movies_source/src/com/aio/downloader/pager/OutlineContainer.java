// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

// Referenced classes of package com.aio.downloader.pager:
//            Util, JazzyViewPager

public class OutlineContainer extends FrameLayout
    implements Animatable
{

    private static final long ANIMATION_DURATION = 500L;
    private static final long FRAME_DURATION = 16L;
    private float mAlpha;
    private final Interpolator mInterpolator;
    private boolean mIsRunning;
    private Paint mOutlinePaint;
    private long mStartTime;
    private final Runnable mUpdater;

    public OutlineContainer(Context context)
    {
        super(context);
        mIsRunning = false;
        mAlpha = 1.0F;
        mInterpolator = new Interpolator() {

            final OutlineContainer this$0;

            public float getInterpolation(float f)
            {
                f--;
                return f * f * f + 1.0F;
            }

            
            {
                this$0 = OutlineContainer.this;
                super();
            }
        };
        mUpdater = new Runnable() {

            final OutlineContainer this$0;

            public void run()
            {
                long l = AnimationUtils.currentAnimationTimeMillis() - mStartTime;
                if (l >= 500L)
                {
                    mAlpha = 0.0F;
                    invalidate();
                    stop();
                    return;
                } else
                {
                    mAlpha = mInterpolator.getInterpolation(1.0F - (float)l / 500F);
                    invalidate();
                    postDelayed(mUpdater, 16L);
                    return;
                }
            }

            
            {
                this$0 = OutlineContainer.this;
                super();
            }
        };
        init();
    }

    public OutlineContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsRunning = false;
        mAlpha = 1.0F;
        mInterpolator = new _cls1();
        mUpdater = new _cls2();
        init();
    }

    public OutlineContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsRunning = false;
        mAlpha = 1.0F;
        mInterpolator = new _cls1();
        mUpdater = new _cls2();
        init();
    }

    private void init()
    {
        mOutlinePaint = new Paint();
        mOutlinePaint.setAntiAlias(true);
        mOutlinePaint.setStrokeWidth(Util.dpToPx(getResources(), 2));
        mOutlinePaint.setColor(getResources().getColor(0x7f080009));
        mOutlinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        int i = Util.dpToPx(getResources(), 10);
        setPadding(i, i, i, i);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        int i = Util.dpToPx(getResources(), 5);
        if (mOutlinePaint.getColor() != JazzyViewPager.sOutlineColor)
        {
            mOutlinePaint.setColor(JazzyViewPager.sOutlineColor);
        }
        mOutlinePaint.setAlpha((int)(mAlpha * 255F));
        canvas.drawRect(new Rect(i, i, getMeasuredWidth() - i, getMeasuredHeight() - i), mOutlinePaint);
    }

    public boolean isRunning()
    {
        return mIsRunning;
    }

    public void setOutlineAlpha(float f)
    {
        mAlpha = f;
    }

    public void start()
    {
        if (mIsRunning)
        {
            return;
        } else
        {
            mIsRunning = true;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            post(mUpdater);
            return;
        }
    }

    public void stop()
    {
        if (!mIsRunning)
        {
            return;
        } else
        {
            mIsRunning = false;
            return;
        }
    }




}
