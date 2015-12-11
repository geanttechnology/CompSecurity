// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.view.View;
import mw;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoresOutletFragment

class a
    implements android.view.s.StoresOutletFragment._cls1
{

    final mw a;
    final StoresOutletFragment b;

    public void onClick(View view)
    {
        view = a.e();
        StoresOutletFragment.a(b, view, a.i(), a.f());
    }

    (StoresOutletFragment storesoutletfragment, mw mw1)
    {
        b = storesoutletfragment;
        a = mw1;
        super();
    }
}
