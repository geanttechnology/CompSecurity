// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.webkit.WebView;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity

class a
    implements android.support.v4.widget.nRefreshListener
{

    final WebViewerActivity a;

    public void onRefresh()
    {
        if (a.f != null)
        {
            a.f.reload();
        }
        if (a.u != null)
        {
            a.u.setRefreshing(false);
        }
    }

    efreshLayout(WebViewerActivity webvieweractivity)
    {
        a = webvieweractivity;
        super();
    }
}
