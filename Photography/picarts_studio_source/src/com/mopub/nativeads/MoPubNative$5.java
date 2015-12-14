// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubNative

class r.Reason
{

    static final int $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[];

    static 
    {
        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = new int[com.mopub.network.ror.Reason.values().length];
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.ror.Reason.BAD_BODY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.ror.Reason.BAD_HEADER_DATA.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.ror.Reason.WARMING_UP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.ror.Reason.NO_FILL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.ror.Reason.UNSPECIFIED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
