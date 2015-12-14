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

private static abstract class zzs extends zzb
{

    zzo zzVC;

    public Result zzb(Status status)
    {
        return zzs(status);
    }

    public aChannelResult zzs(Status status)
    {
        return new RemoteMediaPlayer.MediaChannelResult(status) {

            final Status zzQs;
            final RemoteMediaPlayer.zzb zzVD;

            public JSONObject getCustomData()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzVD = RemoteMediaPlayer.zzb.this;
                zzQs = status;
                super();
            }
        };
    }

    _cls2.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzVC = new zzo() {

            final RemoteMediaPlayer.zzb zzVD;

            public void zza(long l, int i, Object obj)
            {
                if (obj instanceof JSONObject)
                {
                    obj = (JSONObject)obj;
                } else
                {
                    obj = null;
                }
                zzVD.zza(new RemoteMediaPlayer.zzc(new Status(i), ((JSONObject) (obj))));
            }

            public void zzy(long l)
            {
                zzVD.zza(zzVD.zzs(new Status(2103)));
            }

            
            {
                zzVD = RemoteMediaPlayer.zzb.this;
                super();
            }
        };
    }
}
