// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorConnection, SubAuthenticatorDescription

class this._cls0
    implements Runnable
{

    final SubAuthenticatorConnection this$0;

    public void run()
    {
        if (SubAuthenticatorConnection.access$000(SubAuthenticatorConnection.this))
        {
            return;
        } else
        {
            MAPLog.e(SubAuthenticatorConnection.access$500(), String.format("Application tried to bind to SubAuthenticator Service %s timed out.", new Object[] {
                SubAuthenticatorConnection.access$600(SubAuthenticatorConnection.this).packageName
            }));
            SubAuthenticatorConnection.access$400(SubAuthenticatorConnection.this).onConnectionTimeout(SubAuthenticatorConnection.this);
            closeConnection();
            return;
        }
    }

    ubAuthenticatorConnectionCallback()
    {
        this$0 = SubAuthenticatorConnection.this;
        super();
    }
}
