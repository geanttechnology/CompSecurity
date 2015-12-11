// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, PlaybackEventResponseDelegate, BlockingBindingConnection

final class val.bundle extends val.bundle
{

    final BindingConnection this$0;
    final String val$asin;
    final Bundle val$bundle;

    public void run(AivPlaybackSdk aivplaybacksdk)
        throws RemoteException
    {
        PlaybackEventResponseDelegate playbackeventresponsedelegate = new PlaybackEventResponseDelegate(BindingConnection.access$300(BindingConnection.this));
        aivplaybacksdk.startPlayback(val$asin, val$bundle, playbackeventresponsedelegate);
    }

    public (Bundle bundle1)
    {
        this$0 = final_bindingconnection;
        val$asin = String.this;
        val$bundle = bundle1;
        super(final_blockingbindingconnection, null);
    }
}
