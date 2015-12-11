// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.a.ap;
import com.offerup.android.dto.Sort;
import com.offerup.android.views.NonScrollListView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            c

public final class at extends c
{

    private NonScrollListView e;
    private ap f;

    public at()
    {
    }

    public final void a()
    {
        if (f != null)
        {
            for (Iterator iterator = b.iterator(); iterator.hasNext();)
            {
                Sort sort = (Sort)iterator.next();
                if (sort.isDefaultValue())
                {
                    sort.setSelected(true);
                    c = sort;
                    d = sort;
                } else
                {
                    sort.setSelected(false);
                }
            }

            f.notifyDataSetChanged();
        }
    }

    protected final void a(View view)
    {
        e = (NonScrollListView)view.findViewById(0x7f100284);
        f = new ap(a, b);
        e.setAdapter(f);
    }
}
