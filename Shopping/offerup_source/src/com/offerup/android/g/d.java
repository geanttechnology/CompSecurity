// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.offerup.android.dto.Filter;

// Referenced classes of package com.offerup.android.g:
//            a, e

public final class d extends a
{

    private View a;
    private CheckedTextView b;
    private Filter c;

    public d()
    {
    }

    static CheckedTextView a(d d1)
    {
        return d1.b;
    }

    public final void a()
    {
        b.setChecked(c.isDefaultValue());
        c.setSelected(c.isDefaultValue());
        if (c.isSelected())
        {
            b.setTextColor(getResources().getColor(0x7f0e0114));
            return;
        } else
        {
            b.setTextColor(getResources().getColor(0x7f0e00e9));
            return;
        }
    }

    public final void a(Filter filter)
    {
        c = filter;
        b.setText(filter.getLabel());
        b.setChecked(filter.isSelected());
        if (filter.isSelected())
        {
            b.setTextColor(getResources().getColor(0x7f0e0114));
        }
        b.setOnClickListener(new e(this, filter));
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f040082, viewgroup, false);
        b = (CheckedTextView)a.findViewById(0x7f1001e0);
        return a;
    }
}
