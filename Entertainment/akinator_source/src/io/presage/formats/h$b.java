// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.webkit.WebChromeClient;
import io.presage.utils.e;

// Referenced classes of package io.presage.formats:
//            h

final class d extends WebChromeClient
{

    final h a;
    private h b;
    private String c;
    private io.presage.do.e d;

    public final void onConsoleMessage(String s, int i, String s1)
    {
        e.a(new String[] {
            "Webviews", "[", c, "]", s, "-- From line", Integer.toString(i), "of", s1
        });
    }

    public eClient(h h1, String s, h h2, io.presage.do.e e1)
    {
        a = h1;
        super();
        c = s;
        b = h2;
        d = e1;
    }
}
