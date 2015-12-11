// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.RadioGroup;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.activity:
//            GlobalSearch, GrouponFragmentActivity

public class ty extends ViewBinder
{

    public void bind(butterknife.ewBinder ewbinder, GlobalSearch globalsearch, Object obj)
    {
        super.bind(ewbinder, globalsearch, obj);
        globalsearch.radioTabGroup = (RadioGroup)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1002fc, "field 'radioTabGroup'"), 0x7f1002fc, "field 'radioTabGroup'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (GlobalSearch)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (GlobalSearch)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GlobalSearch)obj, obj1);
    }

    public void unbind(GlobalSearch globalsearch)
    {
        super.unbind(globalsearch);
        globalsearch.radioTabGroup = null;
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((GlobalSearch)grouponfragmentactivity);
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((GlobalSearch)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((GlobalSearch)obj);
    }

    public ty()
    {
    }
}
