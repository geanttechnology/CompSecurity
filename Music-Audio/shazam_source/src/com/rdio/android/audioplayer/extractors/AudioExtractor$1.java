// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AudioExtractor

static class us
{

    static final int $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[];

    static 
    {
        $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus = new int[com.rdio.android.audioplayer.sources.tatus.values().length];
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.tatus.Cancelled.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.tatus.TimedOut.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.tatus.Success.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
