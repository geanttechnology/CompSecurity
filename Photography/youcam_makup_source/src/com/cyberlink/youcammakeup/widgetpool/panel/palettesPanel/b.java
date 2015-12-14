// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cyberlink.youcammakeup.widgetpool.common.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            c

public class b extends o
{

    private c c;

    public b(Context context, c c1)
    {
        super(context, c1);
        c = c1;
    }

    public int a(int i, int j)
    {
        if (i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.b) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.e))
        {
            return 3;
        }
        if (i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.c) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.f))
        {
            return 2;
        }
        return i != PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.g) && i != PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.h) ? 0 : 1;
    }

    public View a(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        LinearLayout linearlayout;
        int k;
        int l;
        int i1;
        int j1;
        if (view == null)
        {
            view = new LinearLayout(viewgroup.getContext());
        }
        linearlayout = (LinearLayout)(LinearLayout)view;
        i1 = c.a(i);
        if (linearlayout.getLayoutParams() == null)
        {
            linearlayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2, -1));
            linearlayout.setPadding(0, 0, c(i, viewgroup.getWidth()), 0);
        }
        j1 = c.getChildrenCount(i);
        l = i1 * j;
        k = 0;
        while (l < (j + 1) * i1) 
        {
            if (k < linearlayout.getChildCount())
            {
                view = linearlayout.getChildAt(k);
            } else
            {
                view = null;
            }
            if (l < j1)
            {
                View view1 = view;
                if (view != null)
                {
                    view1 = view;
                    if (view.getTag() == null)
                    {
                        ((ViewGroup)view.getParent()).removeView(view);
                        view1 = null;
                    }
                }
                view = c;
                if (l == j1 - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view = view.getChildView(i, l, flag, view1, viewgroup);
                view.setTag(c.b(i, l));
            } else
            {
                if (view != null && view.getTag() != null)
                {
                    ((ViewGroup)view.getParent()).removeView(view);
                }
                view = new View(viewgroup.getContext());
                view.setTag(null);
            }
            if (!(view.getLayoutParams() instanceof android.widget.LinearLayout.LayoutParams))
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                if (layoutparams == null)
                {
                    layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F);
                } else
                {
                    layoutparams = new android.widget.LinearLayout.LayoutParams(-1, layoutparams.height, 1.0F);
                }
                layoutparams.rightMargin = d(i, viewgroup.getWidth());
                view.setLayoutParams(layoutparams);
            }
            if (linearlayout.getChildCount() < i1)
            {
                linearlayout.addView(view, k);
            } else
            {
                view.invalidate();
            }
            l++;
            k++;
        }
        return linearlayout;
    }

    public int c()
    {
        return 4;
    }

    public int c(int i, int j)
    {
        if (i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.c) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.f) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.g) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.h))
        {
            return Math.round((float)j * 0.095F);
        } else
        {
            return 0;
        }
    }

    public int d(int i, int j)
    {
        if (i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.b) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.e))
        {
            return Math.round((float)j * 0.1F);
        }
        if (i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.c) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.f) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.g) || i == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.h))
        {
            return Math.round((float)j * 0.004F);
        } else
        {
            return 0;
        }
    }
}
