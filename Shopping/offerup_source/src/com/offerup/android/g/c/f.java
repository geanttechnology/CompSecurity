// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.widget.ArrayAdapter;
import com.offerup.android.activities.k;
import com.offerup.android.dto.Category;
import com.offerup.android.h.c;
import java.util.Arrays;

// Referenced classes of package com.offerup.android.g.c:
//            c

final class f
    implements c
{

    private com.offerup.android.g.c.c a;

    f(com.offerup.android.g.c.c c1)
    {
        a = c1;
        super();
    }

    public final void a()
    {
        ((k)a.getActivity()).i();
    }

    public final void a(Category acategory[])
    {
        c.a(a).clear();
        c.a(a).addAll(Arrays.asList(acategory));
        c.a(a).notifyDataSetChanged();
        c.e(a);
        ((k)a.getActivity()).i();
    }
}
