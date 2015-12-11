// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.webkit.WebView;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.core.SupportInfoService;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class FinePrint extends GrouponActivity
{

    private DeviceInfoUtil deviceInfoUtil;
    WebView finePrint;
    private SupportInfoService supportInfoService;

    public FinePrint()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300e8);
        ViewUtils.initWebView(finePrint);
        String s = supportInfoService.getSupportInfo().contents.finePrint;
        WebView webview = finePrint;
        StringBuilder stringbuilder = new StringBuilder();
        if (deviceInfoUtil.isRTLLanguage())
        {
            bundle = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
        } else
        {
            bundle = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:0px;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
        }
        webview.loadDataWithBaseURL(null, stringbuilder.append(bundle).append(s).toString(), "text/html", "utf-8", null);
    }

    public void onDestroy()
    {
        super.onDestroy();
        finePrint.destroy();
    }
}
