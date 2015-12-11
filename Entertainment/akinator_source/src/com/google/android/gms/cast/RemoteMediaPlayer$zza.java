// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer, Cast

private class zzXr
    implements zzn
{
    private final class zza
        implements ResultCallback
    {

        private final long zzXs;
        final RemoteMediaPlayer.zza zzXt;

        public void onResult(Result result)
        {
            zzo((Status)result);
        }

        public void zzo(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zzg(zzXt.zzWS).zzb(zzXs, status.getStatusCode());
            }
        }

        zza(long l)
        {
            zzXt = RemoteMediaPlayer.zza.this;
            super();
            zzXs = l;
        }
    }


    final RemoteMediaPlayer zzWS;
    private GoogleApiClient zzXq;
    private long zzXr;

    public void zza(GoogleApiClient googleapiclient)
    {
        zzXq = googleapiclient;
    }

    public void zza(String s, String s1, long l, String s2)
        throws IOException
    {
        if (zzXq == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            Cast.CastApi.ge(zzXq, s, s1).setResultCallback(new zza(l));
            return;
        }
    }

    public long zzmA()
    {
        long l = zzXr + 1L;
        zzXr = l;
        return l;
    }

    public zza.zzXs(RemoteMediaPlayer remotemediaplayer)
    {
        zzWS = remotemediaplayer;
        super();
        zzXr = 0L;
    }
}
