// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzlo;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, Status, PendingResult, OptionalPendingResult, 
//            GoogleApiClient

public final class PendingResults
{

    private PendingResults()
    {
    }

    public static PendingResult canceledPendingResult()
    {
        zzlo zzlo1 = new zzlo(Looper.getMainLooper());
        zzlo1.cancel();
        return zzlo1;
    }

    public static PendingResult canceledPendingResult(Result result)
    {
        zzx.zzb(result, "Result must not be null");
        boolean flag;
        if (result.getStatus().getStatusCode() == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Status code must be CommonStatusCodes.CANCELED");
        result = new zza(result);
        result.cancel();
        return result;
    }

    public static OptionalPendingResult immediatePendingResult(Result result)
    {
        zzx.zzb(result, "Result must not be null");
        zzc zzc1 = new zzc(null);
        zzc1.zzb(result);
        return new zzln(zzc1);
    }

    public static PendingResult immediatePendingResult(Status status)
    {
        zzx.zzb(status, "Result must not be null");
        zzlo zzlo1 = new zzlo(Looper.getMainLooper());
        zzlo1.zzb(status);
        return zzlo1;
    }

    public static PendingResult zza(Result result, GoogleApiClient googleapiclient)
    {
        zzx.zzb(result, "Result must not be null");
        boolean flag;
        if (!result.getStatus().isSuccess())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Status code must not be SUCCESS");
        googleapiclient = new zzb(googleapiclient, result);
        googleapiclient.zzb(result);
        return googleapiclient;
    }

    public static PendingResult zza(Status status, GoogleApiClient googleapiclient)
    {
        zzx.zzb(status, "Result must not be null");
        googleapiclient = new zzlo(googleapiclient);
        googleapiclient.zzb(status);
        return googleapiclient;
    }

    private class zza extends zzlc
    {

        private final Result zzaaW;

        protected final Result zzb(Status status)
        {
            if (status.getStatusCode() != zzaaW.getStatus().getStatusCode())
            {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            } else
            {
                return zzaaW;
            }
        }

        public zza(Result result)
        {
            super(Looper.getMainLooper());
            zzaaW = result;
        }
    }


    private class zzc extends zzlc
    {

        protected final Result zzb(Status status)
        {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    private class zzb extends zzlc
    {

        private final Result zzaaX;

        protected final Result zzb(Status status)
        {
            return zzaaX;
        }

        public zzb(GoogleApiClient googleapiclient, Result result)
        {
            super(googleapiclient);
            zzaaX = result;
        }
    }

}
