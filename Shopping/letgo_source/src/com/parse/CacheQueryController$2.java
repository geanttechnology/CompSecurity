// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            CacheQueryController, NetworkQueryController

class val.cancellationToken
    implements mmandDelegate
{

    final CacheQueryController this$0;
    final cu val$cancellationToken;
    final String val$sessionToken;
    final val.cancellationToken val$state;

    public cu runFromCacheAsync()
    {
        return CacheQueryController.access$200(CacheQueryController.this, val$state, val$sessionToken);
    }

    public cu runOnNetworkAsync(boolean flag)
    {
        return CacheQueryController.access$000(CacheQueryController.this).countAsync(val$state, val$sessionToken, flag, val$cancellationToken);
    }

    mmandDelegate()
    {
        this$0 = final_cachequerycontroller;
        val$state = mmanddelegate;
        val$sessionToken = s;
        val$cancellationToken = cu.this;
        super();
    }
}
