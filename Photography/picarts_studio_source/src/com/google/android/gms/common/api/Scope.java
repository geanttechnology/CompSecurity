// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.api:
//            zzc

public final class Scope
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    private final String zzaba;

    Scope(int i, String s)
    {
        zzx.zzh(s, "scopeUri must not be null or empty");
        mVersionCode = i;
        zzaba = s;
    }

    public Scope(String s)
    {
        this(1, s);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Scope))
        {
            return false;
        } else
        {
            return zzaba.equals(((Scope)obj).zzaba);
        }
    }

    public final int hashCode()
    {
        return zzaba.hashCode();
    }

    public final String toString()
    {
        return zzaba;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public final String zznG()
    {
        return zzaba;
    }

}
