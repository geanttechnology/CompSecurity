// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

public class AspectFrameLayout extends FrameLayout
{

    private static final String TAG = "Grafika-AFL";
    private double mTargetAspect;

    public AspectFrameLayout(Context context)
    {
        super(context);
        mTargetAspect = -1D;
    }

    public AspectFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTargetAspect = -1D;
    }

    protected void onMeasure(int i, int j)
    {
        Log.d("Grafika-AFL", (new StringBuilder()).append("onMeasure target=").append(mTargetAspect).append(" width=[").append(android.view.View.MeasureSpec.toString(i)).append("] height=[").append(android.view.View.MeasureSpec.toString(j)).append("]").toString());
        int k = i;
        int l = j;
        if (mTargetAspect > 0.0D)
        {
            k = android.view.View.MeasureSpec.getSize(i);
            l = android.view.View.MeasureSpec.getSize(j);
            k -= 0;
            l -= 0;
            double d = (double)k / (double)l;
            if (Math.abs(mTargetAspect / d - 1.0D) < 0.01D)
            {
                Log.d("Grafika-AFL", (new StringBuilder()).append("aspect ratio is good (target=").append(mTargetAspect).append(", view=").append(k).append("x").append(l).append(")").toString());
                l = j;
                k = i;
            } else
            {
                i = (int)((double)k / mTargetAspect);
                Log.d("Grafika-AFL", (new StringBuilder()).append("new size=").append(k).append("x").append(i).append(" + padding ").append(0).append("x").append(0).toString());
                k = android.view.View.MeasureSpec.makeMeasureSpec(k + 0, 0x40000000);
                l = android.view.View.MeasureSpec.makeMeasureSpec(i + 0, 0x40000000);
            }
        }
        super.onMeasure(k, l);
    }

    public void setAspectRatio(double d)
    {
        if (d < 0.0D)
        {
            throw new IllegalArgumentException();
        }
        Log.d("Grafika-AFL", (new StringBuilder()).append("Setting aspect ratio to ").append(d).append(" (was ").append(mTargetAspect).append(")").toString());
        if (mTargetAspect != d)
        {
            mTargetAspect = d;
            requestLayout();
        }
    }
}
