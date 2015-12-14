// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.picsart.collages:
//            CollagesActivity

final class d extends BroadcastReceiver
{

    private CollagesActivity a;

    private d(CollagesActivity collagesactivity)
    {
        a = collagesactivity;
        super();
    }

    d(CollagesActivity collagesactivity, byte byte0)
    {
        this(collagesactivity);
    }

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag;
        if (!Inventory.isEditorAdsEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!Inventory.isAdsEnabled() || flag)
        {
            i.f(a.getApplicationContext());
            a.checkForInviteDialogs(Boolean.valueOf(flag));
        }
    }
}
