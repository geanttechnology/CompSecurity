// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            AdViewController

static class son
{

    static final int $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[];

    static 
    {
        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = new int[com.mopub.network.eason.values().length];
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.eason.WARMING_UP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.eason.NO_FILL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
