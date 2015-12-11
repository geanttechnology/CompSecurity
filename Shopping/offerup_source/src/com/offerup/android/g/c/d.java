// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.offerup.android.dto.Category;

// Referenced classes of package com.offerup.android.g.c:
//            c

final class d
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private c a;

    d(c c1)
    {
        a = c1;
        super();
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        c.a(a, (Category)c.a(a).getItem(i));
        if (c.b(a) != null)
        {
            if (c.c(a).getError() != null)
            {
                c.c(a).setError(null);
            }
            c.c(a).setText(c.b(a).getName());
            return;
        } else
        {
            c.c(a).setText(0x7f0900eb);
            return;
        }
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
        c.c(a).setText(a.getString(0x7f0900eb));
    }
}
