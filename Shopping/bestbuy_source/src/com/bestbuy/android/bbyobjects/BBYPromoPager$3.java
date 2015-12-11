// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.view.View;
import com.bestbuy.android.api.lib.models.offers.Offer;
import java.util.List;
import kh;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYPromoPager

class b
    implements android.view.ener
{

    final List a;
    final int b;
    final BBYPromoPager c;

    public void onClick(View view)
    {
        BBYPromoPager.d(c).a((Offer)a.get(b), b);
    }

    (BBYPromoPager bbypromopager, List list, int i)
    {
        c = bbypromopager;
        a = list;
        b = i;
        super();
    }
}
