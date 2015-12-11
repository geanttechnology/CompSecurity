// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            RedeemWebview, GrouponActivity

public class r extends r
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (RedeemWebview)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, RedeemWebview redeemwebview, Object obj)
    {
        super.bind(ewbinder, redeemwebview, obj);
        redeemwebview.redeemGroupon = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f100506, "field 'redeemGroupon'"), 0x7f100506, "field 'redeemGroupon'");
        redeemwebview.webview = (WebView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002fb, "field 'webview'"), 0x7f1002fb, "field 'webview'");
        redeemwebview.webviewContent = (LinearLayout)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f10046d, "field 'webviewContent'"), 0x7f10046d, "field 'webviewContent'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (RedeemWebview)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((RedeemWebview)grouponactivity);
    }

    public void unbind(RedeemWebview redeemwebview)
    {
        super.unbind(redeemwebview);
        redeemwebview.redeemGroupon = null;
        redeemwebview.webview = null;
        redeemwebview.webviewContent = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((RedeemWebview)obj);
    }

    public r()
    {
    }
}
