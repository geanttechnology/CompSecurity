// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzof;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzq

public class ReadRawRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzq();
    private final int mVersionCode;
    private final zzof zzasC;
    private final List zzasD;
    private final boolean zzasn;
    private final boolean zzaso;

    ReadRawRequest(int i, IBinder ibinder, List list, boolean flag, boolean flag1)
    {
        mVersionCode = i;
        zzasC = com.google.android.gms.internal.zzof.zza.zzbF(ibinder);
        zzasD = list;
        zzasn = flag;
        zzaso = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasC != null)
        {
            return zzasC.asBinder();
        } else
        {
            return null;
        }
    }

    public boolean zzsT()
    {
        return zzaso;
    }

    public boolean zzsU()
    {
        return zzasn;
    }

    public List zzsZ()
    {
        return zzasD;
    }

}
