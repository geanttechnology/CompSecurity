// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            Support, GrouponActivity

public class wBinder extends wBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (Support)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, Support support, Object obj)
    {
        super.bind(ewbinder, support, obj);
        support.details = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100543, "field 'details'"), 0x7f100543, "field 'details'");
        support.faq = (WebView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100544, "field 'faq'"), 0x7f100544, "field 'faq'");
        support.layout = (View)ewbinder.indRequiredView(obj, 0x7f100542, "field 'layout'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Support)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((Support)grouponactivity);
    }

    public void unbind(Support support)
    {
        super.unbind(support);
        support.details = null;
        support.faq = null;
        support.layout = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((Support)obj);
    }

    public wBinder()
    {
    }
}
