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
//            zzz

public class SessionUnregistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;

    SessionUnregistrationRequest(int i, PendingIntent pendingintent, IBinder ibinder, String s)
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
    }

    public SessionUnregistrationRequest(PendingIntent pendingintent, zznh zznh1, String s)
    {
        mVersionCode = 4;
        mPendingIntent = pendingintent;
        zzapE = zznh1;
        zzOZ = s;
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
            mPendingIntent
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("pendingIntent", mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzz.zza(this, parcel, i);
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

}
