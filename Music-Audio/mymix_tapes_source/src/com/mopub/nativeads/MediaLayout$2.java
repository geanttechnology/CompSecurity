// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MediaLayout

static class teState
{

    static final int $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[];
    static final int $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[];

    static 
    {
        $SwitchMap$com$mopub$nativeads$MediaLayout$Mode = new int[de.values().length];
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.IMAGE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.LOADING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.BUFFERING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.PLAYING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.PAUSED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[de.FINISHED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState = new int[teState.values().length];
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[teState.MUTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[teState.UNMUTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
