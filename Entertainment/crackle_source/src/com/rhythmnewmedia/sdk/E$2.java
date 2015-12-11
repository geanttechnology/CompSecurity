// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.webkit.WebView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            E, G, M

final class a
    implements Runnable
{

    final G a;
    final E b;

    public final void run()
    {
        if (a.g.getParent() != null)
        {
            b.removeView(a.g);
        }
        b.addView(a.g);
        M m = a.g;
        if (m.a != null)
        {
            m.a.loadUrl("javascript:net.rnmd.sdk.rhythmAdDisplayed()");
        }
    }

    (E e, G g)
    {
        b = e;
        a = g;
        super();
    }
}
