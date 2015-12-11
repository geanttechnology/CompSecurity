// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;


// Referenced classes of package com.rdio.android.audioplayer.io:
//            UriAudioStream

static class SeekOrigin
{

    static final int $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[];

    static 
    {
        $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin = new int[com.rdio.android.audioplayer.sources.rigin.values().length];
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.rigin.Current.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.rigin.Begin.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.rigin.End.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
