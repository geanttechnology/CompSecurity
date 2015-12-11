// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            h, e, dw, cn

final class b
    implements Runnable
{

    final String a;
    final boolean b;
    final h c;

    public final void run()
    {
        Object obj = c.a();
        String s = a;
        boolean flag = b;
        obj = ((e) (obj)).a;
        s = (new StringBuilder("javascript:")).append(s).toString();
        if (flag)
        {
            ((dw) (obj)).d().loadUrl(s);
            return;
        } else
        {
            ((dw) (obj)).l.b((new StringBuilder("Loading URL: ")).append(s).toString(), null);
            ((dw) (obj)).b().loadUrl(s);
            return;
        }
    }

    (h h1, String s, boolean flag)
    {
        c = h1;
        a = s;
        b = flag;
        super();
    }
}
