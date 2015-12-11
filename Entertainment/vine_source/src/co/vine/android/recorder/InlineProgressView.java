// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

// Referenced classes of package co.vine.android.recorder:
//            ProgressView

public class InlineProgressView extends ProgressView
{

    final RectF mRect;

    public InlineProgressView(Context context)
    {
        super(context);
        mRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }

    public InlineProgressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }

    public InlineProgressView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    }

    protected void onDraw(Canvas canvas)
    {
        if (mProgressRatio > 0.0F)
        {
            int i = getMeasuredHeight();
            int j = getMeasuredWidth();
            int k = i / 2;
            mRect.right = mProgressRatio * (float)j;
            mRect.bottom = i;
            canvas.drawRoundRect(mRect, k, k, mPaint);
        }
    }
}
