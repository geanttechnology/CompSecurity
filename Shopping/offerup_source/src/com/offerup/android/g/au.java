// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import com.offerup.android.a.at;
import com.offerup.android.dto.Sort;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            c, av, aw

public final class au extends c
{

    private TextView e;
    private Spinner f;

    public au()
    {
    }

    static TextView a(au au1)
    {
        return au1.e;
    }

    static Spinner b(au au1)
    {
        return au1.f;
    }

    public final void a()
    {
        if (e != null && c != null)
        {
            e.setText(d.getLongLabel());
            d.setSelected(true);
            c.setSelected(false);
            c = d;
            f.setSelection(b.indexOf(d));
        }
    }

    protected final void a(View view)
    {
        f = (Spinner)view.findViewById(0x7f100282);
        e = (TextView)view.findViewById(0x7f100283);
        f.setAdapter(new at(a, 0x1090008, b));
        if (c != null)
        {
            f.setSelection(b.indexOf(c), false);
        }
        f.setOnItemSelectedListener(new av(this));
        if (c != null)
        {
            e.setText(c.getLongLabel());
        }
        e.setOnClickListener(new aw(this));
    }
}
