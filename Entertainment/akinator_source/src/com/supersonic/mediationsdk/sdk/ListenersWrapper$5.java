// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;


// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            ListenersWrapper, RewardedVideoListener

class val.available
    implements Runnable
{

    final ListenersWrapper this$0;
    final boolean val$available;

    public void run()
    {
        ListenersWrapper.access$100(ListenersWrapper.this).onVideoAvailabilityChanged(val$available);
    }

    er()
    {
        this$0 = final_listenerswrapper;
        val$available = Z.this;
        super();
    }
}
