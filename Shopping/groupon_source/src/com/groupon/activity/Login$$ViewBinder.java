// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            Login, GrouponFragmentActivity

public class rActivity extends ivity..ViewBinder
{

    public volatile void bind(butterknife. , GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(, (Login)grouponfragmentactivity, obj);
    }

    public void bind(butterknife. , Login login, Object obj)
    {
        super.bind(, login, obj);
        login.pager = (GrouponViewPager).castView((View).findRequiredView(obj, 0x7f1000ad, "field 'pager'"), 0x7f1000ad, "field 'pager'");
        login.indicator = (PagerSlidingTabStrip).castView((View).findRequiredView(obj, 0x7f1000ac, "field 'indicator'"), 0x7f1000ac, "field 'indicator'");
        login.dealCardCompact = (DealCardCompact).castView((View).findOptionalView(obj, 0x7f1000ae, null), 0x7f1000ae, "field 'dealCardCompact'");
        login.rootView = (View).findOptionalView(obj, 0x7f1000ab, null);
    }

    public volatile void bind(butterknife. , GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(, (Login)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife. , Object obj, Object obj1)
    {
        bind(, (Login)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((Login)grouponfragmentactivity);
    }

    public void unbind(Login login)
    {
        super.unbind(login);
        login.pager = null;
        login.indicator = null;
        login.dealCardCompact = null;
        login.rootView = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((Login)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((Login)obj);
    }

    public rActivity()
    {
    }
}
