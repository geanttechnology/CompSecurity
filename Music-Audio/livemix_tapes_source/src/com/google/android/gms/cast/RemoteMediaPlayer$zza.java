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

private class zzVz
    implements zzn
{
    private final class zza
        implements ResultCallback
    {

        private final long zzVA;
        final RemoteMediaPlayer.zza zzVB;

        public void onResult(Result result)
        {
            zzr((Status)result);
        }

        public void zzr(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zzg(zzVB.zzVb).zzb(zzVA, status.getStatusCode());
            }
        }

        zza(long l)
        {
            zzVB = RemoteMediaPlayer.zza.this;
            super();
            zzVA = l;
        }
    }


    final RemoteMediaPlayer zzVb;
    private GoogleApiClient zzVy;
    private long zzVz;

    public void zza(String s, String s1, long l, String s2)
        throws IOException
    {
        if (zzVy == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            Cast.CastApi.ge(zzVy, s, s1).setResultCallback(new zza(l));
            return;
        }
    }

    public void zzb(GoogleApiClient googleapiclient)
    {
        zzVy = googleapiclient;
    }

    public long zzme()
    {
        long l = zzVz + 1L;
        zzVz = l;
        return l;
    }

    public zza.zzVA(RemoteMediaPlayer remotemediaplayer)
    {
        zzVb = remotemediaplayer;
        super();
        zzVz = 0L;
    }
}
