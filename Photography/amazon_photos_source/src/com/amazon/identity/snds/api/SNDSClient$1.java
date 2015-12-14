// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.snds.api:
//            SyncBoundServiceCaller, SNDSClient, IIsAccountLinked, ReturnValueOrError

class iceCaller extends SyncBoundServiceCaller
{

    final SNDSClient this$0;
    final String val$directedId;
    final AtomicReference val$isAccountLinkedResponse;
    final .SocialNetworkType val$type;

    protected void useService(IBinder ibinder)
    {
        Log.d(SNDSClient.access$000(), "IsSocialNetworkAccountLinked  useService called");
        ibinder = ked.Stub.asInterface(ibinder);
        int i = val$type.value();
        try
        {
            ibinder = ibinder.isAccountLinked(val$directedId, i);
            val$isAccountLinkedResponse.set(ibinder.getResponse());
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.e(SNDSClient.access$000(), "Remote exception during isAccountLinked call", ibinder);
        }
        doneUsingService();
    }

    e(.SocialNetworkType socialnetworktype, String s, AtomicReference atomicreference)
    {
        this$0 = final_sndsclient;
        val$type = socialnetworktype;
        val$directedId = s;
        val$isAccountLinkedResponse = atomicreference;
        super(final_context, final_intent, I.this);
    }
}
