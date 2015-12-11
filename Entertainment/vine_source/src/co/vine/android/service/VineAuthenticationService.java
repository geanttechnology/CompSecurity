// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import co.vine.android.VineAccountAuthenticator;

public class VineAuthenticationService extends Service
{

    private VineAccountAuthenticator mAuthenticator;

    public VineAuthenticationService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return mAuthenticator.getIBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        mAuthenticator = new VineAccountAuthenticator(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mAuthenticator = null;
    }
}
