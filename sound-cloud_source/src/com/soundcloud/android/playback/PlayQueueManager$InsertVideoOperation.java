// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.playback;

import com.soundcloud.java.collections.PropertySet;

// Referenced classes of package com.soundcloud.android.playback:
//            PlayQueueManager, PlayQueue

public static class metaData
    implements metaData
{

    private final PropertySet metaData;
    private final int position;

    public void execute(PlayQueue playqueue)
    {
        playqueue.insertVideo(position, metaData);
    }

    public (int i, PropertySet propertyset)
    {
        position = i;
        metaData = propertyset;
    }
}
