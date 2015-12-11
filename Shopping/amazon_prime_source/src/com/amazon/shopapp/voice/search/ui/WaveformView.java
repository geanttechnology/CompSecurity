// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class WaveformView extends View
{

    public static final float BAR_MARGIN = 2.5F;
    public static final float BAR_WIDTH = 2.5F;
    public static final float MAX_VOICE_LEVEL = 2F;
    public static final int ORANGE_PAINT_COLOR = -19403;
    public static final float WAVE_ADVANCE_COEFFICIENT = 25F;
    public static final float WAVE_HEIGHT_MULTIPLIER = 80F;
    public static final float WAVE_PHASE_COEFFICIENT = 5F;
    public static final float WAVE_SPIKE_COEFFICIENT = 10F;
    private boolean mIsActive;
    private Paint mOrangePaint;
    private float mVoiceLevel;

    public WaveformView(Context context)
    {
        super(context);
        mIsActive = false;
        mOrangePaint = null;
        mVoiceLevel = 0.0F;
        init();
    }

    public WaveformView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsActive = false;
        mOrangePaint = null;
        mVoiceLevel = 0.0F;
        init();
    }

    public WaveformView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsActive = false;
        mOrangePaint = null;
        mVoiceLevel = 0.0F;
        init();
    }

    private void init()
    {
        mOrangePaint = new Paint();
        mOrangePaint.setColor(-19403);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f2 = (float)getHeight() / 2.0F;
        int j = (int)((float)getWidth() / 5F - 2.0F);
        float f3 = -25F * mVoiceLevel;
        for (int i = 1; i <= j; i++)
        {
            float f4 = (float)i * 5F;
            float f1 = (float)(i - 1) / (float)j;
            float f = (float)(i - 1) / (float)j;
            f1 = Math.max(0.0F, (float)Math.sin((float)((double)(f1 * 10F * 3.141593F) * (Math.sin(f3) / 5D + 1.0D)) + f3));
            f1 = mVoiceLevel * 80F * (f1 * (1.0F - f)) + 0.5F;
            f = f1;
            if (f1 > f2 / 2.0F)
            {
                f = f2 / 2.0F;
            }
            canvas.drawRect(f4, f2 - f - 2.0F, f4 + 2.5F, 2.0F + (f2 + f), mOrangePaint);
        }

        if (mIsActive)
        {
            invalidate();
        }
    }

    public void setVoiceLevel(float f)
    {
        mVoiceLevel = 0.2F * f + 0.8F * mVoiceLevel;
        if (mVoiceLevel <= 0.0F || mVoiceLevel > 2.0F)
        {
            mVoiceLevel = 0.0F;
        }
    }

    public void startAnimation()
    {
        if (mIsActive)
        {
            return;
        } else
        {
            mVoiceLevel = 0.0F;
            mIsActive = true;
            invalidate();
            return;
        }
    }

    public void stopAnimation()
    {
        if (!mIsActive)
        {
            return;
        } else
        {
            mVoiceLevel = 0.0F;
            mIsActive = false;
            return;
        }
    }
}
