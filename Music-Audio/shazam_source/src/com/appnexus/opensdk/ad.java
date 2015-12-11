// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            ac, z, MediatedBannerAdView, aa, 
//            ae, aq, ab, h, 
//            d

public final class ad extends ac
{

    ad(Activity activity, h h1, aa aa1, d d)
    {
        super(h1, aa1, d, z.a);
        if (a(com/appnexus/opensdk/MediatedBannerAdView)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        b.b(b.c, b.a(an.d.mediated_request));
        g();
        super.i = System.currentTimeMillis();
        if (activity == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (h)
        {
            break; /* Loop/switch isn't completed */
        }
        activity = ((MediatedBannerAdView)b).requestAd(this, activity, c.b, c.e, c.c, c.d, a());
        e.a = activity;
        activity = null;
_L4:
        h1 = activity;
        if (activity == null)
        {
            h1 = activity;
            if (e.a == null)
            {
                b.e(b.c, b.a(an.d.mediated_view_null));
                h1 = aq.f;
            }
        }
        if (h1 != null)
        {
            a(h1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        try
        {
            b.e(b.c, b.a(an.d.mediated_request_null_activity));
            activity = aq.f;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            b.b(b.c, b.a(an.d.mediated_request_exception), activity);
            activity = aq.f;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            b.b(b.c, b.a(an.d.mediated_request_error), activity);
            activity = aq.f;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void h()
    {
        h = true;
        if (b != null)
        {
            b.onDestroy();
        }
    }

    public final void i()
    {
        if (b != null)
        {
            b.onPause();
        }
    }

    public final void j()
    {
        if (b != null)
        {
            b.onResume();
        }
    }
}
