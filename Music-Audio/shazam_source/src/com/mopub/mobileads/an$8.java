// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.mopub.mobileads:
//            an, x

final class ent extends WebViewClient
{

    final x a;
    final Context b;
    final an c;

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        a.a(b, s);
        return true;
    }

    ent(an an1, x x1, Context context)
    {
        c = an1;
        a = x1;
        b = context;
        super();
    }
}
