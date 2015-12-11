// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            fp, FlurryAds, cy, AdUnit

final class cq extends fp
{

    private FlurryAds du;
    private String eH;
    private boolean eI;
    private AdUnit eJ;
    private Context n;

    cq(FlurryAds flurryads, Context context, String s, boolean flag, AdUnit adunit)
    {
        du = flurryads;
        n = context;
        eH = s;
        eI = true;
        eJ = adunit;
        super();
    }

    public final void c()
    {
        String s = du.h(n, eH);
        if (s != null)
        {
            du.a(n, s, eI, eJ);
            return;
        } else
        {
            cy.g(FlurryAds.p, (new StringBuilder()).append("Redirect URL could not be found for: ").append(eH).toString());
            return;
        }
    }
}
