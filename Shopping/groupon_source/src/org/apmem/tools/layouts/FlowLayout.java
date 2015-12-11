// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FlowLayout extends ViewGroup
{
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        private static int NO_SPACING = -1;
        private int horizontalSpacing;
        private boolean newLine;
        private int verticalSpacing;
        private int x;
        private int y;

        private void readStyleParameters(Context context, AttributeSet attributeset)
        {
            context = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.FlowLayout_LayoutParams);
            horizontalSpacing = context.getDimensionPixelSize(1, NO_SPACING);
            verticalSpacing = context.getDimensionPixelSize(2, NO_SPACING);
            newLine = context.getBoolean(0, false);
            context.recycle();
            return;
            attributeset;
            context.recycle();
            throw attributeset;
        }

        public boolean horizontalSpacingSpecified()
        {
            return horizontalSpacing != NO_SPACING;
        }

        public void setPosition(int i, int j)
        {
            x = i;
            y = j;
        }

        public boolean verticalSpacingSpecified()
        {
            return verticalSpacing != NO_SPACING;
        }







        public LayoutParams(int i, int j)
        {
            super(i, j);
            horizontalSpacing = NO_SPACING;
            verticalSpacing = NO_SPACING;
            newLine = false;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            horizontalSpacing = NO_SPACING;
            verticalSpacing = NO_SPACING;
            newLine = false;
            readStyleParameters(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            horizontalSpacing = NO_SPACING;
            verticalSpacing = NO_SPACING;
            newLine = false;
        }
    }


    private boolean debugDraw;
    private int horizontalSpacing;
    private int minChildrenPerRow;
    private int orientation;
    private int verticalSpacing;

    public FlowLayout(Context context)
    {
        super(context);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
        minChildrenPerRow = 1;
        readStyleParameters(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
        minChildrenPerRow = 1;
        readStyleParameters(context, attributeset);
    }

    public FlowLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
        minChildrenPerRow = 1;
        readStyleParameters(context, attributeset);
    }

    private Paint createPaint(int i)
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0F);
        return paint;
    }

    private void drawDebugInfo(Canvas canvas, View view)
    {
        if (debugDraw)
        {
            Paint paint = createPaint(-256);
            Paint paint1 = createPaint(0xff00ff00);
            Paint paint2 = createPaint(0xffff0000);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams.horizontalSpacing > 0)
            {
                float f = view.getRight();
                float f6 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                canvas.drawLine(f, f6, f + (float)layoutparams.horizontalSpacing, f6, paint);
                canvas.drawLine(((float)layoutparams.horizontalSpacing + f) - 4F, f6 - 4F, f + (float)layoutparams.horizontalSpacing, f6, paint);
                canvas.drawLine(((float)layoutparams.horizontalSpacing + f) - 4F, f6 + 4F, f + (float)layoutparams.horizontalSpacing, f6, paint);
            } else
            if (horizontalSpacing > 0)
            {
                float f3 = view.getRight();
                float f9 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                canvas.drawLine(f3, f9, f3 + (float)horizontalSpacing, f9, paint1);
                canvas.drawLine(((float)horizontalSpacing + f3) - 4F, f9 - 4F, f3 + (float)horizontalSpacing, f9, paint1);
                canvas.drawLine(((float)horizontalSpacing + f3) - 4F, f9 + 4F, f3 + (float)horizontalSpacing, f9, paint1);
            }
            if (layoutparams.verticalSpacing > 0)
            {
                float f1 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                float f7 = view.getBottom();
                canvas.drawLine(f1, f7, f1, f7 + (float)layoutparams.verticalSpacing, paint);
                canvas.drawLine(f1 - 4F, ((float)layoutparams.verticalSpacing + f7) - 4F, f1, f7 + (float)layoutparams.verticalSpacing, paint);
                canvas.drawLine(f1 + 4F, ((float)layoutparams.verticalSpacing + f7) - 4F, f1, f7 + (float)layoutparams.verticalSpacing, paint);
            } else
            if (verticalSpacing > 0)
            {
                float f4 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                float f10 = view.getBottom();
                canvas.drawLine(f4, f10, f4, f10 + (float)verticalSpacing, paint1);
                canvas.drawLine(f4 - 4F, ((float)verticalSpacing + f10) - 4F, f4, f10 + (float)verticalSpacing, paint1);
                canvas.drawLine(f4 + 4F, ((float)verticalSpacing + f10) - 4F, f4, f10 + (float)verticalSpacing, paint1);
            }
            if (layoutparams.newLine)
            {
                if (orientation == 0)
                {
                    float f2 = view.getLeft();
                    float f8 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                    canvas.drawLine(f2, f8 - 6F, f2, f8 + 6F, paint2);
                    return;
                } else
                {
                    float f5 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                    float f11 = view.getTop();
                    canvas.drawLine(f5 - 6F, f11, f5 + 6F, f11, paint2);
                    return;
                }
            }
        }
    }

    private int getHorizontalSpacing(LayoutParams layoutparams)
    {
        if (layoutparams.horizontalSpacingSpecified())
        {
            return layoutparams.horizontalSpacing;
        } else
        {
            return horizontalSpacing;
        }
    }

    private int getVerticalSpacing(LayoutParams layoutparams)
    {
        if (layoutparams.verticalSpacingSpecified())
        {
            return layoutparams.verticalSpacing;
        } else
        {
            return verticalSpacing;
        }
    }

    private void readStyleParameters(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.FlowLayout);
        horizontalSpacing = context.getDimensionPixelSize(0, 0);
        verticalSpacing = context.getDimensionPixelSize(1, 0);
        orientation = context.getInteger(2, 0);
        debugDraw = context.getBoolean(4, false);
        minChildrenPerRow = context.getInteger(3, 1);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void truncateView(TextView textview, int i)
    {
        textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
        textview.setSingleLine();
        textview.setHorizontallyScrolling(true);
        textview.setMaxWidth(i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        boolean flag = super.drawChild(canvas, view, l);
        drawDebugInfo(canvas, view);
        return flag;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-2, -2);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new LayoutParams(layoutparams);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = getChildCount();
        for (i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            view.layout(layoutparams.x, layoutparams.y, layoutparams.x + view.getMeasuredWidth(), layoutparams.y + view.getMeasuredHeight());
        }

    }

    protected void onMeasure(int i, int j)
    {
        int l5 = android.view.View.MeasureSpec.getSize(i) - getPaddingRight() - getPaddingLeft();
        int i6 = android.view.View.MeasureSpec.getSize(j) - getPaddingRight() - getPaddingLeft();
        int i2 = android.view.View.MeasureSpec.getMode(i);
        int j2 = android.view.View.MeasureSpec.getMode(j);
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int k2;
        int l2;
        int i3;
        int j3;
        int j6;
        if (orientation == 0)
        {
            l2 = l5;
            k2 = i2;
        } else
        {
            l2 = i6;
            k2 = j2;
        }
        k = 0;
        i1 = 0;
        l1 = 0;
        l = 0;
        j3 = 0;
        j1 = 0;
        j6 = getChildCount();
        i3 = 0;
        while (i3 < j6) 
        {
            View view = getChildAt(i3);
            int k1;
            if (view.getVisibility() == 8)
            {
                k1 = l;
                l = k;
                k = i1;
            } else
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                j1 = getHorizontalSpacing(layoutparams);
                k1 = getVerticalSpacing(layoutparams);
                int k3 = minChildrenPerRow;
                if (view instanceof TextView)
                {
                    truncateView((TextView)view, (l5 - (k3 - 1) * j1) / minChildrenPerRow);
                }
                int l3;
                int i4;
                int k4;
                int i5;
                int j5;
                int k5;
                if (i2 == 0x40000000)
                {
                    k3 = 0x80000000;
                } else
                {
                    k3 = i2;
                }
                l3 = android.view.View.MeasureSpec.makeMeasureSpec(l5, k3);
                if (j2 == 0x40000000)
                {
                    k3 = 0x80000000;
                } else
                {
                    k3 = j2;
                }
                view.measure(l3, android.view.View.MeasureSpec.makeMeasureSpec(i6, k3));
                i4 = view.getMeasuredWidth();
                k3 = view.getMeasuredHeight();
                if (orientation == 0)
                {
                    int j4 = i4;
                    int l4 = k3;
                    l3 = k1;
                    i4 = j1;
                    k1 = l4;
                    j1 = j4;
                } else
                {
                    l3 = k3;
                    k4 = k1;
                    i5 = j1;
                    j1 = l3;
                    k1 = i4;
                    i4 = k4;
                    l3 = i5;
                }
                k4 = l1 + j1;
                l1 = k4 + i4;
                if (layoutparams.newLine || k2 != 0 && k4 > l2)
                {
                    i5 = 1;
                } else
                {
                    i5 = 0;
                }
                j5 = i1;
                k5 = k;
                i1 = l;
                if (i5 != 0)
                {
                    i1 = l + k;
                    j5 = k1;
                    k4 = j1;
                    k5 = k1 + l3;
                    l1 = k4 + i4;
                }
                l3 = Math.max(k5, k1 + l3);
                k1 = Math.max(j5, k1);
                if (orientation == 0)
                {
                    k = (getPaddingLeft() + k4) - j1;
                    l = getPaddingTop() + i1;
                } else
                {
                    k = getPaddingLeft() + i1;
                    l = (getPaddingTop() + k4) - k3;
                }
                layoutparams.setPosition(k, l);
                j3 = Math.max(j3, k4);
                j1 = i1 + k1;
                k = k1;
                l = l3;
                k1 = i1;
            }
            i3++;
            i1 = k;
            k = l;
            l = k1;
        }
        if (orientation == 0)
        {
            setMeasuredDimension(resolveSize(j3, i), resolveSize(j1, j));
            return;
        } else
        {
            setMeasuredDimension(resolveSize(j1, i), resolveSize(j3, j));
            return;
        }
    }
}
