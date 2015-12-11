// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class aq
    implements Runnable
{

    final String a;
    final MobileAppTracker b;

    aq(MobileAppTracker mobileapptracker, String s)
    {
        b = mobileapptracker;
        a = s;
        super();
    }

    public final void run()
    {
        if (a == null || a.equals(""))
        {
            b.params.setPackageName(b.mContext.getPackageName());
            return;
        } else
        {
            b.params.setPackageName(a);
            return;
        }
    }
}
