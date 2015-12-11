// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.a.t;
import com.offerup.android.dto.Filter;
import com.offerup.android.dto.FilterOption;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            a, ay, az

public class ax extends a
{

    private Context a;
    private TextView b;
    private Spinner c;
    private TextView d;
    private View e;
    private FilterOption f;
    private FilterOption g;
    private Filter h;

    public ax()
    {
    }

    static Filter a(ax ax1)
    {
        return ax1.h;
    }

    static FilterOption a(ax ax1, FilterOption filteroption)
    {
        ax1.f = filteroption;
        return filteroption;
    }

    static TextView b(ax ax1)
    {
        return ax1.d;
    }

    static FilterOption c(ax ax1)
    {
        return ax1.f;
    }

    static Spinner d(ax ax1)
    {
        return ax1.c;
    }

    public final void a()
    {
        if (d != null && f != null)
        {
            d.setText(g.getLongLabel());
            g.setSelected(true);
            f.setSelected(false);
            f = g;
            c.setSelection(h.getOptions().indexOf(g));
        }
    }

    public final void a(Filter filter)
    {
        f = null;
        g = null;
        h = filter;
        filter = h.getOptions().iterator();
_L4:
        if (!filter.hasNext()) goto _L2; else goto _L1
_L1:
        FilterOption filteroption = (FilterOption)filter.next();
        if (filteroption.isSelected() && f == null)
        {
            f = filteroption;
        }
        if (filteroption.isDefaultValue() && g == null)
        {
            g = filteroption;
        }
        if (true) goto _L4; else goto _L3
_L3:
        filter;
        com.b.a.a.g.a(com/offerup/android/g/ax.getSimpleName(), filter);
_L6:
        return;
_L2:
        if (f == null || g == null) goto _L6; else goto _L5
_L5:
        b.setText(h.getLabel());
        c.setAdapter(new t(a, 0x1090008, h.getOptions()));
        c.setSelection(h.getOptions().indexOf(f), false);
        c.setOnItemSelectedListener(new ay(this));
        d.setText(f.getLongLabel());
        d.setOnClickListener(new az(this));
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = layoutinflater.inflate(0x7f040086, viewgroup, false);
        a = getActivity().getApplicationContext();
        b = (TextView)e.findViewById(0x7f1001df);
        c = (Spinner)e.findViewById(0x7f1001f5);
        d = (TextView)e.findViewById(0x7f1001f6);
        f = new FilterOption();
        return e;
    }
}
