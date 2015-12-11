// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

// Referenced classes of package com.groupon.activity:
//            SimpleMarkUpActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (SimpleMarkUpActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, SimpleMarkUpActivity simplemarkupactivity, Object obj)
    {
        super.bind(ewbinder, simplemarkupactivity, obj);
        simplemarkupactivity.webViewContainer = (LinearLayout)ewbinder.ViewContainer((View)ewbinder.ew(obj, 0x7f100526, "field 'webViewContainer'"), 0x7f100526, "field 'webViewContainer'");
        simplemarkupactivity.simpleMarkup = (WebView)ewbinder.pleMarkup((View)ewbinder.ew(obj, 0x7f100528, "field 'simpleMarkup'"), 0x7f100528, "field 'simpleMarkup'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (SimpleMarkUpActivity)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((SimpleMarkUpActivity)grouponactivity);
    }

    public void unbind(SimpleMarkUpActivity simplemarkupactivity)
    {
        super.d(simplemarkupactivity);
        simplemarkupactivity.webViewContainer = null;
        simplemarkupactivity.simpleMarkup = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((SimpleMarkUpActivity)obj);
    }

    public ()
    {
    }
}
