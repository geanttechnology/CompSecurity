// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class AutofitTextView extends TextView
{

    private static final int DEFAULT_MIN_TEXT_SIZE = 8;
    private static final float PRECISION = 0.5F;
    private static final boolean SPEW = false;
    private static final String TAG = "me.grantland.widget.AutoFitTextView";
    private float mMaxTextSize;
    private float mMinTextSize;
    private Paint mPaint;
    private float mPrecision;

    public AutofitTextView(Context context)
    {
        super(context);
        init();
    }

    public AutofitTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private float getTextSize(Resources resources, String s, float f, float f1, float f2)
    {
        float f3 = (f1 + f2) / 2.0F;
        mPaint.setTextSize(TypedValue.applyDimension(0, f3, resources.getDisplayMetrics()));
        float f4 = mPaint.measureText(s);
        if (f2 - f1 < mPrecision)
        {
            return f1;
        }
        if (f4 > f)
        {
            return getTextSize(resources, s, f, f1, f3);
        }
        if (f4 < f)
        {
            return getTextSize(resources, s, f, f3, f2);
        } else
        {
            return f3;
        }
    }

    private void init()
    {
        mMinTextSize = 8F;
        mMaxTextSize = getTextSize();
        mPrecision = 0.5F;
        mPaint = new Paint();
    }

    private void refitText(String s, int i)
    {
        if (i > 0)
        {
            Context context = getContext();
            Resources resources = Resources.getSystem();
            i = i - getPaddingLeft() - getPaddingRight();
            float f = mMaxTextSize;
            float f1 = mMaxTextSize;
            if (context != null)
            {
                resources = context.getResources();
            }
            mPaint.set(getPaint());
            mPaint.setTextSize(f);
            if (mPaint.measureText(s) > (float)i)
            {
                f1 = getTextSize(resources, s, i, 0.0F, f1);
                f = f1;
                if (f1 < mMinTextSize)
                {
                    f = mMinTextSize;
                }
            }
            setTextSize(0, f);
        }
    }

    public float getMaxTextSize()
    {
        return mMaxTextSize;
    }

    public float getMinTextSize()
    {
        return mMinTextSize;
    }

    public float getPrecision()
    {
        return mPrecision;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = android.view.View.MeasureSpec.getSize(i);
        refitText(getText().toString(), i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k)
        {
            refitText(getText().toString(), i);
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        refitText(charsequence.toString(), getWidth());
    }

    public void setMaxTextSize(int i)
    {
        mMaxTextSize = i;
    }

    public void setMinTextSize(int i)
    {
        mMinTextSize = i;
    }

    public void setPrecision(float f)
    {
        mPrecision = f;
    }
}
