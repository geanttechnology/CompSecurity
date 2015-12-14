// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzw

public class SessionRegistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.fitness.request.zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final int zzaqz;

    SessionRegistrationRequest(int i, PendingIntent pendingintent, IBinder ibinder, String s, int j)
    {
        mVersionCode = i;
        mPendingIntent = pendingintent;
        if (ibinder == null)
        {
            pendingintent = null;
        } else
        {
            pendingintent = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = pendingintent;
        zzOZ = s;
        zzaqz = j;
    }

    public SessionRegistrationRequest(PendingIntent pendingintent, zznh zznh1, String s, int i)
    {
        mVersionCode = 5;
        mPendingIntent = pendingintent;
        zzapE = zznh1;
        zzOZ = s;
        zzaqz = i;
    }

    private boolean zzb(SessionRegistrationRequest sessionregistrationrequest)
    {
        return zzaqz == sessionregistrationrequest.zzaqz && zzw.equal(mPendingIntent, sessionregistrationrequest.mPendingIntent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest)obj);
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mPendingIntent, Integer.valueOf(zzaqz)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("pendingIntent", mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(zzaqz)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzw.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

    public PendingIntent zzso()
    {
        return mPendingIntent;
    }

    public int zzsx()
    {
        return zzaqz;
    }

}
