// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.try;

import android.webkit.WebView;

// Referenced classes of package io.presage.try:
//            d

final class e
    implements io.presage.formats.multiwebviews.h.b
{

    final d a;

    e(d d1)
    {
        a = d1;
        super();
    }

    public final void a(WebView webview, String s)
    {
        if (d.a(a) != null)
        {
            d.a(a).b((d)webview, s);
        }
    }
}
