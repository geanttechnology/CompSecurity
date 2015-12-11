// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.cart;

import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.base.BaseFragmentContainer;

// Referenced classes of package com.bestbuy.android.activities.cart:
//            MyCartFragment

class c
    implements Runnable
{

    final HomeTabFragment a;
    final PLPFragmentContainer b;
    final PLPFragment c;
    final MyCartFragment d;

    public void run()
    {
        ((BaseTabContainer)a.e()).a(b, true);
        b.a(c, true);
    }

    ragment(MyCartFragment mycartfragment, HomeTabFragment hometabfragment, PLPFragmentContainer plpfragmentcontainer, PLPFragment plpfragment)
    {
        d = mycartfragment;
        a = hometabfragment;
        b = plpfragmentcontainer;
        c = plpfragment;
        super();
    }
}
