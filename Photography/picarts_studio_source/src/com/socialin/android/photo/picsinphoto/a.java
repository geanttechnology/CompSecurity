// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a extends BroadcastReceiver
{

    private MainPagerActivity a;

    private a(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }

    a(MainPagerActivity mainpageractivity, byte byte0)
    {
        this(mainpageractivity);
    }

    public final void onReceive(Context context, Intent intent)
    {
        MainPagerActivity.r(a);
        MainPagerActivity.s(a);
    }
}
