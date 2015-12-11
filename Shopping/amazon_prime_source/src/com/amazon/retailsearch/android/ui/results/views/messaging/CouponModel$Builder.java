// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            CouponModel

public static class 
{

    private List badgeText;
    private List label;

    public CouponModel build()
    {
        CouponModel couponmodel = new CouponModel();
        CouponModel.access$000(couponmodel, badgeText);
        CouponModel.access$100(couponmodel, label);
        return couponmodel;
    }

    public label setBadgeText(List list)
    {
        badgeText = list;
        return this;
    }

    public badgeText setLabel(List list)
    {
        label = list;
        return this;
    }

    public ()
    {
    }
}
