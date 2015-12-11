// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorConnection, SubAuthenticatorDescription

class this._cls0
    implements ServiceConnection
{

    final SubAuthenticatorConnection this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SubAuthenticatorConnection.access$002(SubAuthenticatorConnection.this, true);
        synchronized (SubAuthenticatorConnection.access$100(SubAuthenticatorConnection.this))
        {
            SubAuthenticatorConnection.access$202(SubAuthenticatorConnection.this, rrentState.Bound);
            SubAuthenticatorConnection.access$302(SubAuthenticatorConnection.this, com.amazon.dcp.sso.rface(ibinder));
            ibinder = SubAuthenticatorConnection.access$400(SubAuthenticatorConnection.this);
            MAPLog.i(SubAuthenticatorConnection.access$500(), String.format("Connected to SubAuthenticator in package %s.", new Object[] {
                SubAuthenticatorConnection.access$600(SubAuthenticatorConnection.this).packageName
            }));
        }
        if (ibinder != null)
        {
            ibinder.onConnected(SubAuthenticatorConnection.this);
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SubAuthenticatorConnection.access$702(SubAuthenticatorConnection.this, null);
        ubAuthenticatorConnectionCallback ubauthenticatorconnectioncallback;
        synchronized (SubAuthenticatorConnection.access$100(SubAuthenticatorConnection.this))
        {
            SubAuthenticatorConnection.access$202(SubAuthenticatorConnection.this, rrentState.Unbound);
            ubauthenticatorconnectioncallback = SubAuthenticatorConnection.access$400(SubAuthenticatorConnection.this);
            SubAuthenticatorConnection.access$302(SubAuthenticatorConnection.this, null);
            MAPLog.i(SubAuthenticatorConnection.access$500(), String.format("Disconnected from SubAuthenticator in package %s.", new Object[] {
                SubAuthenticatorConnection.access$600(SubAuthenticatorConnection.this).packageName
            }));
        }
        if (ubauthenticatorconnectioncallback != null)
        {
            ubauthenticatorconnectioncallback.onDisconnected(SubAuthenticatorConnection.this);
        }
    }

    ubAuthenticatorConnectionCallback()
    {
        this$0 = SubAuthenticatorConnection.this;
        super();
    }
}
