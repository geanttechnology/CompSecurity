// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.shazam.android.service.account:
//            a

public class StubAuthenticatorService extends Service
{

    private a a;

    public StubAuthenticatorService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return a.getIBinder();
    }

    public void onCreate()
    {
        a = new a(this);
    }
}
