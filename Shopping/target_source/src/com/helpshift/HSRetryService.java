// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.helpshift:
//            l

public final class HSRetryService extends Service
{

    private l a;

    public HSRetryService()
    {
        a = null;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (a == null)
        {
            a = new l(this);
        }
        a.v();
        a.w();
        stopSelf();
        return 2;
    }
}
