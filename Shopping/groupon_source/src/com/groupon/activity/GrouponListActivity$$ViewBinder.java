// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        grouponlistactivity.toolbar = (Toolbar)ewbinder.lbar((View)ewbinder.iew(obj, 0x7f100180, null), 0x7f100180, "field 'toolbar'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponListActivity)obj, obj1);
    }

    public void unbind(GrouponListActivity grouponlistactivity)
    {
        grouponlistactivity.toolbar = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponListActivity)obj);
    }

    public ()
    {
    }
}
