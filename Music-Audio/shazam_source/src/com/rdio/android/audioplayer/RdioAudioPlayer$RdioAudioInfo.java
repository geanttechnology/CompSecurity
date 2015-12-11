// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import com.rdio.android.audioplayer.interfaces.AudioInfo;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

private static class Detail.toString
    implements AudioInfo
{

    private String description;
    private com.rdio.android.audioplayer.interfaces. detail;

    public String getDescription()
    {
        return description;
    }

    public com.rdio.android.audioplayer.interfaces. getDetail()
    {
        return detail;
    }

    public Detail(com.rdio.android.audioplayer.interfaces. )
    {
        detail = ;
        description = String.format("RdioAudioInfo: Detail=%s", new Object[] {
            .ring()
        });
    }
}
