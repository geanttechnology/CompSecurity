// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import nu;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYWebView

class a
    implements Runnable
{

    final BBYWebView a;

    public void run()
    {
        BBYWebView.h(a).updateCartCount(BBYWebView.k(a));
    }

    (BBYWebView bbywebview)
    {
        a = bbywebview;
        super();
    }
}
