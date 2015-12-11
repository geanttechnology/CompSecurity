// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.wishabi.flipp.b.p;

// Referenced classes of package com.wishabi.flipp.app:
//            aa, ds, CouponDetailsActivity

public final class dr
{

    public static int a(Activity activity, int ai[], boolean flag, p p)
    {
        while (activity == null || ai == null || ai.length == 0) 
        {
            return 0;
        }
        if (activity.getResources().getConfiguration().isLayoutSizeAtLeast(3) && android.os.Build.VERSION.SDK_INT >= 17)
        {
            aa.a(ai, flag, p).show(activity.getFragmentManager(), "CouponDialogTag");
            return ds.b;
        } else
        {
            activity.startActivity(CouponDetailsActivity.a(ai, flag, p));
            activity.overridePendingTransition(0x7f040001, 0x7f040002);
            return ds.a;
        }
    }
}
