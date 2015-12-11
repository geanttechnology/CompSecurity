// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ProgressView extends View
{

    protected final Paint mPaint;
    public float mProgressRatio;

    public ProgressView(Context context)
    {
        super(context);
        mPaint = new Paint();
        init();
    }

    public ProgressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPaint = new Paint();
        init();
    }

    public ProgressView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaint = new Paint();
        init();
    }

    private void init()
    {
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.vine_green));
    }

    public void setColor(int i)
    {
        mPaint.setColor(i);
    }

    public void setProgressRatio(float f)
    {
        float f1 = f;
        if (f > 1.0F)
        {
            f1 = 1.0F;
        }
        mProgressRatio = f1;
        post(new Runnable() {

            final ProgressView this$0;

            public void run()
            {
                invalidate();
            }

            
            {
                this$0 = ProgressView.this;
                super();
            }
        });
    }
}
