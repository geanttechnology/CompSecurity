// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class NumberProgressBar extends View
{

    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color";
    private static final String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_TEXT_VISBILITY = "text_visibility";
    private static final String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color";
    private static final String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height";
    private static final int PROGRESS_TEXT_INVISIBLE = 1;
    private static final int PROGRESS_TEXT_VISIBLE = 0;
    private final float default_progress_text_offset;
    private final float default_reached_bar_height;
    private final int default_reached_color;
    private final int default_text_color;
    private final float default_text_size;
    private final float default_unreached_bar_height;
    private final int default_unreached_color;
    private Context mContext;
    private String mCurrentDrawText;
    private boolean mDrawReachedBar;
    private float mDrawTextEnd;
    private float mDrawTextStart;
    private float mDrawTextWidth;
    private boolean mDrawUnreachedBar;
    private boolean mIfDrawText;
    private int mMax;
    private float mOffset;
    private String mPrefix;
    private int mProgress;
    private int mReachedBarColor;
    private float mReachedBarHeight;
    private Paint mReachedBarPaint;
    private RectF mReachedRectF;
    private String mSuffix;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int mUnreachedBarColor;
    private float mUnreachedBarHeight;
    private Paint mUnreachedBarPaint;
    private RectF mUnreachedRectF;

    public NumberProgressBar(Context context)
    {
        this(context, null);
    }

    public NumberProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100c5);
    }

    public NumberProgressBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMax = 100;
        mProgress = 0;
        mSuffix = "%";
        mPrefix = "";
        default_text_color = Color.rgb(66, 145, 241);
        default_reached_color = Color.rgb(66, 145, 241);
        default_unreached_color = Color.rgb(204, 204, 204);
        mUnreachedRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        mReachedRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        mDrawUnreachedBar = true;
        mDrawReachedBar = true;
        mIfDrawText = true;
        mContext = context;
        default_reached_bar_height = dp2px(1.5F);
        default_unreached_bar_height = dp2px(1.0F);
        default_text_size = sp2px(10F);
        default_progress_text_offset = dp2px(3F);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.NumberProgressBar, i, 0);
        mReachedBarColor = context.getColor(3, default_reached_color);
        mUnreachedBarColor = context.getColor(2, default_unreached_color);
        mTextColor = context.getColor(7, default_text_color);
        mTextSize = context.getDimension(6, default_text_size);
        mReachedBarHeight = context.getDimension(4, default_reached_bar_height);
        mUnreachedBarHeight = context.getDimension(5, default_unreached_bar_height);
        mOffset = context.getDimension(8, default_progress_text_offset);
        if (context.getInt(9, 0) != 0)
        {
            mIfDrawText = false;
        }
        setProgress(0);
        setMax(100);
        context.recycle();
        initializePainters();
    }

    private void calculateDrawRectF()
    {
        mCurrentDrawText = String.format("%d", new Object[] {
            Integer.valueOf((getProgress() * 100) / getMax())
        });
        mCurrentDrawText = (new StringBuilder()).append(mPrefix).append(mCurrentDrawText).append(mSuffix).toString();
        mDrawTextWidth = mTextPaint.measureText(mCurrentDrawText);
        float f;
        if (getProgress() == 0)
        {
            mDrawReachedBar = false;
            mDrawTextStart = getPaddingLeft();
        } else
        {
            mDrawReachedBar = true;
            mReachedRectF.left = getPaddingLeft();
            mReachedRectF.top = (float)getHeight() / 2.0F - mReachedBarHeight / 2.0F;
            mReachedRectF.right = (((float)(getWidth() - getPaddingLeft() - getPaddingRight()) / ((float)getMax() * 1.0F)) * (float)getProgress() - mOffset) + (float)getPaddingLeft();
            mReachedRectF.bottom = (float)getHeight() / 2.0F + mReachedBarHeight / 2.0F;
            mDrawTextStart = mReachedRectF.right + mOffset;
        }
        mDrawTextEnd = (int)((float)getHeight() / 2.0F - (mTextPaint.descent() + mTextPaint.ascent()) / 2.0F);
        if (mDrawTextStart + mDrawTextWidth >= (float)(getWidth() - getPaddingRight()))
        {
            mDrawTextStart = (float)(getWidth() - getPaddingRight()) - mDrawTextWidth;
            mReachedRectF.right = mDrawTextStart - mOffset;
        }
        f = mDrawTextStart + mDrawTextWidth + mOffset;
        if (f >= (float)(getWidth() - getPaddingRight()))
        {
            mDrawUnreachedBar = false;
            return;
        } else
        {
            mDrawUnreachedBar = true;
            mUnreachedRectF.left = f;
            mUnreachedRectF.right = getWidth() - getPaddingRight();
            mUnreachedRectF.top = (float)getHeight() / 2.0F + -mUnreachedBarHeight / 2.0F;
            mUnreachedRectF.bottom = (float)getHeight() / 2.0F + mUnreachedBarHeight / 2.0F;
            return;
        }
    }

    private void calculateDrawRectFWithoutProgressText()
    {
        mReachedRectF.left = getPaddingLeft();
        mReachedRectF.top = (float)getHeight() / 2.0F - mReachedBarHeight / 2.0F;
        mReachedRectF.right = ((float)(getWidth() - getPaddingLeft() - getPaddingRight()) / ((float)getMax() * 1.0F)) * (float)getProgress() + (float)getPaddingLeft();
        mReachedRectF.bottom = (float)getHeight() / 2.0F + mReachedBarHeight / 2.0F;
        mUnreachedRectF.left = mReachedRectF.right;
        mUnreachedRectF.right = getWidth() - getPaddingRight();
        mUnreachedRectF.top = (float)getHeight() / 2.0F + -mUnreachedBarHeight / 2.0F;
        mUnreachedRectF.bottom = (float)getHeight() / 2.0F + mUnreachedBarHeight / 2.0F;
    }

    private void initializePainters()
    {
        mReachedBarPaint = new Paint(1);
        mReachedBarPaint.setColor(mReachedBarColor);
        mUnreachedBarPaint = new Paint(1);
        mUnreachedBarPaint.setColor(mUnreachedBarColor);
        mTextPaint = new Paint(1);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
    }

    private int measure(int i, boolean flag)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getSize(i);
        if (flag)
        {
            i = getPaddingLeft() + getPaddingRight();
        } else
        {
            i = getPaddingTop() + getPaddingBottom();
        }
        if (k == 0x40000000)
        {
            return l;
        }
        int j;
        if (flag)
        {
            j = getSuggestedMinimumWidth();
        } else
        {
            j = getSuggestedMinimumHeight();
        }
        i = j + i;
        if (k == 0x80000000)
        {
            if (flag)
            {
                return Math.max(i, l);
            } else
            {
                return Math.min(i, l);
            }
        } else
        {
            return i;
        }
    }

    public float dp2px(float f)
    {
        return getResources().getDisplayMetrics().density * f + 0.5F;
    }

    public int getMax()
    {
        return mMax;
    }

    public String getPrefix()
    {
        return mPrefix;
    }

    public int getProgress()
    {
        return mProgress;
    }

    public float getProgressTextSize()
    {
        return mTextSize;
    }

    public boolean getProgressTextVisibility()
    {
        return mIfDrawText;
    }

    public int getReachedBarColor()
    {
        return mReachedBarColor;
    }

    public float getReachedBarHeight()
    {
        return mReachedBarHeight;
    }

    public String getSuffix()
    {
        return mSuffix;
    }

    protected int getSuggestedMinimumHeight()
    {
        return Math.max((int)mTextSize, Math.max((int)mReachedBarHeight, (int)mUnreachedBarHeight));
    }

    protected int getSuggestedMinimumWidth()
    {
        return (int)mTextSize;
    }

    public int getTextColor()
    {
        return mTextColor;
    }

    public int getUnreachedBarColor()
    {
        return mUnreachedBarColor;
    }

    public float getUnreachedBarHeight()
    {
        return mUnreachedBarHeight;
    }

    public void incrementProgressBy(int i)
    {
        if (i > 0)
        {
            setProgress(getProgress() + i);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (mIfDrawText)
        {
            calculateDrawRectF();
        } else
        {
            calculateDrawRectFWithoutProgressText();
        }
        if (mDrawReachedBar)
        {
            canvas.drawRect(mReachedRectF, mReachedBarPaint);
        }
        if (mDrawUnreachedBar)
        {
            canvas.drawRect(mUnreachedRectF, mUnreachedBarPaint);
        }
        if (mIfDrawText)
        {
            canvas.drawText(mCurrentDrawText, mDrawTextStart, mDrawTextEnd, mTextPaint);
        }
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(measure(i, true), measure(j, false));
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            Bundle bundle = (Bundle)parcelable;
            mTextColor = bundle.getInt("text_color");
            mTextSize = bundle.getFloat("text_size");
            mReachedBarHeight = bundle.getFloat("reached_bar_height");
            mUnreachedBarHeight = bundle.getFloat("unreached_bar_height");
            mReachedBarColor = bundle.getInt("reached_bar_color");
            mUnreachedBarColor = bundle.getInt("unreached_bar_color");
            initializePainters();
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt("progress"));
            setPrefix(bundle.getString("prefix"));
            setSuffix(bundle.getString("suffix"));
            if (bundle.getBoolean("text_visibility"))
            {
                parcelable = ProgressTextVisibility.Visible;
            } else
            {
                parcelable = ProgressTextVisibility.Invisible;
            }
            setProgressTextVisibility(parcelable);
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getProgressTextSize());
        bundle.putFloat("reached_bar_height", getReachedBarHeight());
        bundle.putFloat("unreached_bar_height", getUnreachedBarHeight());
        bundle.putInt("reached_bar_color", getReachedBarColor());
        bundle.putInt("unreached_bar_color", getUnreachedBarColor());
        bundle.putInt("max", getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffix());
        bundle.putString("prefix", getPrefix());
        bundle.putBoolean("text_visibility", getProgressTextVisibility());
        return bundle;
    }

    public void setMax(int i)
    {
        if (i > 0)
        {
            mMax = i;
            invalidate();
        }
    }

    public void setPrefix(String s)
    {
        if (s == null)
        {
            mPrefix = "";
            return;
        } else
        {
            mPrefix = s;
            return;
        }
    }

    public void setProgress(int i)
    {
        if (i <= getMax() && i >= 0)
        {
            mProgress = i;
            invalidate();
        }
    }

    public void setProgressTextColor(int i)
    {
        mTextColor = i;
        mTextPaint.setColor(mTextColor);
        invalidate();
    }

    public void setProgressTextSize(float f)
    {
        mTextSize = f;
        mTextPaint.setTextSize(mTextSize);
        invalidate();
    }

    public void setProgressTextVisibility(ProgressTextVisibility progresstextvisibility)
    {
        boolean flag;
        if (progresstextvisibility == ProgressTextVisibility.Visible)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIfDrawText = flag;
        invalidate();
    }

    public void setReachedBarColor(int i)
    {
        mReachedBarColor = i;
        mReachedBarPaint.setColor(mReachedBarColor);
        invalidate();
    }

    public void setReachedBarHeight(float f)
    {
        mReachedBarHeight = f;
    }

    public void setSuffix(String s)
    {
        if (s == null)
        {
            mSuffix = "";
            return;
        } else
        {
            mSuffix = s;
            return;
        }
    }

    public void setUnreachedBarColor(int i)
    {
        mUnreachedBarColor = i;
        mUnreachedBarPaint.setColor(mReachedBarColor);
        invalidate();
    }

    public void setUnreachedBarHeight(float f)
    {
        mUnreachedBarHeight = f;
    }

    public float sp2px(float f)
    {
        return getResources().getDisplayMetrics().scaledDensity * f;
    }

    private class ProgressTextVisibility extends Enum
    {

        private static final ProgressTextVisibility $VALUES[];
        public static final ProgressTextVisibility Invisible;
        public static final ProgressTextVisibility Visible;

        public static ProgressTextVisibility valueOf(String s)
        {
            return (ProgressTextVisibility)Enum.valueOf(com/instamag/activity/library/view/NumberProgressBar$ProgressTextVisibility, s);
        }

        public static ProgressTextVisibility[] values()
        {
            return (ProgressTextVisibility[])$VALUES.clone();
        }

        static 
        {
            Visible = new ProgressTextVisibility("Visible", 0);
            Invisible = new ProgressTextVisibility("Invisible", 1);
            $VALUES = (new ProgressTextVisibility[] {
                Visible, Invisible
            });
        }

        private ProgressTextVisibility(String s, int i)
        {
            super(s, i);
        }
    }

}
