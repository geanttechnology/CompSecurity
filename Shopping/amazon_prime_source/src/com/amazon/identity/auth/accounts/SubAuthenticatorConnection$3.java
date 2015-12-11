// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorConnection

class eregisterConnectionCallback extends com.amazon.dcp.sso.b
{

    final SubAuthenticatorConnection this$0;
    final eregisterConnectionCallback val$deregisterCallback;

    public void onError(int i, String s)
    {
        if (val$deregisterCallback != null)
        {
            val$deregisterCallback._mth1a7fe030(i, s);
        }
    }

    public void onResult(Bundle bundle)
    {
        if (val$deregisterCallback != null)
        {
            val$deregisterCallback._mth44f542f7();
        }
    }

    eregisterConnectionCallback()
    {
        this$0 = final_subauthenticatorconnection;
        val$deregisterCallback = eregisterConnectionCallback.this;
        super();
    }
}
