// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznc;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzp

public class ListSubscriptionsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final zznc zzaqe;

    ListSubscriptionsRequest(int i, DataType datatype, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzanl = datatype;
        if (ibinder == null)
        {
            datatype = null;
        } else
        {
            datatype = com.google.android.gms.internal.zznc.zza.zzbE(ibinder);
        }
        zzaqe = datatype;
        zzOZ = s;
    }

    public ListSubscriptionsRequest(DataType datatype, zznc zznc1, String s)
    {
        mVersionCode = 2;
        zzanl = datatype;
        zzaqe = zznc1;
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaqe == null)
        {
            return null;
        } else
        {
            return zzaqe.asBinder();
        }
    }

}
