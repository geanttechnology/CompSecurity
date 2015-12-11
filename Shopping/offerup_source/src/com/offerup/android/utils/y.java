// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import com.offerup.android.a.ad;
import com.offerup.android.activities.k;
import com.offerup.android.e.e;

// Referenced classes of package com.offerup.android.utils:
//            x

final class y
{

    private k a;
    private x b;

    y(x x1, k k1)
    {
        b = x1;
        a = k1;
        super();
    }

    public final void updateAlertCount(e e1)
    {
        if (e1.a() > 0 && x.a(b) != null && x.b(b))
        {
            a.supportInvalidateOptionsMenu();
            x.a(b).notifyDataSetChanged();
        }
    }
}
