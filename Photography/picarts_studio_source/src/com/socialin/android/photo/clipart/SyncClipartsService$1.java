// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.util.s;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SyncClipartsService, e

final class  extends BroadcastReceiver
{

    public final void onReceive(Context context, Intent intent)
    {
        SyncClipartsService.a();
        if (s.a(context) && s.b(context) && SocialinV3.getInstance().isRegistered())
        {
            SyncClipartsService.a();
            intent = context.getSharedPreferences("clipart_sync_pref_name", 0);
            long l = intent.getLong("last_sync_time", 0L);
            if (System.currentTimeMillis() - l < 0L)
            {
                l = 0x493e1L;
            } else
            {
                l = System.currentTimeMillis() - l;
            }
            if (l > 0x493e0L)
            {
                SyncClipartsService.a();
                intent.edit().putLong("last_sync_time", System.currentTimeMillis()).apply();
                e.a(context);
            }
        }
    }

    ()
    {
    }
}
