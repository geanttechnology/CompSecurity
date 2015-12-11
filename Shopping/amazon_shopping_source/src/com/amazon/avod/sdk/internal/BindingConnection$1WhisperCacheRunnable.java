// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.os.RemoteException;
import com.amazon.avod.sdk.CacheLevel;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;
import java.util.List;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, BlockingBindingConnection

final class val.cacheLevel extends val.cacheLevel
{

    final BindingConnection this$0;
    final List val$asins;
    final CacheLevel val$cacheLevel;

    public void run(AivPlaybackSdk aivplaybacksdk)
        throws RemoteException
    {
        aivplaybacksdk.whisperCacheContent(val$asins, val$cacheLevel.toString());
    }

    public (CacheLevel cachelevel)
    {
        this$0 = final_bindingconnection;
        val$asins = List.this;
        val$cacheLevel = cachelevel;
        super(final_blockingbindingconnection, null);
    }
}
