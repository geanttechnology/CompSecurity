// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzm;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzVb extends zzm
{

    final RemoteMediaPlayer zzVb;

    protected void onMetadataUpdated()
    {
        RemoteMediaPlayer.zzb(zzVb);
    }

    protected void onPreloadStatusUpdated()
    {
        RemoteMediaPlayer.zzd(zzVb);
    }

    protected void onQueueStatusUpdated()
    {
        RemoteMediaPlayer.zzc(zzVb);
    }

    protected void onStatusUpdated()
    {
        RemoteMediaPlayer.zza(zzVb);
    }

    (RemoteMediaPlayer remotemediaplayer, String s)
    {
        zzVb = remotemediaplayer;
        super(s);
    }
}
