// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.MyFocusableWebView;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class val.jAd
    implements android.view.r
{

    final SettingsFragment this$0;
    final JSONObject val$jAd;

    public void onClick(View view)
    {
        FlurryAgent.logEvent("page:open_ad");
        view = new android.app.(getActivity());
        MyFocusableWebView myfocusablewebview = new MyFocusableWebView(getActivity());
        class _cls1 extends WebViewClient
        {

            final SettingsFragment._cls3 this$1;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
                {
                    webview = new Intent("android.intent.action.VIEW");
                    webview.setData(Uri.parse(s));
                    startActivity(webview);
                    return true;
                }
                if (s.startsWith("mailto:"))
                {
                    webview = MailTo.parse(s);
                    s = new Intent("android.intent.action.SEND");
                    s.putExtra("android.intent.extra.EMAIL", new String[] {
                        webview.getTo()
                    });
                    s.setType("message/rfc822");
                    startActivity(s);
                    return true;
                } else
                {
                    return super.shouldOverrideUrlLoading(webview, s);
                }
            }

            _cls1()
            {
                this$1 = SettingsFragment._cls3.this;
                super();
            }
        }

        class _cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final SettingsFragment._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            _cls2()
            {
                this$1 = SettingsFragment._cls3.this;
                super();
            }
        }

        try
        {
            myfocusablewebview.loadUrl(val$jAd.getString("link"));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        myfocusablewebview.getSettings().setJavaScriptEnabled(true);
        myfocusablewebview.setWebChromeClient(new WebChromeClient());
        myfocusablewebview.setWebViewClient(new _cls1());
        view.setView(myfocusablewebview);
        view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
        view.show().getWindow().setSoftInputMode(16);
    }

    _cls2()
    {
        this$0 = final_settingsfragment;
        val$jAd = JSONObject.this;
        super();
    }
}
