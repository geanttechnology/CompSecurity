// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzng;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzy

public class SessionStopRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzy();
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzaoA;
    private final zzng zzaqA;

    SessionStopRequest(int i, String s, String s1, IBinder ibinder, String s2)
    {
        mVersionCode = i;
        mName = s;
        zzaoA = s1;
        if (ibinder == null)
        {
            s = null;
        } else
        {
            s = com.google.android.gms.internal.zzng.zza.zzbI(ibinder);
        }
        zzaqA = s;
        zzOZ = s2;
    }

    public SessionStopRequest(String s, String s1, zzng zzng1, String s2)
    {
        mVersionCode = 2;
        mName = s;
        zzaoA = s1;
        zzaqA = zzng1;
        zzOZ = s2;
    }

    private boolean zzb(SessionStopRequest sessionstoprequest)
    {
        return zzw.equal(mName, sessionstoprequest.mName) && zzw.equal(zzaoA, sessionstoprequest.zzaoA);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof SessionStopRequest) && zzb((SessionStopRequest)obj);
    }

    public String getIdentifier()
    {
        return zzaoA;
    }

    public String getName()
    {
        return mName;
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
            mName, zzaoA
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("name", mName).zzg("identifier", zzaoA).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzy.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaqA == null)
        {
            return null;
        } else
        {
            return zzaqA.asBinder();
        }
    }

}
