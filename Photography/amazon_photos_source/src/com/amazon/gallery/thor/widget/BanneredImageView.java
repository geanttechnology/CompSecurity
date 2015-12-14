// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            MediaItemImageView

public class BanneredImageView extends MediaItemImageView
{

    private int bannerColor;
    private float bannerMarginInPixels;
    private Paint bannerPaint;
    private Path bannerPath;
    private boolean bannerVisible;
    private float bannerWidthInPixels;
    private float pivotXPos;
    private float pivotYPos;
    private final Rect textBoundingRect;
    private int textColor;
    private Paint textPaint;
    private Rect textPosRect;
    private float textSizeInPixels;
    private String textToDisplay;
    private float textXPos;
    private float textYPos;
    private final Rect viewDrawingRect;

    public BanneredImageView(Context context)
    {
        this(context, null);
    }

    public BanneredImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BanneredImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        textToDisplay = "";
        bannerVisible = true;
        attributeset = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.BanneredImageView);
        textColor = attributeset.getColor(1, context.getResources().getColor(0x106000b));
        textSizeInPixels = attributeset.getDimensionPixelSize(2, 0);
        textToDisplay = attributeset.getString(0);
        if (textToDisplay == null)
        {
            textToDisplay = "";
        }
        bannerColor = attributeset.getColor(3, context.getResources().getColor(0x7f0900d2));
        bannerMarginInPixels = attributeset.getDimensionPixelSize(4, 20);
        bannerWidthInPixels = attributeset.getDimensionPixelSize(5, 0);
        attributeset.recycle();
        viewDrawingRect = new Rect();
        textBoundingRect = new Rect();
        initPaint();
    }

    private void initBannerPath(Rect rect)
    {
        Point point = new Point(Math.round((float)rect.width() - bannerMarginInPixels), 0);
        Point point1 = new Point(rect.width(), Math.round(bannerMarginInPixels));
        Point point2 = new Point(rect.width(), Math.round(bannerMarginInPixels + bannerWidthInPixels));
        rect = new Point(Math.round((float)rect.width() - bannerMarginInPixels - bannerWidthInPixels), 0);
        bannerPath = new Path();
        bannerPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        bannerPath.moveTo(point.x, point.y);
        bannerPath.lineTo(point1.x, point1.y);
        bannerPath.lineTo(point2.x, point2.y);
        bannerPath.lineTo(((Point) (rect)).x, ((Point) (rect)).y);
        bannerPath.lineTo(point.x, point.y);
        bannerPath.close();
    }

    private void initPaint()
    {
        textPaint = new Paint(1);
        textPaint.setTextSize(textSizeInPixels);
        textPaint.setColor(textColor);
        textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        textPaint.setTypeface(Typeface.defaultFromStyle(0));
        bannerPaint = new Paint(1);
        bannerPaint.setStyle(android.graphics.Paint.Style.FILL);
        bannerPaint.setColor(bannerColor);
    }

    private void initTextPosition(Rect rect)
    {
        textPosRect = new Rect(Math.round((float)rect.right - bannerMarginInPixels - bannerWidthInPixels), rect.top, rect.right, Math.round((float)rect.top + bannerMarginInPixels + bannerWidthInPixels));
        textPaint.getTextBounds(textToDisplay, 0, textToDisplay.length(), textBoundingRect);
        float f = bannerWidthInPixels / 1.414F;
        textXPos = textPosRect.centerX();
        textYPos = ((float)textPosRect.centerY() - f / 2.0F / 1.414F) + (float)textBoundingRect.height() / 4F;
        pivotXPos = textPosRect.centerX();
        pivotYPos = textPosRect.centerY();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (bannerVisible)
        {
            canvas.drawPath(bannerPath, bannerPaint);
            canvas.save();
            canvas.rotate(45F, pivotXPos, pivotYPos);
            canvas.drawText(textToDisplay, textXPos, textYPos, textPaint);
            canvas.restore();
        }
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        getDrawingRect(viewDrawingRect);
        Rect rect = viewDrawingRect;
        rect.left = rect.left + getPaddingLeft();
        rect = viewDrawingRect;
        rect.right = rect.right - getPaddingRight();
        rect = viewDrawingRect;
        rect.top = rect.top + getPaddingTop();
        rect = viewDrawingRect;
        rect.bottom = rect.bottom - getPaddingBottom();
        initBannerPath(viewDrawingRect);
        initTextPosition(viewDrawingRect);
    }

    public void setBannerColor(int i)
    {
        if (bannerColor != i)
        {
            bannerColor = i;
            bannerPaint.setColor(bannerColor);
        }
    }

    public void setBannerMarginInPixels(int i)
    {
        if (bannerMarginInPixels != (float)i)
        {
            bannerMarginInPixels = i;
        }
    }

    public void setBannerText(String s)
    {
        if (!s.equals(textToDisplay))
        {
            textToDisplay = s;
            requestLayout();
        }
    }

    public void setBannerTextColor(int i)
    {
        if (textColor != i)
        {
            textColor = i;
            textPaint.setColor(textColor);
        }
    }

    public void setBannerTextSizeInPixels(int i)
    {
        if (textSizeInPixels != (float)i)
        {
            textSizeInPixels = i;
            textPaint.setTextSize(textSizeInPixels);
        }
    }

    public void setBannerVisible(boolean flag)
    {
        bannerVisible = flag;
    }

    public void setBannerWidthInPixels(int i)
    {
        if (bannerWidthInPixels != (float)i)
        {
            bannerWidthInPixels = i;
        }
    }
}
