// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

// Referenced classes of package com.groupon.activity:
//            LogViewer, GrouponActivity

public class inder extends inder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (LogViewer)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, LogViewer logviewer, Object obj)
    {
        super.bind(ewbinder, logviewer, obj);
        logviewer.webView = (WebView)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f1002fb, "field 'webView'"), 0x7f1002fb, "field 'webView'");
        logviewer.search = (EditText)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f1003e9, "field 'search'"), 0x7f1003e9, "field 'search'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (LogViewer)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((LogViewer)grouponactivity);
    }

    public void unbind(LogViewer logviewer)
    {
        super.unbind(logviewer);
        logviewer.webView = null;
        logviewer.search = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((LogViewer)obj);
    }

    public inder()
    {
    }
}
