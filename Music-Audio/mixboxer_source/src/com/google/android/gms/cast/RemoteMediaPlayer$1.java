// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.dl;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class lh extends dl
{

    final RemoteMediaPlayer lh;

    protected void onMetadataUpdated()
    {
        RemoteMediaPlayer.b(lh);
    }

    protected void onStatusUpdated()
    {
        RemoteMediaPlayer.a(lh);
    }

    (RemoteMediaPlayer remotemediaplayer)
    {
        lh = remotemediaplayer;
        super();
    }
}
