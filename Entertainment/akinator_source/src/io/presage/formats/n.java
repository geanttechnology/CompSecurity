// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.webkit.WebView;
import io.presage.utils.e;

final class n
    implements Runnable
{

    final String a;
    final h.c b;

    n(h.c c, String s)
    {
        b = c;
        a = s;
        super();
    }

    public final void run()
    {
        e.b(new String[] {
            "Webviews", "[", h.c.b(b), "] setTimeout call:", a
        });
        StringBuilder stringbuilder = new StringBuilder("javascript:window.");
        stringbuilder.append(a);
        stringbuilder.append("();");
        h.c.c(b).loadUrl(stringbuilder.toString());
    }
}
