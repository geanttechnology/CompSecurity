// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.AdapterView;
import com.target.mothership.model.coupons.interfaces.CouponOffer;
import com.target.ui.f.c;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponListFragment, CouponDetailFragment

private class <init>
    implements android.widget.ckListener
{

    final CouponListFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CouponOffer)adapterview.getItemAtPosition(i);
        m().d(CouponDetailFragment.a(adapterview.a()));
    }

    private Offer()
    {
        this$0 = CouponListFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
