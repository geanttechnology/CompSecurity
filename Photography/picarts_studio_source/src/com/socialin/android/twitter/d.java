// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.Intent;
import android.webkit.WebView;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterWebAuthentication

final class d extends myobfuscated.cv.d
{

    private TwitterWebAuthentication a;

    private d(TwitterWebAuthentication twitterwebauthentication)
    {
        a = twitterwebauthentication;
        super();
    }

    d(TwitterWebAuthentication twitterwebauthentication, byte byte0)
    {
        this(twitterwebauthentication);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        com.socialin.android.d.b(TwitterWebAuthentication.a(), new Object[] {
            (new StringBuilder("shouldOverrideUrlLoading : Redirect URL: ")).append(s).toString()
        });
        if (s.startsWith("twitterconnect://success"))
        {
            webview = new Intent();
            webview.putExtra("url", s);
            a.setResult(-1, webview);
            a.finish();
            return true;
        } else
        {
            return false;
        }
    }
}
