// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import com.offerup.android.activities.k;
import com.offerup.android.h.b;
import com.offerup.android.utils.i;
import java.util.List;

// Referenced classes of package com.offerup.android.g.c:
//            l

final class m
    implements i
{

    private l a;

    m(l l1)
    {
        a = l1;
        super();
    }

    public final void a(List list)
    {
        ((k)a.getActivity()).i();
        if (list.size() > 0)
        {
            a.a(list);
            return;
        } else
        {
            a.a.a();
            return;
        }
    }
}
