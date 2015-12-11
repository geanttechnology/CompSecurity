// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPPlayerManager

static class ayerType
{

    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[];

    static 
    {
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType = new int[ayerType.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[ayerType.VOD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[ayerType.LIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[ayerType.NATIVE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType = new int[values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[LIVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[VOD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
