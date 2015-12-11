// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.core.SupportInfoService;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.view.NonLeakingWebView;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class SimpleMarkUpActivity extends GrouponActivity
{

    private DeviceInfoUtil deviceInfoUtil;
    WebView simpleMarkup;
    private SupportInfoService supportInfoService;
    private String title;
    LinearLayout webViewContainer;

    public SimpleMarkUpActivity()
    {
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(title);
    }

    public void onCreate(Bundle bundle)
    {
        String s1;
        super.onCreate(bundle);
        setContentView(0x7f030203);
        simpleMarkup.setBackgroundColor(getResources().getColor(0x7f0e0156));
        ((NonLeakingWebView)simpleMarkup).setShouldInternalizePaths(true);
        s1 = getIntent().getData().getPath();
        simpleMarkup.setVisibility(0);
        bundle = supportInfoService.getSupportInfo();
        WebView webview;
        StringBuilder stringbuilder;
        if (Strings.equalsIgnoreCase(s1, "/tos") || Strings.equalsIgnoreCase(s1, "/terms"))
        {
            bundle = ((SupportInfo) (bundle)).contents.termsOfService;
            title = getString(0x7f0803e3);
        } else
        if (Strings.equalsIgnoreCase(s1, "/cookiepolicy"))
        {
            bundle = ((SupportInfo) (bundle)).contents.cookiePolicy;
            title = getString(0x7f0800ca);
        } else
        {
            bundle = ((SupportInfo) (bundle)).contents.privacyPolicy;
            title = getString(0x7f0802ee);
        }
        webview = simpleMarkup;
        stringbuilder = new StringBuilder();
        String s;
        if (deviceInfoUtil.isRTLLanguage())
        {
            s = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
        } else
        {
            s = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:0px;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
        }
        try
        {
            webview.loadDataWithBaseURL(null, stringbuilder.append(s).append(bundle).toString(), "text/html", "utf-8", null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            s = String.format("DEBUGGING HELP -- NOT AN ACTUAL CRASH: null /support_info url for %s", new Object[] {
                s1
            });
        }
        Ln.d("SIMPLEMARKUP: %s", new Object[] {
            s
        });
        Ln.e(bundle, s, new Object[0]);
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        simpleMarkup.destroy();
    }
}
