// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.LoaderManager;
import android.content.SharedPreferences;

// Referenced classes of package com.wishabi.flipp.app:
//            CouponFragment

final class u
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final CouponFragment a;

    u(CouponFragment couponfragment)
    {
        a = couponfragment;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (a.isAdded())
        {
            if ((sharedpreferences = a.getLoaderManager()) != null && (s.equals("postal_code") || s.equals("coupon_category_order")))
            {
                sharedpreferences.initLoader(2, null, a);
                sharedpreferences.restartLoader(3, null, a);
                return;
            }
        }
    }
}
