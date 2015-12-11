// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.offerup.android.dto.Sort;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            as, ar, aq

public final class ap extends BaseAdapter
{

    private final List a;
    private RadioButton b;
    private TextView c;
    private int d;
    private int e;
    private Context f;

    public ap(Context context, List list)
    {
        d = -1;
        e = -1;
        a = list;
        f = context;
        for (int i = 0; i < a.size() && (d == -1 || e == -1); i++)
        {
            if (((Sort)a.get(i)).isSelected() && d == -1)
            {
                d = i;
            }
            if (((Sort)a.get(i)).isDefaultValue() && e == -1)
            {
                e = i;
            }
        }

    }

    static RadioButton a(ap ap1)
    {
        return ap1.b;
    }

    static RadioButton a(ap ap1, RadioButton radiobutton)
    {
        ap1.b = radiobutton;
        return radiobutton;
    }

    static TextView a(ap ap1, TextView textview)
    {
        ap1.c = textview;
        return textview;
    }

    static void a(ap ap1, int i)
    {
        if (ap1.d >= 0 && ap1.d < ap1.a.size())
        {
            ((Sort)ap1.a.get(ap1.d)).setSelected(false);
        }
        if (i >= 0 && i < ap1.a.size())
        {
            ((Sort)ap1.a.get(i)).setSelected(true);
        }
        ap1.d = i;
    }

    static Context b(ap ap1)
    {
        return ap1.f;
    }

    static TextView c(ap ap1)
    {
        return ap1.c;
    }

    static int d(ap ap1)
    {
        return ap1.d;
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        ar ar1;
        if (view == null)
        {
            view = ((LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater")).inflate(0x7f0400c4, viewgroup, false);
            viewgroup = new as(this, (byte)0);
            viewgroup.a = (TextView)view.findViewById(0x7f1002b2);
            viewgroup.b = (RadioButton)view.findViewById(0x7f1002b1);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (as)view.getTag();
        }
        ar1 = new ar(this, viewgroup, i);
        ((as) (viewgroup)).b.setOnClickListener(ar1);
        if (((Sort)a.get(i)).isSelected())
        {
            ((as) (viewgroup)).b.setChecked(true);
            ((as) (viewgroup)).a.setTextColor(f.getResources().getColor(0x7f0e0114));
            ((as) (viewgroup)).a.setTypeface(Typeface.DEFAULT_BOLD);
            b = ((as) (viewgroup)).b;
            c = ((as) (viewgroup)).a;
            d = i;
        } else
        {
            ((as) (viewgroup)).b.setChecked(false);
            ((as) (viewgroup)).a.setTextColor(f.getResources().getColor(0x7f0e00e9));
            ((as) (viewgroup)).a.setTypeface(Typeface.DEFAULT);
        }
        ((Sort)a.get(i)).isDefaultValue();
        view.setOnClickListener(new aq(this, i));
        ((as) (viewgroup)).a.setText(((Sort)a.get(i)).getLongLabel());
        return view;
    }
}
