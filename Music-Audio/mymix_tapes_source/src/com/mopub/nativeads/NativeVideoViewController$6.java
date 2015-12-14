// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            NativeVideoViewController

static class deoState
{

    static final int $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[];

    static 
    {
        $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState = new int[deoState.values().length];
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.FAILED_LOAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.LOADING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.BUFFERING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.PLAYING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.PAUSED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[deoState.ENDED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
