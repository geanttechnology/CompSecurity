// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.try;

import android.webkit.WebView;

// Referenced classes of package io.presage.try:
//            d

final class f
    implements io.presage.formats.multiwebviews.h.a
{

    final d a;

    f(d d1)
    {
        a = d1;
        super();
    }

    public final void a(WebView webview, String s)
    {
        if (d.b(a) != null)
        {
            d.b(a).a(webview, s);
        }
    }
}
