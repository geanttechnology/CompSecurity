// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            MediaItemImageView

public class TextOverlayImageView extends MediaItemImageView
{

    private Paint paint;
    private int textColor;
    private float textSizeInPixels;
    private String textToDisplay;
    private final Rect textViewRect;
    private float textXPos;
    private float textYPos;
    private final Rect viewDrawingRect;

    public TextOverlayImageView(Context context)
    {
        this(context, null);
    }

    public TextOverlayImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TextOverlayImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.TextOverlayImageView);
        textColor = attributeset.getColor(1, context.getResources().getColor(0x106000b));
        textSizeInPixels = attributeset.getDimensionPixelSize(2, 0);
        textToDisplay = attributeset.getString(0);
        attributeset.recycle();
        viewDrawingRect = new Rect();
        textViewRect = new Rect();
        initPaint();
    }

    private void initPaint()
    {
        paint = new Paint(1);
        paint.setTextSize(textSizeInPixels);
        paint.setColor(textColor);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setTypeface(Typeface.defaultFromStyle(1));
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!StringUtils.isEmpty(textToDisplay))
        {
            canvas.drawText(textToDisplay, textXPos, textYPos, paint);
        }
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (textToDisplay != null)
        {
            getDrawingRect(viewDrawingRect);
            paint.getTextBounds(textToDisplay, 0, textToDisplay.length(), textViewRect);
            textXPos = viewDrawingRect.centerX();
            textYPos = (float)viewDrawingRect.centerY() + (float)textViewRect.height() / 2.0F;
        }
    }

    public void setOverlayText(String s)
    {
        if (!s.equals(textToDisplay))
        {
            textToDisplay = s;
            requestLayout();
        }
    }

    public void setOverlayTextSizeInPixels(int i)
    {
        if (textSizeInPixels != (float)i)
        {
            textSizeInPixels = i;
            paint.setTextSize(textSizeInPixels);
        }
    }

    public void setTextColor(int i)
    {
        if (textColor != i)
        {
            textColor = i;
            paint.setColor(textColor);
        }
    }
}
