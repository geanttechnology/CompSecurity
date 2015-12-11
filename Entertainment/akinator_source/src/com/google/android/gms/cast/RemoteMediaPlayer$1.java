// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzm;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzWS extends zzm
{

    final RemoteMediaPlayer zzWS;

    protected void onMetadataUpdated()
    {
        RemoteMediaPlayer.zzb(zzWS);
    }

    protected void onPreloadStatusUpdated()
    {
        RemoteMediaPlayer.zzd(zzWS);
    }

    protected void onQueueStatusUpdated()
    {
        RemoteMediaPlayer.zzc(zzWS);
    }

    protected void onStatusUpdated()
    {
        RemoteMediaPlayer.zza(zzWS);
    }

    (RemoteMediaPlayer remotemediaplayer, String s)
    {
        zzWS = remotemediaplayer;
        super(s);
    }
}
