// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            by, cn, dz

final class a
    implements android.view.OnClickListener
{

    final String a;
    final by b;

    public final void onClick(View view)
    {
        String s = by.d(b).getUrl();
        view = s;
        if (s == null)
        {
            by.a(b).c("The current URL is null. Reverting to the original URL for external browser.", null);
            view = a;
        }
        by.b(b);
        dz.a(view, by.d(b).getContext());
    }

    stener(by by1, String s)
    {
        b = by1;
        a = s;
        super();
    }
}
