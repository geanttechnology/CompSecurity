// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzq, Session, DataSet

public class SessionDataSet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzq();
    final int mVersionCode;
    private final Session zzapP;
    private final DataSet zzarb;

    SessionDataSet(int i, Session session, DataSet dataset)
    {
        mVersionCode = i;
        zzapP = session;
        zzarb = dataset;
    }

    private boolean zza(SessionDataSet sessiondataset)
    {
        return zzw.equal(zzapP, sessiondataset.zzapP) && zzw.equal(zzarb, sessiondataset.zzarb);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof SessionDataSet) && zza((SessionDataSet)obj);
    }

    public Session getSession()
    {
        return zzapP;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapP, zzarb
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("session", zzapP).zzg("dataSet", zzarb).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

    public DataSet zzsA()
    {
        return zzarb;
    }

}
