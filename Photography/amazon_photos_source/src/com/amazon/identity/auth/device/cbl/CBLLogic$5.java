// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.storage.LocalKeyValueStore;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            CBLLogic

static final class ckFuture extends CallbackFuture
{

    final CallbackFuture val$callback;
    final Context val$context;

    public void onError(Bundle bundle)
    {
        MAPLog.i(CBLLogic.access$500(), "Register with link code was not successful.");
        val$callback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(CBLLogic.access$500(), "Register with link code was successful. Clearing the cbl data in MAP");
        (new LocalKeyValueStore(val$context, "cbl_storage")).clearStore();
        val$callback.onSuccess(bundle);
    }

    ckFuture(Context context1, CallbackFuture callbackfuture)
    {
        val$context = context1;
        val$callback = callbackfuture;
        super();
    }
}
