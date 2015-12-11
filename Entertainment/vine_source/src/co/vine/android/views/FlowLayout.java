// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

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
            horizontalSpacing = NO_SPACING;
            verticalSpacing = NO_SPACING;
            newLine = false;
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


    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private boolean debugDraw;
    private int horizontalSpacing;
    private int orientation;
    private int verticalSpacing;

    public FlowLayout(Context context)
    {
        super(context);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
        readStyleParameters(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
        readStyleParameters(context, attributeset);
    }

    public FlowLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
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
        horizontalSpacing = 0;
        verticalSpacing = 0;
        orientation = 0;
        debugDraw = false;
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
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = getPaddingRight();
        int j1 = getPaddingLeft();
        int k1 = android.view.View.MeasureSpec.getSize(j);
        int l1 = getPaddingTop();
        int j2 = getPaddingBottom();
        int i2 = android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getMode(j);
        int k2;
        int l2;
        int l4;
        if (orientation == 0)
        {
            j2 = l - i1 - j1;
        } else
        {
            j2 = k1 - l1 - j2;
            i2 = k;
        }
        k = 0;
        i1 = 0;
        l1 = 0;
        l = 0;
        l2 = 0;
        j1 = 0;
        l4 = getChildCount();
        k2 = 0;
        while (k2 < l4) 
        {
            View view = getChildAt(k2);
            if (view.getVisibility() == 8)
            {
                k1 = l;
                l = k;
                k = i1;
            } else
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutparams.width), getChildMeasureSpec(j, getPaddingTop() + getPaddingBottom(), layoutparams.height));
                k1 = getHorizontalSpacing(layoutparams);
                int j3 = getVerticalSpacing(layoutparams);
                int k3 = view.getMeasuredWidth();
                int i3 = view.getMeasuredHeight();
                int i4;
                boolean flag;
                int j4;
                int k4;
                if (orientation == 0)
                {
                    j1 = k3;
                    int l3 = i3;
                    k3 = k1;
                    k1 = l3;
                } else
                {
                    j1 = i3;
                    i4 = k1;
                    k1 = k3;
                    k3 = j3;
                    j3 = i4;
                }
                i4 = l1 + j1;
                l1 = i4 + k3;
                if (layoutparams.newLine || i2 != 0 && i4 > j2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j4 = i1;
                k4 = k;
                i1 = l;
                if (flag)
                {
                    i1 = l + k;
                    j4 = k1;
                    i4 = j1;
                    k4 = k1 + j3;
                    l1 = i4 + k3;
                }
                j3 = Math.max(k4, k1 + j3);
                k1 = Math.max(j4, k1);
                if (orientation == 0)
                {
                    k = (getPaddingLeft() + i4) - j1;
                    l = getPaddingTop() + i1;
                } else
                {
                    k = getPaddingLeft() + i1;
                    l = (getPaddingTop() + i4) - i3;
                }
                layoutparams.setPosition(k, l);
                l2 = Math.max(l2, i4);
                j1 = i1 + k1;
                k = k1;
                l = j3;
                k1 = i1;
            }
            k2++;
            i1 = k;
            k = l;
            l = k1;
        }
        if (orientation == 0)
        {
            k = l2 + (getPaddingLeft() + getPaddingRight());
            l = j1 + (getPaddingBottom() + getPaddingTop());
        } else
        {
            k = l2 + (getPaddingBottom() + getPaddingTop());
            l = j1 + (getPaddingLeft() + getPaddingRight());
        }
        if (orientation == 0)
        {
            setMeasuredDimension(resolveSize(k, i), resolveSize(l, j));
            return;
        } else
        {
            setMeasuredDimension(resolveSize(l, i), resolveSize(k, j));
            return;
        }
    }
}
