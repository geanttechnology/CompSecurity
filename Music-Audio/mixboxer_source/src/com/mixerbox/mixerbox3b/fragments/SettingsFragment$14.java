// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls0
    implements android.view.
{

    final SettingsFragment this$0;

    public void onClick(View view)
    {
        if (!MixerBoxClient.isConnectingToInternet(getActivity()))
        {
            AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
            return;
        } else
        {
            view = new android.app.<init>(getActivity());
            WebView webview = new WebView(getActivity());
            webview.loadUrl("http://static.mixerbox.com/inAppWeb/mb.copyright.info.android.html");
            class _cls1 extends WebViewClient
            {

                final SettingsFragment._cls14 this$1;

                public boolean shouldOverrideUrlLoading(WebView webview1, String s)
                {
                    if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
                    {
                        webview1 = new Intent("android.intent.action.VIEW");
                        webview1.setData(Uri.parse(s));
                        startActivity(webview1);
                        return true;
                    }
                    if (s.startsWith("mailto:"))
                    {
                        webview1 = MailTo.parse(s);
                        s = new Intent("android.intent.action.SEND");
                        s.putExtra("android.intent.extra.EMAIL", new String[] {
                            webview1.getTo()
                        });
                        s.setType("message/rfc822");
                        startActivity(s);
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview1, s);
                    }
                }

            _cls1()
            {
                this$1 = SettingsFragment._cls14.this;
                super();
            }
            }

            webview.setWebViewClient(new _cls1());
            view.setView(webview);
            class _cls2
                implements android.content.DialogInterface.OnClickListener
            {

                final SettingsFragment._cls14 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            _cls2()
            {
                this$1 = SettingsFragment._cls14.this;
                super();
            }
            }

            view.setNegativeButton(getResources().getString(0x7f08007e), new _cls2());
            view.show();
            return;
        }
    }

    _cls2()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
