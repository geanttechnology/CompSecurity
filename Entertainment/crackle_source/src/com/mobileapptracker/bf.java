// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class bf
    implements Runnable
{

    final Activity a;
    final MobileAppTracker b;

    bf(MobileAppTracker mobileapptracker, Activity activity)
    {
        b = mobileapptracker;
        a = activity;
        super();
    }

    public final void run()
    {
        b.params.setReferralSource(a.getCallingPackage());
        Object obj = a.getIntent();
        if (obj != null)
        {
            obj = ((Intent) (obj)).getData();
            if (obj != null)
            {
                b.params.setReferralUrl(((Uri) (obj)).toString());
            }
        }
    }
}
