// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import myobfuscated.cv.d;

// Referenced classes of package com.socialin.android.tumblr:
//            TumblrOAuthActivity

final class a extends d
{

    private String a;
    private TumblrOAuthActivity b;

    public a(TumblrOAuthActivity tumblroauthactivity, String s)
    {
        b = tumblroauthactivity;
        super();
        a = s;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        webview.setVisibility(0);
        b.findViewById(0x7f100a6e).setVisibility(4);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        com.socialin.android.d.b(TumblrOAuthActivity.a(), new Object[] {
            (new StringBuilder("shouldOverrideUrlLoading : Redirect URL: ")).append(s).toString()
        });
        if (s.contains(a))
        {
            (new Thread(new TumblrOAuthActivity._cls1(b, Uri.parse(s)))).start();
            return true;
        } else
        {
            return false;
        }
    }
}
