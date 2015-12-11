// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.webkit.WebView;

// Referenced classes of package com.mopub.common:
//            e, n, MoPubBrowser

final class t>
    implements t>
{

    final e a;

    public final void a(String s, n n1)
    {
        if (n1.equals(n.f))
        {
            e.a(a).a.loadUrl(s);
            return;
        } else
        {
            e.a(a).finish();
            return;
        }
    }

    w(e e1)
    {
        a = e1;
        super();
    }
}
