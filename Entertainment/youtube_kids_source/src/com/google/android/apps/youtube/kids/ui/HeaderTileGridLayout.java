// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import aen;
import afj;
import afw;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;
import vp;

// Referenced classes of package com.google.android.apps.youtube.kids.ui:
//            ScrollingSectionListGridView, ScrollAwareHorizontalListView

public class HeaderTileGridLayout extends LinearLayout
    implements afw
{

    public final ScrollingSectionListGridView a;
    public final LinearLayout b;
    public final List c;
    public final List d;
    public final List e;
    public TextView f;
    public View g;
    public int h;
    public int i;
    public Animation j;
    public aen k;
    private final int l;

    public HeaderTileGridLayout(Context context, AttributeSet attributeset)
    {
        Object obj;
        int i1;
        super(context, attributeset);
        h = -1;
        i = -1;
        j = null;
        c = new LinkedList();
        d = new LinkedList();
        e = new LinkedList();
        obj = context.getTheme().obtainStyledAttributes(attributeset, vp.a, 0, 0);
        i1 = context.getResources().getDimensionPixelSize(0x7f0a00fa);
        l = ((TypedArray) (obj)).getDimensionPixelSize(0, i1);
        ((TypedArray) (obj)).recycle();
        setSaveEnabled(false);
        setOrientation(1);
        b = new LinearLayout(context);
        obj = new android.widget.LinearLayout.LayoutParams(-1, l);
        b.setOrientation(0);
        b.setVisibility(8);
        b.setGravity(17);
        addView(b, ((android.view.ViewGroup.LayoutParams) (obj)));
        context = new ScrollingSectionListGridView(context, attributeset);
        attributeset = new android.widget.LinearLayout.LayoutParams(-1, -1);
        attributeset.weight = 1.0F;
        context.setLayoutParams(attributeset);
        context.a(this);
        a = context;
        addView(a);
        return;
        context;
        ((TypedArray) (obj)).recycle();
        throw context;
    }

    public static int a(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.i;
    }

    public static int a(HeaderTileGridLayout headertilegridlayout, int i1)
    {
        headertilegridlayout.i = i1;
        return i1;
    }

    public static int a(HeaderTileGridLayout headertilegridlayout, View view)
    {
        for (int i1 = 0; i1 < headertilegridlayout.c.size(); i1++)
        {
            if (((Pair)headertilegridlayout.c.get(i1)).second == view)
            {
                return i1;
            }
        }

        Log.e("Header", "No Selected Tab in Header Tabs.  This should not happen.");
        return -1;
    }

    public static Animation a(HeaderTileGridLayout headertilegridlayout, Animation animation)
    {
        headertilegridlayout.j = animation;
        return animation;
    }

    public static void a(HeaderTileGridLayout headertilegridlayout, int i1, boolean flag)
    {
        headertilegridlayout.b(i1, flag);
    }

    public static void a(HeaderTileGridLayout headertilegridlayout, View view, boolean flag)
    {
        view.setSelected(true);
    }

    public static int b(HeaderTileGridLayout headertilegridlayout, int i1)
    {
        headertilegridlayout.h = i1;
        return i1;
    }

    public static List b(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.e;
    }

    private void b(int i1, boolean flag)
    {
        if (c.size() == 0)
        {
            return;
        } else
        {
            ((View)((Pair)c.get(i1)).second).setSelected(flag);
            return;
        }
    }

    public static TextView c(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.f;
    }

    public static List d(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.c;
    }

    public static View e(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.g;
    }

    public static Animation f(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.j;
    }

    public static int g(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.h;
    }

    public static ScrollingSectionListGridView h(HeaderTileGridLayout headertilegridlayout)
    {
        return headertilegridlayout.a;
    }

    public final void a()
    {
        int i1;
        ScrollingSectionListGridView scrollingsectionlistgridview = a;
        i1 = scrollingsectionlistgridview.e.f.getCurrX();
        int j1;
        if (i1 < scrollingsectionlistgridview.c || scrollingsectionlistgridview.a == 0)
        {
            j1 = 0;
        } else
        {
            j1 = scrollingsectionlistgridview.c;
            int k1 = scrollingsectionlistgridview.a;
            j1 = (i1 - j1) / (scrollingsectionlistgridview.b * 2 + k1);
        }
        i1 = c.size() - 1;
_L3:
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (((Integer)((Pair)c.get(i1)).first).intValue() > j1) goto _L2; else goto _L1
_L1:
        if (i1 >= 0)
        {
            a(i1, false);
        }
        return;
_L2:
        i1--;
          goto _L3
        i1 = 0;
          goto _L1
    }

    public final void a(int i1)
    {
        if (d.size() == 0)
        {
            return;
        }
        Drawable drawable = (Drawable)((Pair)d.get(i1)).second;
        if (drawable != null)
        {
            k.b = drawable;
            return;
        } else
        {
            k.b = null;
            return;
        }
    }

    public final void a(int i1, boolean flag)
    {
        if (c.size() != 0 && i1 != h)
        {
            if (h >= 0)
            {
                b(h, false);
            }
            if (i1 >= 0 && i1 < c.size())
            {
                if (c.size() != 0 && i1 != h)
                {
                    h = i1;
                    post(new afj(this, i1, flag));
                    return;
                }
            } else
            {
                k.b = null;
                return;
            }
        }
    }
}
