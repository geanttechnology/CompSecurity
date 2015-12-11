// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

// Referenced classes of package co.vine.android.recorder:
//            ProgressView

public class RegularProgressView extends ProgressView
{

    public RegularProgressView(Context context)
    {
        super(context);
    }

    public RegularProgressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RegularProgressView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mProgressRatio > 0.0F)
        {
            canvas.drawRect(0.0F, 0.0F, mProgressRatio * (float)getMeasuredWidth(), getMeasuredHeight(), mPaint);
        }
    }
}
