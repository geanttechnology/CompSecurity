// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static abstract class zzp extends zzb
{

    zzo zzXu;

    public Result zzb(Status status)
    {
        return zzp(status);
    }

    public aChannelResult zzp(Status status)
    {
        return new RemoteMediaPlayer.MediaChannelResult(status) {

            final Status zzVb;
            final RemoteMediaPlayer.zzb zzXv;

            public JSONObject getCustomData()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzXv = RemoteMediaPlayer.zzb.this;
                zzVb = status;
                super();
            }
        };
    }

    _cls2.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzXu = new zzo() {

            final RemoteMediaPlayer.zzb zzXv;

            public void zza(long l, int i, Object obj)
            {
                if (obj instanceof JSONObject)
                {
                    obj = (JSONObject)obj;
                } else
                {
                    obj = null;
                }
                zzXv.zzb(new RemoteMediaPlayer.zzc(new Status(i), ((JSONObject) (obj))));
            }

            public void zzy(long l)
            {
                zzXv.zzb(zzXv.zzp(new Status(2103)));
            }

            
            {
                zzXv = RemoteMediaPlayer.zzb.this;
                super();
            }
        };
    }
}
