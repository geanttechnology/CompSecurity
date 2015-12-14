// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class TooltipTextDrawable extends Drawable
{

    static final String TAG = "ToolTipTextDrawable";
    private final float arrowRatio;
    private int arrowWeight;
    private final int backgroundColor;
    private final Paint bgPaint;
    private final float ellipseSize;
    private TooltipManager.Gravity gravity;
    private int padding;
    private final Path path = new Path();
    private Point point;
    private final RectF rectF = new RectF();
    private final Paint stPaint;
    private final int strokeColor;
    private final int strokeWidth;

    public TooltipTextDrawable(Context context, TooltipManager.Builder builder)
    {
        padding = 0;
        arrowWeight = 0;
        context = context.getTheme().obtainStyledAttributes(null, R.styleable.TooltipLayout, builder.defStyleAttr, builder.defStyleRes);
        ellipseSize = context.getDimensionPixelSize(4, 4);
        strokeWidth = context.getDimensionPixelSize(3, 30);
        backgroundColor = context.getColor(2, 0);
        strokeColor = context.getColor(1, 0);
        arrowRatio = context.getFloat(5, 1.4F);
        context.recycle();
        if (backgroundColor != 0)
        {
            bgPaint = new Paint(1);
            bgPaint.setColor(backgroundColor);
            bgPaint.setStyle(android.graphics.Paint.Style.FILL);
        } else
        {
            bgPaint = null;
        }
        if (strokeColor != 0)
        {
            stPaint = new Paint(1);
            stPaint.setColor(strokeColor);
            stPaint.setStyle(android.graphics.Paint.Style.STROKE);
            stPaint.setStrokeWidth(strokeWidth);
        } else
        {
            stPaint = null;
        }
    }

    private void calculatePath(Rect rect)
    {
        float f;
        float f1;
        float f2;
        float f3;
        boolean flag1;
        int i;
        int j;
        int k;
        int l;
        i = rect.left + padding;
        j = rect.top + padding;
        k = rect.right - padding;
        l = rect.bottom - padding;
        f = (float)l - ellipseSize;
        f1 = (float)k - ellipseSize;
        f2 = (float)j + ellipseSize;
        f3 = (float)i + ellipseSize;
        flag1 = false;
        if (point == null || gravity == null) goto _L2; else goto _L1
_L1:
        if (gravity != TooltipManager.Gravity.RIGHT && gravity != TooltipManager.Gravity.LEFT) goto _L4; else goto _L3
_L3:
        boolean flag = flag1;
        if (point.y < j) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (point.y > l) goto _L6; else goto _L7
_L7:
        if ((float)(point.y + j + arrowWeight) <= f) goto _L9; else goto _L8
_L8:
        point.y = (int)(f - (float)arrowWeight - (float)j);
_L11:
        flag = true;
_L6:
        path.reset();
        if (point.y < j)
        {
            point.y = j;
        } else
        if (point.y > l)
        {
            point.y = l;
        }
        if (point.x < i)
        {
            point.x = i;
        }
        if (point.x > k)
        {
            point.x = k;
        }
        path.moveTo((float)i + ellipseSize, j);
        if (flag && gravity == TooltipManager.Gravity.BOTTOM)
        {
            path.lineTo((point.x + i) - arrowWeight, j);
            path.lineTo(point.x + i, rect.top);
            path.lineTo(point.x + i + arrowWeight, j);
        }
        path.lineTo((float)k - ellipseSize, j);
        path.quadTo(k, j, k, (float)j + ellipseSize);
        if (flag && gravity == TooltipManager.Gravity.LEFT)
        {
            path.lineTo(k, (point.y + j) - arrowWeight);
            path.lineTo(rect.right, point.y + j);
            path.lineTo(k, point.y + j + arrowWeight);
        }
        path.lineTo(k, (float)l - ellipseSize);
        path.quadTo(k, l, (float)k - ellipseSize, l);
        if (flag && gravity == TooltipManager.Gravity.TOP)
        {
            path.lineTo(point.x + i + arrowWeight, l);
            path.lineTo(point.x + i, rect.bottom);
            path.lineTo((point.x + i) - arrowWeight, l);
        }
        path.lineTo((float)i + ellipseSize, l);
        path.quadTo(i, l, i, (float)l - ellipseSize);
        if (flag && gravity == TooltipManager.Gravity.RIGHT)
        {
            path.lineTo(i, point.y + j + arrowWeight);
            path.lineTo(rect.left, point.y + j);
            path.lineTo(i, (point.y + j) - arrowWeight);
        }
        path.lineTo(i, (float)j + ellipseSize);
        path.quadTo(i, j, (float)i + ellipseSize, j);
        return;
_L9:
        if ((float)((point.y + j) - arrowWeight) < f2)
        {
            point.y = (int)(((float)arrowWeight + f2) - (float)j);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (point.x >= i)
        {
            flag = flag1;
            if (point.x <= k)
            {
                flag = flag1;
                if (point.x >= i)
                {
                    flag = flag1;
                    if (point.x <= k)
                    {
                        if ((float)(point.x + i + arrowWeight) > f1)
                        {
                            point.x = (int)(f1 - (float)arrowWeight - (float)i);
                        } else
                        if ((float)((point.x + i) - arrowWeight) < f3)
                        {
                            point.x = (int)(((float)arrowWeight + f3) - (float)i);
                        }
                        flag = true;
                    }
                }
            }
        }
          goto _L6
_L2:
        rectF.set(i, j, k, l);
        path.addRoundRect(rectF, ellipseSize, ellipseSize, android.graphics.Path.Direction.CW);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void draw(Canvas canvas)
    {
        if (bgPaint != null)
        {
            canvas.drawPath(path, bgPaint);
        }
        if (stPaint != null)
        {
            canvas.drawPath(path, stPaint);
        }
    }

    public int getOpacity()
    {
        return 0;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        calculatePath(rect);
    }

    public void setAlpha(int i)
    {
    }

    public void setAnchor(TooltipManager.Gravity gravity1, int i)
    {
        gravity = gravity1;
        padding = i;
        arrowWeight = (int)((float)i / arrowRatio);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    public void setDestinationPoint(Point point1)
    {
        point = new Point(point1);
    }
}
