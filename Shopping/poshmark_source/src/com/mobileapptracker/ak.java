// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.widget.Toast;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker

final class ak
    implements Runnable
{

    final MobileAppTracker a;

    ak(MobileAppTracker mobileapptracker)
    {
        a = mobileapptracker;
        super();
    }

    public final void run()
    {
        Toast.makeText(a.mContext, "MAT Allow Duplicate Requests Enabled, do not release with this enabled!!", 1).show();
    }
}
