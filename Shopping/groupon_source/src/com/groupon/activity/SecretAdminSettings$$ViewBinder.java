// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            SecretAdminSettings, GrouponFragmentActivity

public class der extends der
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (SecretAdminSettings)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, SecretAdminSettings secretadminsettings, Object obj)
    {
        super.bind(ewbinder, secretadminsettings, obj);
        secretadminsettings.pager = (GrouponViewPager)ewbinder.er((View)ewbinder.iew(obj, 0x7f1000ad, "field 'pager'"), 0x7f1000ad, "field 'pager'");
        secretadminsettings.indicator = (PagerSlidingTabStrip)ewbinder.icator((View)ewbinder.iew(obj, 0x7f1000ac, "field 'indicator'"), 0x7f1000ac, "field 'indicator'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (SecretAdminSettings)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (SecretAdminSettings)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((SecretAdminSettings)grouponfragmentactivity);
    }

    public void unbind(SecretAdminSettings secretadminsettings)
    {
        super.unbind(secretadminsettings);
        secretadminsettings.pager = null;
        secretadminsettings.indicator = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((SecretAdminSettings)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((SecretAdminSettings)obj);
    }

    public der()
    {
    }
}
