// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.offerup.android.dto.Filter;
import com.offerup.android.dto.FilterOption;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            a, z, y

public final class x extends a
{

    private View a;
    private Context b;
    private FilterOption c;
    private FilterOption d;
    private List e;
    private RelativeLayout f;
    private SeekBar g;
    private TextView h;
    private TextView i;
    private int j;
    private int k;
    private int l;
    private int m;

    public x()
    {
        j = 0;
        k = 1;
    }

    static int a(x x1, int i1)
    {
        x1.m = i1;
        return i1;
    }

    static SeekBar a(x x1)
    {
        return x1.g;
    }

    static FilterOption a(x x1, FilterOption filteroption)
    {
        x1.c = filteroption;
        return filteroption;
    }

    static int b(x x1, int i1)
    {
        x1.l = i1;
        return i1;
    }

    static void b(x x1)
    {
        if (x1.f.getChildCount() > 0)
        {
            int i1 = x1.getResources().getDrawable(0x7f0201e0).getIntrinsicWidth();
            int j1 = i1 / 2;
            int k1 = (x1.g.getMeasuredWidth() - i1) / (x1.j - 1);
            TextView textview = (TextView)x1.f.getChildAt(0);
            textview.setPadding(j1 - textview.getMeasuredWidth() / 2, 0, 0, 0);
            for (i1 = 1; i1 < x1.f.getChildCount() - 1; i1++)
            {
                TextView textview1 = (TextView)x1.f.getChildAt(i1);
                textview1.setPadding(Math.round(k1 - textview1.getWidth()), 0, 0, 0);
            }

            i1 = x1.f.getChildCount();
            ((TextView)x1.f.getChildAt(i1 - 1)).setPadding(Math.round(k1 - j1), 0, 0, 0);
        }
    }

    static List c(x x1)
    {
        return x1.e;
    }

    static TextView d(x x1)
    {
        return x1.h;
    }

    static FilterOption e(x x1)
    {
        return x1.c;
    }

    public final void a()
    {
        if (e != null && e.size() != 0)
        {
            int i1 = e.indexOf(d);
            int j1 = 1000 / (e.size() - 1);
            g.setProgress(i1 * j1);
            c.setSelected(false);
            c = d;
            c.setSelected(true);
        }
    }

    public final void a(Filter filter)
    {
        int i1 = 0;
        e = filter.getOptions();
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FilterOption filteroption = (FilterOption)iterator.next();
            if (filteroption.isSelected() && c == null)
            {
                c = filteroption;
            }
            if (filteroption.isDefaultValue() && d == null)
            {
                d = filteroption;
            }
        } while (true);
        if (c == null && e.size() > 0)
        {
            c = (FilterOption)e.get(0);
        }
        if (d == null && e.size() > 0)
        {
            d = (FilterOption)e.get(0);
        }
        i.setText(filter.getLabel());
        g.setMax(1000);
        filter = new z(this, (byte)0);
        g.setOnSeekBarChangeListener(filter);
        int j1 = e.indexOf(c);
        int l1 = 1000 / (e.size() - 1);
        g.setProgress(j1 * l1);
        g.refreshDrawableState();
        h.setText(c.getLongLabel());
        filter = e;
        j = filter.size();
        if (f.getChildCount() == 0)
        {
            TextView textview;
            for (filter = filter.iterator(); filter.hasNext(); f.addView(textview))
            {
                Object obj = ((FilterOption)filter.next()).getShortLabel();
                textview = (TextView)LayoutInflater.from(b).inflate(0x7f0400c8, null).findViewById(0x7f1002ba);
                int k1 = k;
                k = k1 + 1;
                textview.setId(k1);
                textview.setText(((CharSequence) (obj)));
                obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                if (i1 > 0)
                {
                    ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, i1);
                }
                textview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                i1 = textview.getId();
            }

        }
        f.measure(l, m);
        f.layout(f.getLeft(), f.getTop(), f.getRight(), f.getBottom());
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f040085, viewgroup, false);
        b = getActivity().getApplicationContext();
        f = (RelativeLayout)a.findViewById(0x7f1001f1);
        g = (SeekBar)a.findViewById(0x7f1001f4);
        h = (TextView)a.findViewById(0x7f1001f0);
        i = (TextView)a.findViewById(0x7f10012b);
        g.getViewTreeObserver().addOnPreDrawListener(new y(this));
        return a;
    }
}
