// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzz, zzp

public class ResolveAccountResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzz();
    final int mVersionCode;
    private boolean zzabG;
    IBinder zzaeH;
    private ConnectionResult zzagq;
    private boolean zzagr;

    public ResolveAccountResponse(int i)
    {
        this(new ConnectionResult(i, null));
    }

    ResolveAccountResponse(int i, IBinder ibinder, ConnectionResult connectionresult, boolean flag, boolean flag1)
    {
        mVersionCode = i;
        zzaeH = ibinder;
        zzagq = connectionresult;
        zzabG = flag;
        zzagr = flag1;
    }

    public ResolveAccountResponse(ConnectionResult connectionresult)
    {
        this(1, null, connectionresult, false, false);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ResolveAccountResponse))
            {
                return false;
            }
            obj = (ResolveAccountResponse)obj;
            if (!zzagq.equals(((ResolveAccountResponse) (obj)).zzagq) || !zzpq().equals(((ResolveAccountResponse) (obj)).zzpq()))
            {
                return false;
            }
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzz.zza(this, parcel, i);
    }

    public zzp zzpq()
    {
        return zzp.zza.zzaH(zzaeH);
    }

    public ConnectionResult zzpr()
    {
        return zzagq;
    }

    public boolean zzps()
    {
        return zzabG;
    }

    public boolean zzpt()
    {
        return zzagr;
    }

}
