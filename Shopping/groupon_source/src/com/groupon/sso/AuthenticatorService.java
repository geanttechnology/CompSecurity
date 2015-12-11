// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.groupon.sso:
//            Authenticator

public class AuthenticatorService extends Service
{

    public AuthenticatorService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return (new Authenticator(this)).getIBinder();
    }
}
