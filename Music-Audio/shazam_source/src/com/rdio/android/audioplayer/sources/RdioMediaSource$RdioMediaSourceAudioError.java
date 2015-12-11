// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.interfaces.AudioError;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            RdioMediaSource

protected static class type
    implements AudioError
{

    private final String description;
    private final com.rdio.android.audioplayer.interfaces.e type;

    public String getDescription()
    {
        return description;
    }

    public com.rdio.android.audioplayer.interfaces.cription getType()
    {
        return type;
    }

    public boolean shouldStopPlayback()
    {
        return true;
    }

    public (String s, com.rdio.android.audioplayer.interfaces. )
    {
        description = s;
        type = ;
    }
}
