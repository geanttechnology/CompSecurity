// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class DealsWebViewActivity extends ShowWebViewActivity
{

    public DealsWebViewActivity()
    {
    }

    protected void createUI()
    {
        super.createUI();
        webview.setVerticalScrollBarEnabled(false);
        webview.getSettings().setBuiltInZoomControls(false);
    }

    protected void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (webview != null)
        {
            s = webview.getTitle();
            webview = s;
            if (TextUtils.isEmpty(s))
            {
                webview = getString(0x7f070280);
            }
            setTitle(webview);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = super.onPrepareOptionsMenu(menu);
        menu = menu.findItem(0x7f1009e6);
        if (menu != null && MyApp.getDeviceConfiguration().isShoppingCartEnabled())
        {
            menu.setVisible(true);
            menu.setEnabled(true);
        }
        return flag;
    }

    protected void readIntent()
    {
        super.readIntent();
        impression = "Deals";
        useBackStack = true;
        Resources resources = getResources();
        title = resources.getString(0x7f070280);
        backgroundColor = resources.getColor(0x7f0d00b5);
        maxWidth = resources.getDimensionPixelSize(0x7f090197);
        url = MyApp.getDeviceConfiguration().dealsUrl();
    }
}
