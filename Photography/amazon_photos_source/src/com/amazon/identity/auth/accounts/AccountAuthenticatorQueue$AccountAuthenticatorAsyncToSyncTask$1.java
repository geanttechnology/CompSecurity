// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountAuthenticatorQueue

class this._cls0
    implements Callback
{

    final this._cls0 this$0;

    public void onError(Bundle bundle)
    {
        MAPLog.formattedInfo(AccountAuthenticatorQueue.access$000(), "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
            cess._mth100(this._cls0.this)
        });
        cess._mth400(this._cls0.this);
        cess._mth300(this._cls0.this).onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.formattedInfo(AccountAuthenticatorQueue.access$000(), "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
            cess._mth100(this._cls0.this)
        });
        cess._mth200(this._cls0.this);
        cess._mth300(this._cls0.this).onSuccess(bundle);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
