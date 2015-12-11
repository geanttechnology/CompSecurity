// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import com.flurry.android.FlurryAgent;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class val.s
    implements android.view.r
{

    final SettingsFragment this$0;
    final String val$s;

    public void onClick(View view)
    {
        FlurryAgent.logEvent("action:faq_open");
        view = new android.app.(getActivity());
        view.setTitle(getResources().getString(0x7f0800ef));
        WebView webview = new WebView(getActivity());
        webview.loadUrl(val$s);
        class _cls1 extends WebViewClient
        {

            final SettingsFragment._cls4 this$1;

            public boolean shouldOverrideUrlLoading(WebView webview1, String s1)
            {
                if (s1.contains("fb://") || s1.contains("://play.google.com/store/apps/details?id="))
                {
                    webview1 = new Intent("android.intent.action.VIEW");
                    webview1.setData(Uri.parse(s1));
                    startActivity(webview1);
                    return true;
                }
                if (s1.startsWith("mailto:"))
                {
                    webview1 = MailTo.parse(s1);
                    s1 = new Intent("android.intent.action.SEND");
                    s1.putExtra("android.intent.extra.EMAIL", new String[] {
                        webview1.getTo()
                    });
                    s1.setType("message/rfc822");
                    startActivity(s1);
                    return true;
                } else
                {
                    return super.shouldOverrideUrlLoading(webview1, s1);
                }
            }

            _cls1()
            {
                this$1 = SettingsFragment._cls4.this;
                super();
            }
        }

        webview.setWebViewClient(new _cls1());
        view.setView(webview);
        class _cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final SettingsFragment._cls4 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            _cls2()
            {
                this$1 = SettingsFragment._cls4.this;
                super();
            }
        }

        view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
        view.show();
    }

    _cls2()
    {
        this$0 = final_settingsfragment;
        val$s = String.this;
        super();
    }
}
