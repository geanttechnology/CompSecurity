// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.utils.ADPCorpusSigningCallbackHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, InProcessAdpAuthenticationMethod

class val.callbackFuture
    implements Callback
{

    final InProcessAdpAuthenticationMethod this$0;
    final CallbackFuture val$callbackFuture;
    final byte val$corpus[];

    public void onError(Bundle bundle)
    {
        MAPLog.e(InProcessAdpAuthenticationMethod.access$100(), "Unknown error during signCorpus execution.");
        ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 5, "Unknown error during signCorpus execution.");
    }

    public void onSuccess(Bundle bundle)
    {
        bundle = bundle.getString("value_key");
        String s = InProcessAdpAuthenticationMethod.access$000(InProcessAdpAuthenticationMethod.this, val$corpus);
        if (bundle == null || s == null)
        {
            ADPCorpusSigningCallbackHelpers.callbackError(val$callbackFuture, 2, "The account is not valid or no longer registered.");
            return;
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("adp_signature", s);
            bundle1.putString("adp_token", bundle);
            val$callbackFuture.onSuccess(bundle1);
            return;
        }
    }

    ()
    {
        this$0 = final_inprocessadpauthenticationmethod;
        val$corpus = abyte0;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
