// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import aco;
import afv;
import afw;
import afz;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import b;
import blu;
import bmo;
import bov;
import bsz;
import bta;
import bum;
import bxe;
import duu;
import java.util.Iterator;
import java.util.List;
import vp;

// Referenced classes of package com.google.android.apps.youtube.kids.ui:
//            ScrollAwareHorizontalListView

public class ScrollingSectionListGridView extends FrameLayout
{

    int a;
    final int b;
    final int c;
    public afz d;
    public ScrollAwareHorizontalListView e;
    private int f;
    private int g;
    private final int h;
    private final int i;

    public ScrollingSectionListGridView(Context context, AttributeSet attributeset)
    {
        int j;
        int k;
        int l;
        super(context, attributeset);
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, vp.c, 0, 0);
        context = context.getResources();
        j = context.getDimensionPixelSize(0x7f0a0113);
        k = context.getDimensionPixelSize(0x7f0a00fd);
        l = context.getDimensionPixelSize(0x7f0a00fe);
        c = context.getDimensionPixelSize(0x7f0a010d);
        a = attributeset.getDimensionPixelSize(2, 0);
        g = attributeset.getDimensionPixelSize(1, 0);
        i = attributeset.getDimensionPixelSize(0, j);
        h = attributeset.getDimensionPixelSize(3, k);
        b = attributeset.getDimensionPixelSize(4, l);
        attributeset.recycle();
        setSaveEnabled(false);
        e = new ScrollAwareHorizontalListView(getContext());
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    public final void a()
    {
        afz afz1 = d;
        afz1.a.clear();
        afz1.d = null;
        afz1.notifyDataSetInvalidated();
    }

    public final void a(int j)
    {
        int k = c;
        int l = a;
        int i1 = b;
        e.a(k + (l + i1 * 2) * j);
    }

    public final void a(afw afw)
    {
        e.a = afw;
    }

    public final void a(blu blu, aco aco, afv afv, int j, bov bov, bxe bxe)
    {
        boolean flag;
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        f = j;
        if (g * a == 0)
        {
            Context context = getContext();
            Point point = new Point();
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getSize(point);
            int l = getResources().getIdentifier("status_bar_height", "dimen", "android");
            int k = 0;
            if (l > 0)
            {
                k = getResources().getDimensionPixelSize(l);
            }
            l = point.y;
            int i1 = getResources().getDimensionPixelSize(0x7f0a00fa);
            int j1 = getResources().getDimensionPixelSize(0x7f0a010e);
            float f1 = (float)(f - 1) * 2.0F + 1.5F;
            g = (int)(((float)(l - i1 - j1 - k) - (float)h * f1) / (float)f);
            k = f;
            l = g;
            (new StringBuilder(54)).append("  R:").append(k).append("   VPC:").append(f1).append("   TH:").append(l);
            a = (int)(1.7777777777777777D * (double)(g - i));
        }
        d = new afz(getContext(), blu, aco, afv, a, g, b, h, c, j, e, bov, bxe);
        e.a(d);
        addView(e, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public final void a(bum bum1)
    {
        int j;
        if (bum1 == null || bum1.b == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        bum1 = bum1.b.a.iterator();
        j = 0;
_L5:
        if (!bum1.hasNext()) goto _L2; else goto _L1
_L1:
        bta bta1 = (bta)bum1.next();
        if (bta1 == null || !bta1.a.e) goto _L4; else goto _L3
_L3:
        if (j >= 0)
        {
            bum1 = d;
            View view = bum1.a(((afz) (bum1)).c, ((afz) (bum1)).b);
            if (view != null)
            {
                view.setBackgroundResource(0);
            }
            view = bum1.a(((afz) (bum1)).c, j);
            if (view != null)
            {
                view.setBackgroundResource(0x7f020048);
            }
            bum1.b = j;
            a(j);
        }
        return;
_L4:
        j++;
          goto _L5
_L2:
        bmo.c("No video marked as selected in the WatchNextResponse.");
        j = -1;
          goto _L3
    }
}
