// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;


// Referenced classes of package com.offerup.android.activities:
//            OfferUpWebViewActivity

final class er
    implements Runnable
{

    private OfferUpWebViewActivity a;

    er(OfferUpWebViewActivity offerupwebviewactivity)
    {
        a = offerupwebviewactivity;
        super();
    }

    public final void run()
    {
        a.i();
    }
}
