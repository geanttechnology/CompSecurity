// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzae

public class UnsubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzae();
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final zznh zzapE;

    UnsubscribeRequest(int i, DataType datatype, DataSource datasource, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzanl = datatype;
        zzanm = datasource;
        if (ibinder == null)
        {
            datatype = null;
        } else
        {
            datatype = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = datatype;
        zzOZ = s;
    }

    public UnsubscribeRequest(DataType datatype, DataSource datasource, zznh zznh1, String s)
    {
        mVersionCode = 2;
        zzanl = datatype;
        zzanm = datasource;
        zzapE = zznh1;
        zzOZ = s;
    }

    private boolean zzb(UnsubscribeRequest unsubscriberequest)
    {
        return zzw.equal(zzanm, unsubscriberequest.zzanm) && zzw.equal(zzanl, unsubscriberequest.zzanl);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest)obj);
    }

    public DataSource getDataSource()
    {
        return zzanm;
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

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, zzanl
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzae.zza(this, parcel, i);
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

}
