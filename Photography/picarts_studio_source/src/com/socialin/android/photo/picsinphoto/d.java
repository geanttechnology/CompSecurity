// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import com.picsart.shop.h;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class d extends BroadcastReceiver
{

    private MainPagerActivity a;

    private d(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }

    d(MainPagerActivity mainpageractivity, byte byte0)
    {
        this(mainpageractivity);
    }

    public final void onReceive(Context context, Intent intent)
    {
        context = (h)a.getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
        if (context != null)
        {
            context.a(true);
        }
        if (!Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled())
        {
            i.f(a.getApplicationContext());
            MainPagerActivity.s(a);
        }
    }
}
