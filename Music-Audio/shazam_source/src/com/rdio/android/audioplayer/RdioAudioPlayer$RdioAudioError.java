// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.interfaces.AudioError;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

private static class shouldStopPlayback
    implements AudioError
{

    private String description;
    private com.rdio.android.audioplayer.interfaces.layback info;
    private boolean shouldStopPlayback;

    public String getDescription()
    {
        return description;
    }

    public com.rdio.android.audioplayer.interfaces. getType()
    {
        return info;
    }

    public boolean shouldStopPlayback()
    {
        return shouldStopPlayback;
    }

    public (Exception exception, com.rdio.android.audioplayer.interfaces. , boolean flag)
    {
        description = exception.getMessage();
        info = ;
        shouldStopPlayback = flag;
    }

    public (String s, com.rdio.android.audioplayer.interfaces.layback layback, boolean flag)
    {
        description = s;
        info = layback;
        shouldStopPlayback = flag;
    }
}
