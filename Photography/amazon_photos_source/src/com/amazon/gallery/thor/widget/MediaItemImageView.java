// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            TouchableImageView

public class MediaItemImageView extends TouchableImageView
{

    private int bannerHeightInPixels;
    private final Paint bannerPaint;
    private Rect bannerRect;
    private Path iconDrawPath;
    private int iconPaddingInPixels;
    private final Paint iconPaint;
    private int iconSizeInPixels;
    private final int primaryBackgroundColor;
    private final int primaryForegroundColor;
    private final Rect sizeUtilRect;
    private int textPaddingInPixels;
    private final Paint textPaint;
    private int textSizeInPixels;
    private String textToDisplay;
    private float textXPos;
    private float textYPos;

    public MediaItemImageView(Context context)
    {
        this(context, null);
    }

    public MediaItemImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MediaItemImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.MediaItemImageView);
        textSizeInPixels = attributeset.getDimensionPixelSize(1, 0);
        textToDisplay = attributeset.getString(0);
        textPaddingInPixels = attributeset.getDimensionPixelSize(2, 0);
        iconSizeInPixels = attributeset.getDimensionPixelSize(3, 0);
        iconPaddingInPixels = attributeset.getDimensionPixelSize(4, 0);
        bannerHeightInPixels = attributeset.getDimensionPixelSize(5, 0);
        attributeset.recycle();
        primaryBackgroundColor = Color.argb(150, 0, 0, 0);
        primaryForegroundColor = context.getResources().getColor(0x106000b);
        textPaint = new Paint(1);
        textPaint.setTextSize(textSizeInPixels);
        textPaint.setColor(primaryForegroundColor);
        textPaint.setTypeface(Typeface.defaultFromStyle(0));
        iconPaint = new Paint(1);
        iconPaint.setStyle(android.graphics.Paint.Style.FILL);
        iconPaint.setColor(primaryForegroundColor);
        bannerPaint = new Paint(1);
        bannerPaint.setStyle(android.graphics.Paint.Style.FILL);
        bannerPaint.setColor(primaryBackgroundColor);
        sizeUtilRect = new Rect();
        sizeUtilRect.setEmpty();
    }

    private void initIconPath(int i, int j)
    {
        Point point = new Point(i, j);
        Point point1 = new Point(i, iconSizeInPixels + j);
        Point point2 = new Point(Math.round((float)iconSizeInPixels / 1.25F) + i, iconSizeInPixels / 2 + j);
        iconDrawPath = new Path();
        iconDrawPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        iconDrawPath.moveTo(point.x, point.y);
        iconDrawPath.lineTo(point1.x, point1.y);
        iconDrawPath.lineTo(point2.x, point2.y);
        iconDrawPath.lineTo(point.x, point.y);
        iconDrawPath.close();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!StringUtils.isEmpty(textToDisplay))
        {
            canvas.drawRect(bannerRect, bannerPaint);
            canvas.drawPath(iconDrawPath, iconPaint);
            canvas.drawText(textToDisplay, textXPos, textYPos, textPaint);
        }
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (textToDisplay != null)
        {
            getDrawingRect(sizeUtilRect);
            bannerRect = new Rect(sizeUtilRect.left, sizeUtilRect.bottom - bannerHeightInPixels, sizeUtilRect.right, sizeUtilRect.bottom);
            initIconPath(bannerRect.left + iconPaddingInPixels, (bannerRect.top + bannerRect.height() / 2) - iconSizeInPixels / 2);
            sizeUtilRect.setEmpty();
            textPaint.getTextBounds(textToDisplay, 0, textToDisplay.length(), sizeUtilRect);
            textXPos = bannerRect.left + iconPaddingInPixels + iconSizeInPixels + textPaddingInPixels;
            textYPos = ((float)bannerRect.top + (float)bannerRect.height() / 2.0F) - (textPaint.ascent() + textPaint.descent()) / 2.0F;
        }
    }

    public void setBannerHeightInPixels(int i)
    {
        if (bannerHeightInPixels != i)
        {
            bannerHeightInPixels = i;
        }
    }

    public void setIconPaddingInPixels(int i)
    {
        if (iconPaddingInPixels != i)
        {
            iconPaddingInPixels = i;
        }
    }

    public void setIconSizeInPixels(int i)
    {
        if (iconSizeInPixels != i)
        {
            iconSizeInPixels = i;
        }
    }

    public void setText(String s)
    {
        if (!s.equals(textToDisplay))
        {
            textToDisplay = s;
            requestLayout();
        }
    }

    public void setTextPaddingInPixels(int i)
    {
        if (textPaddingInPixels != i)
        {
            textPaddingInPixels = i;
        }
    }

    public void setTextSizeInPixels(int i)
    {
        if (textSizeInPixels != i)
        {
            textSizeInPixels = i;
            textPaint.setTextSize(textSizeInPixels);
        }
    }
}
