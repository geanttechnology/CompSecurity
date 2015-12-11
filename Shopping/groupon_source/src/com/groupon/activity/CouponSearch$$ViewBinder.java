// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.activity:
//            CouponSearch, GrouponFragmentActivity

public class ty extends ViewBinder
{

    public void bind(butterknife.ewBinder ewbinder, CouponSearch couponsearch, Object obj)
    {
        super.bind(ewbinder, couponsearch, obj);
        couponsearch.resultContainer = (LinearLayout)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1001db, "field 'resultContainer'"), 0x7f1001db, "field 'resultContainer'");
        couponsearch.suggestionContainer = (LinearLayout)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1001da, "field 'suggestionContainer'"), 0x7f1001da, "field 'suggestionContainer'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (CouponSearch)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (CouponSearch)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (CouponSearch)obj, obj1);
    }

    public void unbind(CouponSearch couponsearch)
    {
        super.unbind(couponsearch);
        couponsearch.resultContainer = null;
        couponsearch.suggestionContainer = null;
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((CouponSearch)grouponfragmentactivity);
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((CouponSearch)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((CouponSearch)obj);
    }

    public ty()
    {
    }
}
