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

    private final Paint closeButtonPaint = new Paint();

    public CloseButtonDrawable()
    {
        closeButtonPaint.setColor(-1);
        closeButtonPaint.setStrokeWidth(8F);
        closeButtonPaint.setStrokeCap(DrawableConstants.CloseButton.STROKE_CAP);
    }

    public void draw(Canvas canvas)
    {
        int i = getBounds().width();
        int j = getBounds().height();
        canvas.drawLine(0.0F, j, i, 0.0F, closeButtonPaint);
        canvas.drawLine(0.0F, 0.0F, i, j, closeButtonPaint);
    }
}
