// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            zzb

public class HereContent
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    final int mVersionCode;
    private final String zzaHW;
    private final List zzaHX;

    HereContent(int i, String s, List list)
    {
        mVersionCode = i;
        zzaHW = s;
        zzaHX = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof HereContent))
            {
                return false;
            }
            obj = (HereContent)obj;
            if (!zzw.equal(zzaHW, ((HereContent) (obj)).zzaHW) || !zzw.equal(zzaHX, ((HereContent) (obj)).zzaHX))
            {
                return false;
            }
        }
        return true;
    }

    public List getActions()
    {
        return zzaHX;
    }

    public String getData()
    {
        return zzaHW;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaHW, zzaHX
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("data", zzaHW).zzg("actions", zzaHX).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
