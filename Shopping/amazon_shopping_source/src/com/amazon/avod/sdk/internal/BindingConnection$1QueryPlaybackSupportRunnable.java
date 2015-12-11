// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, BlockingBindingConnection

final class val.callback extends val.callback
{

    final BindingConnection this$0;
    final PlaybackSupportResponse val$callback;

    public void run(final AivPlaybackSdk support)
        throws RemoteException
    {
        support = com.amazon.avod.sdk.newPlaybackSupport(support.isPlaybackSupported(), support.isPlaybackSustainable());
        BindingConnection.access$200(BindingConnection.this).post(new Runnable() {

            final BindingConnection._cls1QueryPlaybackSupportRunnable this$1;
            final com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport val$support;

            public void run()
            {
                callback.onPlaybackSupport(support);
            }

            
            {
                this$1 = BindingConnection._cls1QueryPlaybackSupportRunnable.this;
                support = playbacksupport;
                super();
            }
        });
    }

    public _cls1.val.support(PlaybackSupportResponse playbacksupportresponse)
    {
        this$0 = final_bindingconnection;
        val$callback = playbacksupportresponse;
        super(BlockingBindingConnection.this, null);
    }
}
