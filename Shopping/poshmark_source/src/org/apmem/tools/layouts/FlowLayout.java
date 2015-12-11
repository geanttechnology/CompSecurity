// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.apmem.tools.layouts:
//            LayoutConfiguration, LineDefinition

public class FlowLayout extends ViewGroup
{
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        public int gravity;
        private int inlineStartLength;
        private int inlineStartThickness;
        private int length;
        public boolean newLine;
        private int spacingLength;
        private int spacingThickness;
        private int thickness;
        public float weight;
        private int x;
        private int y;

        private void readStyleParameters(Context context, AttributeSet attributeset)
        {
            context = context.obtainStyledAttributes(attributeset, R.styleable.FlowLayout_LayoutParams);
            newLine = context.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_newLine, false);
            gravity = context.getInt(R.styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
            weight = context.getFloat(R.styleable.FlowLayout_LayoutParams_layout_weight, -1F);
            context.recycle();
            return;
            attributeset;
            context.recycle();
            throw attributeset;
        }

        void clearCalculatedFields(int i)
        {
            if (i == 0)
            {
                spacingLength = leftMargin + rightMargin;
                spacingThickness = topMargin + bottomMargin;
                return;
            } else
            {
                spacingLength = topMargin + bottomMargin;
                spacingThickness = leftMargin + rightMargin;
                return;
            }
        }

        int getInlineStartLength()
        {
            return inlineStartLength;
        }

        int getInlineStartThickness()
        {
            return inlineStartThickness;
        }

        int getLength()
        {
            return length;
        }

        int getSpacingLength()
        {
            return spacingLength;
        }

        int getSpacingThickness()
        {
            return spacingThickness;
        }

        int getThickness()
        {
            return thickness;
        }

        public boolean gravitySpecified()
        {
            return gravity != 0;
        }

        void setInlineStartLength(int i)
        {
            inlineStartLength = i;
        }

        void setInlineStartThickness(int i)
        {
            inlineStartThickness = i;
        }

        void setLength(int i)
        {
            length = i;
        }

        void setPosition(int i, int j)
        {
            x = i;
            y = j;
        }

        void setThickness(int i)
        {
            thickness = i;
        }

        public boolean weightSpecified()
        {
            return weight >= 0.0F;
        }



        public LayoutParams(int i, int j)
        {
            super(i, j);
            newLine = false;
            gravity = 0;
            weight = -1F;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            newLine = false;
            gravity = 0;
            weight = -1F;
            readStyleParameters(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            newLine = false;
            gravity = 0;
            weight = -1F;
        }
    }


    public static final int HORIZONTAL = 0;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int VERTICAL = 1;
    private final LayoutConfiguration config;
    List lines;

    public FlowLayout(Context context)
    {
        super(context);
        lines = new ArrayList();
        config = new LayoutConfiguration(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        lines = new ArrayList();
        config = new LayoutConfiguration(context, attributeset);
    }

    public FlowLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        lines = new ArrayList();
        config = new LayoutConfiguration(context, attributeset);
    }

    private void applyGravityToLine(LineDefinition linedefinition)
    {
        List list = linedefinition.getViews();
        int l = list.size();
        if (l > 0)
        {
            float f = 0.0F;
            for (int i = 0; i < l; i++)
            {
                f += getWeight((LayoutParams)((View)list.get(i)).getLayoutParams());
            }

            LayoutParams layoutparams = (LayoutParams)((View)list.get(l - 1)).getLayoutParams();
            int i1 = linedefinition.getLineLength();
            int j1 = layoutparams.getLength();
            int k1 = layoutparams.getInlineStartLength();
            int k = 0;
            int j = 0;
            while (j < l) 
            {
                LayoutParams layoutparams1 = (LayoutParams)((View)list.get(j)).getLayoutParams();
                float f1 = getWeight(layoutparams1);
                int l1 = getGravity(layoutparams1);
                int i2 = Math.round(((float)(i1 - (j1 + k1)) * f1) / f);
                int j2 = layoutparams1.getLength() + layoutparams1.getSpacingLength();
                int k2 = layoutparams1.getThickness();
                int l2 = layoutparams1.getSpacingThickness();
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = k;
                rect.right = j2 + i2 + k;
                rect.bottom = linedefinition.getLineThickness();
                Rect rect1 = new Rect();
                Gravity.apply(l1, j2, k2 + l2, rect, rect1);
                k += i2;
                layoutparams1.setInlineStartLength(rect1.left + layoutparams1.getInlineStartLength());
                layoutparams1.setInlineStartThickness(rect1.top);
                layoutparams1.setLength(rect1.width() - layoutparams1.getSpacingLength());
                layoutparams1.setThickness(rect1.height() - layoutparams1.getSpacingThickness());
                j++;
            }
        }
    }

    private void applyGravityToLines(List list, int i, int j)
    {
        int i1 = list.size();
        if (i1 > 0)
        {
            LineDefinition linedefinition = (LineDefinition)list.get(i1 - 1);
            int j1 = linedefinition.getLineThickness();
            int k1 = linedefinition.getLineStartThickness();
            int l = 0;
            int k = 0;
            while (k < i1) 
            {
                LineDefinition linedefinition1 = (LineDefinition)list.get(k);
                int l1 = getGravity();
                int i2 = Math.round(((j - (j1 + k1)) * 1) / i1);
                int j2 = linedefinition1.getLineLength();
                int k2 = linedefinition1.getLineThickness();
                Rect rect = new Rect();
                rect.top = l;
                rect.left = 0;
                rect.right = i;
                rect.bottom = k2 + i2 + l;
                Rect rect1 = new Rect();
                Gravity.apply(l1, j2, k2, rect, rect1);
                l += i2;
                linedefinition1.addLineStartLength(rect1.left);
                linedefinition1.addLineStartThickness(rect1.top);
                linedefinition1.setLength(rect1.width());
                linedefinition1.setThickness(rect1.height());
                k++;
            }
        }
    }

    private void applyPositionsToViews(LineDefinition linedefinition)
    {
        List list = linedefinition.getViews();
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            View view = (View)list.get(i);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (config.getOrientation() == 0)
            {
                layoutparams.setPosition(getPaddingLeft() + linedefinition.getLineStartLength() + layoutparams.getInlineStartLength(), getPaddingTop() + linedefinition.getLineStartThickness() + layoutparams.getInlineStartThickness());
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.getLength(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.getThickness(), 0x40000000));
            } else
            {
                layoutparams.setPosition(getPaddingLeft() + linedefinition.getLineStartThickness() + layoutparams.getInlineStartThickness(), getPaddingTop() + linedefinition.getLineStartLength() + layoutparams.getInlineStartLength());
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.getThickness(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.getLength(), 0x40000000));
            }
            i++;
        }
    }

    private void calculateLinesAndChildPosition(List list)
    {
        int j = 0;
        int i1 = list.size();
        for (int i = 0; i < i1;)
        {
            Object obj = (LineDefinition)list.get(i);
            ((LineDefinition) (obj)).addLineStartThickness(j);
            int l = j + ((LineDefinition) (obj)).getLineThickness();
            int k = 0;
            obj = ((LineDefinition) (obj)).getViews();
            int j1 = ((List) (obj)).size();
            for (j = 0; j < j1; j++)
            {
                LayoutParams layoutparams = (LayoutParams)((View)((List) (obj)).get(j)).getLayoutParams();
                layoutparams.setInlineStartLength(k);
                k += layoutparams.getLength() + layoutparams.getSpacingLength();
            }

            i++;
            j = l;
        }

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
        if (config.isDebugDraw())
        {
            Paint paint = createPaint(-256);
            Paint paint1 = createPaint(0xffff0000);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams.rightMargin > 0)
            {
                float f = view.getRight();
                float f6 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                canvas.drawLine(f, f6, f + (float)layoutparams.rightMargin, f6, paint);
                canvas.drawLine(((float)layoutparams.rightMargin + f) - 4F, f6 - 4F, f + (float)layoutparams.rightMargin, f6, paint);
                canvas.drawLine(((float)layoutparams.rightMargin + f) - 4F, f6 + 4F, f + (float)layoutparams.rightMargin, f6, paint);
            }
            if (layoutparams.leftMargin > 0)
            {
                float f1 = view.getLeft();
                float f7 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                canvas.drawLine(f1, f7, f1 - (float)layoutparams.leftMargin, f7, paint);
                canvas.drawLine((f1 - (float)layoutparams.leftMargin) + 4F, f7 - 4F, f1 - (float)layoutparams.leftMargin, f7, paint);
                canvas.drawLine((f1 - (float)layoutparams.leftMargin) + 4F, f7 + 4F, f1 - (float)layoutparams.leftMargin, f7, paint);
            }
            if (layoutparams.bottomMargin > 0)
            {
                float f2 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                float f8 = view.getBottom();
                canvas.drawLine(f2, f8, f2, f8 + (float)layoutparams.bottomMargin, paint);
                canvas.drawLine(f2 - 4F, ((float)layoutparams.bottomMargin + f8) - 4F, f2, f8 + (float)layoutparams.bottomMargin, paint);
                canvas.drawLine(f2 + 4F, ((float)layoutparams.bottomMargin + f8) - 4F, f2, f8 + (float)layoutparams.bottomMargin, paint);
            }
            if (layoutparams.topMargin > 0)
            {
                float f3 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                float f9 = view.getTop();
                canvas.drawLine(f3, f9, f3, f9 - (float)layoutparams.topMargin, paint);
                canvas.drawLine(f3 - 4F, (f9 - (float)layoutparams.topMargin) + 4F, f3, f9 - (float)layoutparams.topMargin, paint);
                canvas.drawLine(f3 + 4F, (f9 - (float)layoutparams.topMargin) + 4F, f3, f9 - (float)layoutparams.topMargin, paint);
            }
            if (layoutparams.newLine)
            {
                if (config.getOrientation() == 0)
                {
                    float f4 = view.getLeft();
                    float f10 = (float)view.getTop() + (float)view.getHeight() / 2.0F;
                    canvas.drawLine(f4, f10 - 6F, f4, f10 + 6F, paint1);
                    return;
                } else
                {
                    float f5 = (float)view.getLeft() + (float)view.getWidth() / 2.0F;
                    float f11 = view.getTop();
                    canvas.drawLine(f5 - 6F, f11, f5 + 6F, f11, paint1);
                    return;
                }
            }
        }
    }

    private int findSize(int i, int j, int k)
    {
        switch (i)
        {
        default:
            return k;

        case 0: // '\0'
            return k;

        case -2147483648: 
            return Math.min(k, j);

        case 1073741824: 
            return j;
        }
    }

    private int getGravity(LayoutParams layoutparams)
    {
        if (layoutparams.gravitySpecified())
        {
            return layoutparams.gravity;
        } else
        {
            return config.getGravity();
        }
    }

    private float getWeight(LayoutParams layoutparams)
    {
        if (layoutparams.weightSpecified())
        {
            return layoutparams.weight;
        } else
        {
            return config.getWeightDefault();
        }
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

    public int getGravity()
    {
        return config.getGravity();
    }

    public int getLayoutDirection()
    {
        if (config == null)
        {
            return 0;
        } else
        {
            return config.getLayoutDirection();
        }
    }

    public int getOrientation()
    {
        return config.getOrientation();
    }

    public float getWeightDefault()
    {
        return config.getWeightDefault();
    }

    public boolean isDebugDraw()
    {
        return config.isDebugDraw();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = getChildCount();
        for (i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            view.layout(layoutparams.x + layoutparams.leftMargin, layoutparams.y + layoutparams.topMargin, layoutparams.x + layoutparams.leftMargin + view.getMeasuredWidth(), layoutparams.y + layoutparams.topMargin + view.getMeasuredHeight());
        }

    }

    protected void onMeasure(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getSize(i) - getPaddingRight() - getPaddingLeft();
        int i1 = android.view.View.MeasureSpec.getSize(j) - getPaddingTop() - getPaddingBottom();
        int j1 = android.view.View.MeasureSpec.getMode(i);
        int i2 = android.view.View.MeasureSpec.getMode(j);
        LineDefinition linedefinition;
        int k;
        int j2;
        if (config.getOrientation() == 0)
        {
            k = l;
        } else
        {
            k = i1;
        }
        if (config.getOrientation() == 0)
        {
            l = i1;
        }
        if (config.getOrientation() == 0)
        {
            i1 = j1;
        } else
        {
            i1 = i2;
        }
        if (config.getOrientation() != 0);
        lines.clear();
        linedefinition = new LineDefinition(k, config);
        lines.add(linedefinition);
        j2 = getChildCount();
        j1 = 0;
        while (j1 < j2) 
        {
            View view = getChildAt(j1);
            if (view.getVisibility() != 8)
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutparams.width), getChildMeasureSpec(j, getPaddingTop() + getPaddingBottom(), layoutparams.height));
                layoutparams.clearCalculatedFields(config.getOrientation());
                boolean flag;
                if (config.getOrientation() == 0)
                {
                    layoutparams.setLength(view.getMeasuredWidth());
                    layoutparams.setThickness(view.getMeasuredHeight());
                } else
                {
                    layoutparams.setLength(view.getMeasuredHeight());
                    layoutparams.setThickness(view.getMeasuredWidth());
                }
                if (layoutparams.newLine || i1 != 0 && !linedefinition.canFit(view))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    linedefinition = new LineDefinition(k, config);
                    if (config.getOrientation() == 1 && config.getLayoutDirection() == 1)
                    {
                        lines.add(0, linedefinition);
                    } else
                    {
                        lines.add(linedefinition);
                    }
                }
                if (config.getOrientation() == 0 && config.getLayoutDirection() == 1)
                {
                    linedefinition.addView(0, view);
                } else
                {
                    linedefinition.addView(view);
                }
            }
            j1++;
        }
        calculateLinesAndChildPosition(lines);
        j1 = 0;
        j2 = lines.size();
        for (int k1 = 0; k1 < j2; k1++)
        {
            j1 = Math.max(j1, ((LineDefinition)lines.get(k1)).getLineLength());
        }

        int l1 = linedefinition.getLineStartThickness() + linedefinition.getLineThickness();
        k = findSize(i1, k, j1);
        l = findSize(i2, l, l1);
        applyGravityToLines(lines, k, l);
        for (k = 0; k < j2; k++)
        {
            LineDefinition linedefinition1 = (LineDefinition)lines.get(k);
            applyGravityToLine(linedefinition1);
            applyPositionsToViews(linedefinition1);
        }

        l = getPaddingLeft() + getPaddingRight();
        k = getPaddingBottom() + getPaddingTop();
        if (config.getOrientation() == 0)
        {
            l += j1;
            k += l1;
        } else
        {
            l += l1;
            k += j1;
        }
        setMeasuredDimension(resolveSize(l, i), resolveSize(k, j));
    }

    public void setDebugDraw(boolean flag)
    {
        config.setDebugDraw(flag);
        invalidate();
    }

    public void setGravity(int i)
    {
        config.setGravity(i);
        requestLayout();
    }

    public void setLayoutDirection(int i)
    {
        config.setLayoutDirection(i);
        requestLayout();
    }

    public void setOrientation(int i)
    {
        config.setOrientation(i);
        requestLayout();
    }

    public void setWeightDefault(float f)
    {
        config.setWeightDefault(f);
        requestLayout();
    }
}
