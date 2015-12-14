// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package com.mopub.mobileads.resource:
//            BaseWidgetDrawable

public class CloseButtonDrawable extends BaseWidgetDrawable
{

    private final Paint closeButtonPaint;
    private final float halfStrokeWidth;

    public CloseButtonDrawable()
    {
        this(8F);
    }

    public CloseButtonDrawable(float f)
    {
        halfStrokeWidth = f / 2.0F;
        closeButtonPaint = new Paint();
        closeButtonPaint.setColor(-1);
        closeButtonPaint.setStrokeWidth(f);
        closeButtonPaint.setStrokeCap(DrawableConstants.CloseButton.STROKE_CAP);
    }

    public void draw(Canvas canvas)
    {
        int i = getBounds().width();
        int j = getBounds().height();
        canvas.drawLine(0.0F + halfStrokeWidth, (float)j - halfStrokeWidth, (float)i - halfStrokeWidth, 0.0F + halfStrokeWidth, closeButtonPaint);
        canvas.drawLine(0.0F + halfStrokeWidth, 0.0F + halfStrokeWidth, (float)i - halfStrokeWidth, (float)j - halfStrokeWidth, closeButtonPaint);
    }
}
