// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            MobileScheduler, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (MobileScheduler)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MobileScheduler mobilescheduler, Object obj)
    {
        super.bind(ewbinder, mobilescheduler, obj);
        mobilescheduler.scheduleWebViewPlaceholder = (FrameLayout)ewbinder.eduleWebViewPlaceholder((View)ewbinder.redView(obj, 0x7f100417, "field 'scheduleWebViewPlaceholder'"), 0x7f100417, "field 'scheduleWebViewPlaceholder'");
        mobilescheduler.loading = (ProgressBar)ewbinder.ding((View)ewbinder.redView(obj, 0x7f1000df, "field 'loading'"), 0x7f1000df, "field 'loading'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MobileScheduler)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((MobileScheduler)grouponactivity);
    }

    public void unbind(MobileScheduler mobilescheduler)
    {
        super.unbind(mobilescheduler);
        mobilescheduler.scheduleWebViewPlaceholder = null;
        mobilescheduler.loading = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MobileScheduler)obj);
    }

    public ()
    {
    }
}
