// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.view.View;
import com.bestbuy.android.api.lib.models.offers.Offer;
import java.util.List;
import ke;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYLEPromoPager

class b
    implements android.view.er
{

    final List a;
    final int b;
    final BBYLEPromoPager c;

    public void onClick(View view)
    {
        BBYLEPromoPager.d(c).a((Offer)a.get(b));
    }

    (BBYLEPromoPager bbylepromopager, List list, int i)
    {
        c = bbylepromopager;
        a = list;
        b = i;
        super();
    }
}
