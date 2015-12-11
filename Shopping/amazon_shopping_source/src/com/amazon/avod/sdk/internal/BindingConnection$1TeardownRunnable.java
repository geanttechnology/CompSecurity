// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.os.RemoteException;
import com.amazon.avod.sdk.ResponseHandler;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, BlockingBindingConnection

final class  extends 
{

    final BindingConnection this$0;
    final ResponseHandler val$handler;

    public void run(AivPlaybackSdk aivplaybacksdk)
        throws RemoteException
    {
        aivplaybacksdk.teardownPreparedVideo();
        BindingConnection.access$400(BindingConnection.this, val$handler);
    }

    public (ResponseHandler responsehandler)
    {
        this$0 = final_bindingconnection;
        val$handler = responsehandler;
        super(BlockingBindingConnection.this, null);
    }
}
