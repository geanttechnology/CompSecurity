// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.Filter;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            AbstractFilter, zzm, FilterHolder, zzf

public class NotFilter extends AbstractFilter
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    final FilterHolder zzaol;

    NotFilter(int i, FilterHolder filterholder)
    {
        mVersionCode = i;
        zzaol = filterholder;
    }

    public NotFilter(Filter filter)
    {
        this(1, new FilterHolder(filter));
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    public Object zza(zzf zzf1)
    {
        return zzf1.zzx(zzaol.getFilter().zza(zzf1));
    }

}
