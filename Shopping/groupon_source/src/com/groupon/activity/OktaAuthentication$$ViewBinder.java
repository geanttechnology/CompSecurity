// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

// Referenced classes of package com.groupon.activity:
//            OktaAuthentication, GrouponActivity

public class _cls9 extends _cls9
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (OktaAuthentication)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, OktaAuthentication oktaauthentication, Object obj)
    {
        super.d(ewbinder, oktaauthentication, obj);
        oktaauthentication.webView = (WebView)ewbinder.View((View)ewbinder.View(obj, 0x7f1002fb, "field 'webView'"), 0x7f1002fb, "field 'webView'");
        oktaauthentication.webViewContent = (LinearLayout)ewbinder.ViewContent((View)ewbinder.View(obj, 0x7f10046d, "field 'webViewContent'"), 0x7f10046d, "field 'webViewContent'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (OktaAuthentication)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((OktaAuthentication)grouponactivity);
    }

    public void unbind(OktaAuthentication oktaauthentication)
    {
        super.ind(oktaauthentication);
        oktaauthentication.webView = null;
        oktaauthentication.webViewContent = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((OktaAuthentication)obj);
    }

    public _cls9()
    {
    }
}
