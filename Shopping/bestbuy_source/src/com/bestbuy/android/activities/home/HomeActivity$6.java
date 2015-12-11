// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a extends BroadcastReceiver
{

    final HomeActivity a;

    public void onReceive(Context context, Intent intent)
    {
        a.buildSideMenu();
    }

    (HomeActivity homeactivity)
    {
        a = homeactivity;
        super();
    }
}
