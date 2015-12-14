// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.socialin.android.photo.effects.activity:
//            EffectsActivityNew

final class a extends BroadcastReceiver
{

    private EffectsActivityNew a;

    private a(EffectsActivityNew effectsactivitynew)
    {
        a = effectsactivitynew;
        super();
    }

    a(EffectsActivityNew effectsactivitynew, byte byte0)
    {
        this(effectsactivitynew);
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
