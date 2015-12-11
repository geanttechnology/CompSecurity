// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions, GrouponListActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, EmailSubscriptions emailsubscriptions, Object obj)
    {
        super.bind(ewbinder, emailsubscriptions, obj);
        emailsubscriptions.swipeLayout = (SwipeRefreshLayout)ewbinder.t((View)ewbinder.View(obj, 0x7f1000db, "field 'swipeLayout'"), 0x7f1000db, "field 'swipeLayout'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        bind(ewbinder, (EmailSubscriptions)grouponlistactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EmailSubscriptions)obj, obj1);
    }

    public void unbind(EmailSubscriptions emailsubscriptions)
    {
        super.unbind(emailsubscriptions);
        emailsubscriptions.swipeLayout = null;
    }

    public volatile void unbind(GrouponListActivity grouponlistactivity)
    {
        unbind((EmailSubscriptions)grouponlistactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EmailSubscriptions)obj);
    }

    public ()
    {
    }
}
