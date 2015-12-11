// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.credentials.AccountCredentials;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, AccountRegistrar

class val.creds
    implements Runnable
{

    final this._cls0 this$0;
    final AccountCredentials val$creds;
    final this._cls0 val$emptyListener;
    final String val$overridingDSNChildDevicePackageName;
    final AccountRegistrar val$registrar;

    public void run()
    {
        val$registrar.deregister(val$emptyListener, val$overridingDSNChildDevicePackageName, cess._mth100(this._cls0.this), val$creds, true, cess._mth200(this._cls0.this), cess._mth300(this._cls0.this));
    }

    ()
    {
        this$0 = final_;
        val$registrar = accountregistrar;
        val$emptyListener = 1;
        val$overridingDSNChildDevicePackageName = s;
        val$creds = AccountCredentials.this;
        super();
    }
}
