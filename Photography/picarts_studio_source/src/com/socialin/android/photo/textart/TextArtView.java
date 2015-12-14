// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.socialin.android.photo.textart:
//            TextArt, TextArtStyle

public class TextArtView extends View
{

    TextArt a;
    String b;
    TextArtStyle c;

    public TextArtView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.save();
        float f;
        Rect rect;
        if (getWidth() == 0 || getHeight() == 0)
        {
            f = 1.0F;
        } else
        {
            rect = a.getTextBounds();
            if (rect.height() <= getHeight() && rect.width() <= getWidth())
            {
                f = 1.0F;
            } else
            {
                f = Math.max((float)rect.height() / (float)getHeight(), (float)rect.width() / (float)getWidth());
            }
        }
        rect = a.getTextBounds();
        if (getWidth() != 0 && getHeight() != 0)
        {
            float f1 = (float)getWidth() * 0.5F;
            float f2 = (float)getHeight() * 0.5F;
            canvas.scale(1.0F / f, 1.0F / f, f1, f2);
            f = rect.width();
            float f3 = rect.height();
            canvas.drawText(b, f1 - f * 0.5F - (float)rect.left, f2 - f3 * 0.5F - (float)rect.top, a.getFillPaint());
        } else
        {
            canvas.drawText(b, 10F, 10 - rect.top, a.getFillPaint());
        }
        canvas.restore();
    }

    public void setTextArtObj(TextArt textart)
    {
        while (textart == null || textart.equals(a)) 
        {
            return;
        }
        a = textart;
        b = textart.getText();
        textart.refreshProperties(b, false);
        invalidate();
    }
}
