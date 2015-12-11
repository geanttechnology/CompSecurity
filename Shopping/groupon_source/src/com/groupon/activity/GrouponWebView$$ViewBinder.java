// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            GrouponWebView

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, GrouponWebView grouponwebview, Object obj)
    {
        grouponwebview.grouponWebViewPlaceholder = (FrameLayout)ewbinder.((View)ewbinder.iredView(obj, 0x7f100370, "field 'grouponWebViewPlaceholder'"), 0x7f100370, "field 'grouponWebViewPlaceholder'");
        grouponwebview.progressBar = (ProgressBar)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000df, "field 'progressBar'"), 0x7f1000df, "field 'progressBar'");
        grouponwebview.toolbar = (Toolbar)ewbinder.((View)ewbinder.onalView(obj, 0x7f100180, null), 0x7f100180, "field 'toolbar'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponWebView)obj, obj1);
    }

    public void unbind(GrouponWebView grouponwebview)
    {
        grouponwebview.grouponWebViewPlaceholder = null;
        grouponwebview.progressBar = null;
        grouponwebview.toolbar = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponWebView)obj);
    }

    public ()
    {
    }
}
