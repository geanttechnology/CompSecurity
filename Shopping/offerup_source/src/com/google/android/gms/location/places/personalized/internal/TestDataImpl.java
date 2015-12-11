// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.personalized.zzf;

// Referenced classes of package com.google.android.gms.location.places.personalized.internal:
//            zza

public class TestDataImpl extends zzf
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    final int mVersionCode;
    private final String zzaIe;

    TestDataImpl(int i, String s)
    {
        mVersionCode = i;
        zzaIe = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof TestDataImpl))
        {
            return false;
        } else
        {
            obj = (TestDataImpl)obj;
            return zzaIe.equals(((TestDataImpl) (obj)).zzaIe);
        }
    }

    public int hashCode()
    {
        return zzaIe.hashCode();
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("testName", zzaIe).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public String zzxv()
    {
        return zzaIe;
    }

}
