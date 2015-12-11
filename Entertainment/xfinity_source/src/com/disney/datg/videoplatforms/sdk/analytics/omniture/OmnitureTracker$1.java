// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.omniture;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics.omniture:
//            OmnitureTracker

static class 
{

    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[];

    static 
    {
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow = new int[com.disney.datg.videoplatforms.sdk.media.ow.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.ow.FREE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.ow.MARKET.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.ow.SUBSCRIPTION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType = new int[com.disney.datg.videoplatforms.sdk.media.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[com.disney.datg.videoplatforms.sdk.media.VOD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[com.disney.datg.videoplatforms.sdk.media.LIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
