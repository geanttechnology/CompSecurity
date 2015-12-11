// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzoi;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzy

public class SessionStopRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzy();
    private final String mName;
    private final int mVersionCode;
    private final String zzaqY;
    private final zzoi zzasX;

    SessionStopRequest(int i, String s, String s1, IBinder ibinder)
    {
        mVersionCode = i;
        mName = s;
        zzaqY = s1;
        zzasX = com.google.android.gms.internal.zzoi.zza.zzbI(ibinder);
    }

    public SessionStopRequest(String s, String s1, zzoi zzoi1)
    {
        mVersionCode = 3;
        mName = s;
        zzaqY = s1;
        zzasX = zzoi1;
    }

    private boolean zzb(SessionStopRequest sessionstoprequest)
    {
        return zzw.equal(mName, sessionstoprequest.mName) && zzw.equal(zzaqY, sessionstoprequest.zzaqY);
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
        return zzaqY;
    }

    public String getName()
    {
        return mName;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mName, zzaqY
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("name", mName).zzg("identifier", zzaqY).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzy.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasX == null)
        {
            return null;
        } else
        {
            return zzasX.asBinder();
        }
    }

}
