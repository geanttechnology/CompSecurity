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
//            zzw

public class SessionRegistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.fitness.request.zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzasW;
    private final zzoj zzasb;

    SessionRegistrationRequest(int i, PendingIntent pendingintent, IBinder ibinder, int j)
    {
        mVersionCode = i;
        mPendingIntent = pendingintent;
        if (ibinder == null)
        {
            pendingintent = null;
        } else
        {
            pendingintent = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
        }
        zzasb = pendingintent;
        zzasW = j;
    }

    public SessionRegistrationRequest(PendingIntent pendingintent, zzoj zzoj1, int i)
    {
        mVersionCode = 6;
        mPendingIntent = pendingintent;
        zzasb = zzoj1;
        zzasW = i;
    }

    private boolean zzb(SessionRegistrationRequest sessionregistrationrequest)
    {
        return zzasW == sessionregistrationrequest.zzasW && zzw.equal(mPendingIntent, sessionregistrationrequest.mPendingIntent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest)obj);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mPendingIntent, Integer.valueOf(zzasW)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("pendingIntent", mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(zzasW)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzw.zza(this, parcel, i);
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

    public int zztj()
    {
        return zzasW;
    }

}
