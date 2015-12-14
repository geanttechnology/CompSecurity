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
    private final Session zzanp;
    private final DataSet zzaoD;

    SessionDataSet(int i, Session session, DataSet dataset)
    {
        mVersionCode = i;
        zzanp = session;
        zzaoD = dataset;
    }

    private boolean zza(SessionDataSet sessiondataset)
    {
        return zzw.equal(zzanp, sessiondataset.zzanp) && zzw.equal(zzaoD, sessiondataset.zzaoD);
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
        return zzanp;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanp, zzaoD
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("session", zzanp).zzg("dataSet", zzaoD).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

    public DataSet zzrO()
    {
        return zzaoD;
    }

}
