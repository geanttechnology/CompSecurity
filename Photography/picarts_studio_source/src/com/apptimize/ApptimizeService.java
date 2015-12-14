// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptimize;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

// Referenced classes of package com.apptimize:
//            dG, at, gM

public class ApptimizeService extends Service
{

    private static final String TAG = com/apptimize/ApptimizeService.getSimpleName();
    private final Messenger messenger;

    public ApptimizeService()
    {
        messenger = (Messenger)at.a(TAG, null, new dG(this));
    }

    public IBinder onBind(Intent intent)
    {
        return (IBinder)at.a(TAG, null, new gM(this));
    }



}
