// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity

public class der extends com.groupon.util.wBinder
{

    public void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        super.bind(ewbinder, grouponfragmentactivity, obj);
        grouponfragmentactivity.toolbar = (Toolbar)ewbinder.lbar((View)ewbinder.lbar(obj, 0x7f100180, null), 0x7f100180, "field 'toolbar'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (GrouponFragmentActivity)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponFragmentActivity)obj, obj1);
    }

    public void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        super.unbind(grouponfragmentactivity);
        grouponfragmentactivity.toolbar = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((GrouponFragmentActivity)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponFragmentActivity)obj);
    }

    public der()
    {
    }
}
