// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Locale;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.ads:
//            e, f

public class SocialinBannerView extends WebView
{

    private static String a = "http://adturns.com/ad.php?c=118";

    public SocialinBannerView(Context context)
    {
        super(context);
        a();
    }

    public SocialinBannerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(100);
        setBackgroundColor(0xff000000);
        Object obj = getSettings();
        ((WebSettings) (obj)).setSavePassword(false);
        ((WebSettings) (obj)).setSaveFormData(false);
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setSupportZoom(false);
        setWebChromeClient(new e());
        addJavascriptInterface(new f(), "SI");
        obj = null;
        if (m.a(getContext(), "string", "app_name_short"))
        {
            obj = getContext().getString(m.b(getContext(), "string", "app_name_short"));
        }
        if (m.a(getContext(), "string", "si_app_uid"))
        {
            obj = getContext().getString(m.b(getContext(), "string", "si_app_uid"));
        }
        if (m.a(getContext(), "string", "configVersion"))
        {
            String s = getContext().getString(m.e(getContext(), "configVersion"));
            a = (new StringBuilder()).append(getContext().getString(m.e(getContext(), (new StringBuilder("socialin_ad_url_")).append(s).toString()))).append("&language=").append(Locale.getDefault().getLanguage()).toString();
        }
        (new StringBuilder("url+ ")).append(a).append(" from: ").append(((String) (obj)));
        if (obj != null)
        {
            loadUrl((new StringBuilder()).append(a).append("&from=").append(((String) (obj))).toString());
            return;
        } else
        {
            loadUrl(a);
            return;
        }
    }

    public void setKeywords(String s)
    {
    }

}
