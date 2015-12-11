// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            GrouponBookNowActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (GrouponBookNowActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, GrouponBookNowActivity grouponbooknowactivity, Object obj)
    {
        super.bind(ewbinder, grouponbooknowactivity, obj);
        grouponbooknowactivity.bookNewWebView = (WebView)ewbinder.kNewWebView((View)ewbinder.(obj, 0x7f100106, "field 'bookNewWebView'"), 0x7f100106, "field 'bookNewWebView'");
        grouponbooknowactivity.loadingView = (ProgressBar)ewbinder.dingView((View)ewbinder.(obj, 0x7f1000df, "field 'loadingView'"), 0x7f1000df, "field 'loadingView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponBookNowActivity)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((GrouponBookNowActivity)grouponactivity);
    }

    public void unbind(GrouponBookNowActivity grouponbooknowactivity)
    {
        super.unbind(grouponbooknowactivity);
        grouponbooknowactivity.bookNewWebView = null;
        grouponbooknowactivity.loadingView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponBookNowActivity)obj);
    }

    public ()
    {
    }
}
