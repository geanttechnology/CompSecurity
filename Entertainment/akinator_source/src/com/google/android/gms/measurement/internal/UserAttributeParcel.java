// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzaf

public class UserAttributeParcel
    implements SafeParcelable
{

    public static final zzaf CREATOR = new zzaf();
    public final String name;
    public final int versionCode;
    public final String zzaMl;
    public final Long zzaOA;
    public final Float zzaOB;
    public final long zzaOz;
    public final String zzagS;

    UserAttributeParcel(int i, String s, long l, Long long1, Float float1, String s1, 
            String s2)
    {
        versionCode = i;
        name = s;
        zzaOz = l;
        zzaOA = long1;
        zzaOB = float1;
        zzagS = s1;
        zzaMl = s2;
    }

    UserAttributeParcel(String s, long l, Object obj, String s1)
    {
        zzx.zzcr(s);
        versionCode = 1;
        name = s;
        zzaOz = l;
        zzaMl = s1;
        if (obj == null)
        {
            zzaOA = null;
            zzaOB = null;
            zzagS = null;
            return;
        }
        if (obj instanceof Long)
        {
            zzaOA = (Long)obj;
            zzaOB = null;
            zzagS = null;
            return;
        }
        if (obj instanceof Float)
        {
            zzaOA = null;
            zzaOB = (Float)obj;
            zzagS = null;
            return;
        }
        if (obj instanceof String)
        {
            zzaOA = null;
            zzaOB = null;
            zzagS = (String)obj;
            return;
        }
        if (obj != null)
        {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        } else
        {
            zzaOA = null;
            zzaOB = null;
            zzagS = null;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Object getValue()
    {
        if (zzaOA != null)
        {
            return zzaOA;
        }
        if (zzaOB != null)
        {
            return zzaOB;
        }
        if (zzagS != null)
        {
            return zzagS;
        } else
        {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzaf.zza(this, parcel, i);
    }

}
