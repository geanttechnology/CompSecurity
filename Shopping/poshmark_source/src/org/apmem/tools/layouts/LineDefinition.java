// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apmem.tools.layouts;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.apmem.tools.layouts:
//            LayoutConfiguration

class LineDefinition
{

    private final LayoutConfiguration config;
    private int lineLength;
    private int lineLengthWithSpacing;
    private int lineStartLength;
    private int lineStartThickness;
    private int lineThickness;
    private int lineThicknessWithSpacing;
    private final int maxLength;
    private final List views = new ArrayList();

    public LineDefinition(int i, LayoutConfiguration layoutconfiguration)
    {
        lineStartThickness = 0;
        lineStartLength = 0;
        maxLength = i;
        config = layoutconfiguration;
    }

    public void addLineStartLength(int i)
    {
        lineStartLength = lineStartLength + i;
    }

    public void addLineStartThickness(int i)
    {
        lineStartThickness = lineStartThickness + i;
    }

    public void addView(int i, View view)
    {
        FlowLayout.LayoutParams layoutparams = (FlowLayout.LayoutParams)view.getLayoutParams();
        views.add(i, view);
        lineLength = lineLengthWithSpacing + layoutparams.getLength();
        lineLengthWithSpacing = lineLength + layoutparams.getSpacingLength();
        lineThicknessWithSpacing = Math.max(lineThicknessWithSpacing, layoutparams.getThickness() + layoutparams.getSpacingThickness());
        lineThickness = Math.max(lineThickness, layoutparams.getThickness());
    }

    public void addView(View view)
    {
        addView(views.size(), view);
    }

    public boolean canFit(View view)
    {
        int i;
        if (config.getOrientation() == 0)
        {
            i = view.getMeasuredWidth();
        } else
        {
            i = view.getMeasuredHeight();
        }
        return lineLengthWithSpacing + i <= maxLength;
    }

    public int getLineLength()
    {
        return lineLength;
    }

    public int getLineStartLength()
    {
        return lineStartLength;
    }

    public int getLineStartThickness()
    {
        return lineStartThickness;
    }

    public int getLineThickness()
    {
        return lineThicknessWithSpacing;
    }

    public List getViews()
    {
        return views;
    }

    public void setLength(int i)
    {
        int j = lineLengthWithSpacing;
        int k = lineLength;
        lineLength = i;
        lineLengthWithSpacing = i + (j - k);
    }

    public void setThickness(int i)
    {
        int j = lineThicknessWithSpacing;
        int k = lineThickness;
        lineThicknessWithSpacing = i;
        lineThickness = i - (j - k);
    }
}
