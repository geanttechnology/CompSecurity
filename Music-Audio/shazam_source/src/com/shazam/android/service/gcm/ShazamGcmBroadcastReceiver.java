// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.g;

// Referenced classes of package com.shazam.android.service.gcm:
//            GcmIntentService

public class ShazamGcmBroadcastReceiver extends g
{

    public ShazamGcmBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        a(context, intent.setComponent(new ComponentName(context.getPackageName(), com/shazam/android/service/gcm/GcmIntentService.getName())));
        setResultCode(-1);
    }
}
