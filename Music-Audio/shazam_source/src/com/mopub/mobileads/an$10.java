// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.mopub.mobileads:
//            an, i, aa

final class nt extends WebViewClient
{

    final aa a;
    final an b;

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        a.a(((i) (b)).a, s);
        return true;
    }

    nt(an an1, aa aa1)
    {
        b = an1;
        a = aa1;
        super();
    }
}
