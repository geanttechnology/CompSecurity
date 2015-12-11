// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzz

public class SessionUnregistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzoj zzasb;

    SessionUnregistrationRequest(int i, PendingIntent pendingintent, IBinder ibinder)
    {
        mVersionCode = i;
        mPendingIntent = pendingintent;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public SessionUnregistrationRequest(PendingIntent pendingintent, zzoj zzoj1)
    {
        mVersionCode = 5;
        mPendingIntent = pendingintent;
        zzasb = zzoj1;
    }

    private boolean zzb(SessionUnregistrationRequest sessionunregistrationrequest)
    {
        return zzw.equal(mPendingIntent, sessionunregistrationrequest.mPendingIntent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest)obj);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mPendingIntent
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("pendingIntent", mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzz.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

    public PendingIntent zzta()
    {
        return mPendingIntent;
    }

}
