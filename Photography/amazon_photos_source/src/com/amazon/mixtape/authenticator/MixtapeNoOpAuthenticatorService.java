// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.amazon.mixtape.authenticator:
//            MixtapeNoOpAuthenticator

public class MixtapeNoOpAuthenticatorService extends Service
{

    private MixtapeNoOpAuthenticator mAuthenticator;

    public MixtapeNoOpAuthenticatorService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return mAuthenticator.getIBinder();
    }

    public void onCreate()
    {
        mAuthenticator = new MixtapeNoOpAuthenticator(this);
    }
}
