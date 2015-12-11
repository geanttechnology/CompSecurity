// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.flurry.android:
//            fp, AdUnit, FlurryAds, FlurryFullscreenTakeoverActivity, 
//            fl, cy

final class cr extends fp
{

    private FlurryAds du;
    private String eH;
    private boolean eI;
    private AdUnit eJ;
    private Context n;

    cr(FlurryAds flurryads, String s, AdUnit adunit, Context context, boolean flag)
    {
        du = flurryads;
        eH = s;
        eJ = adunit;
        n = context;
        eI = flag;
        super();
    }

    public final void c()
    {
        String s;
        if (eH == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        s = eJ.getAdSpace().toString();
        if (!eH.startsWith("market://")) goto _L2; else goto _L1
_L1:
        du.d(n, eH, s);
_L4:
        return;
_L2:
        if (eH.startsWith("http"))
        {
            Intent intent = new Intent(n, com/flurry/android/FlurryFullscreenTakeoverActivity);
            intent.putExtra("url", eH);
            if (eI && fl.a(n, intent))
            {
                du.a(n, intent, s);
                return;
            } else
            {
                cy.d(FlurryAds.p, "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
                du.c(n, eH, s);
                return;
            }
        }
        if (du.c(n, eH, s)) goto _L4; else goto _L3
_L3:
        cy.g(FlurryAds.p, (new StringBuilder()).append("Failed to launch intent for:").append(eH).toString());
        return;
        String s1 = (new StringBuilder()).append("Unable to launch intent for: ").append(eH).toString();
        cy.g(FlurryAds.p, s1);
        return;
    }
}
