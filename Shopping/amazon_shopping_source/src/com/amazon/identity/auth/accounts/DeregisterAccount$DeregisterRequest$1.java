// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount

class this._cls0
    implements this._cls0
{

    final name this$0;

    public void accountAlreadyExists(String s)
    {
        MAPLog.e(DeregisterAccount.access$000(), String.format("Deregister Failure for Overriding DSN Child Device Type due to registration already existing.  This should not happen. DirectedId: %s", new Object[] {
            s
        }));
    }

    public void failure(com.amazon.identity.auth.device.api.is._cls0 _pcls0, Bundle bundle)
    {
        MAPLog.e(DeregisterAccount.access$000(), String.format("Deregister Failure for Overriding DSN Child Device Type: %s", new Object[] {
            _pcls0.me()
        }));
    }

    public void success(String s, String s1, Bundle bundle)
    {
        DeregisterAccount.access$000();
        String.format("Deregister Succeeded for Overriding DSN Child Device Type. directedId %s", new Object[] {
            s
        });
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
