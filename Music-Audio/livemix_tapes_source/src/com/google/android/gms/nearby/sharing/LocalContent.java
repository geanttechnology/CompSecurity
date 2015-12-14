// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.nearby.sharing:
//            zzb

public class LocalContent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private int type;
    private final int versionCode;
    private String zzaKl;

    private LocalContent()
    {
        versionCode = 1;
    }

    LocalContent(int i, int j, String s)
    {
        versionCode = i;
        type = j;
        zzaKl = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof LocalContent))
            {
                return false;
            }
            obj = (LocalContent)obj;
            if (!zzw.equal(Integer.valueOf(type), Integer.valueOf(((LocalContent) (obj)).type)) || !zzw.equal(zzaKl, ((LocalContent) (obj)).zzaKl))
            {
                return false;
            }
        }
        return true;
    }

    public int getType()
    {
        return type;
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(type), zzaKl
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("LocalContent[contentUri=").append(zzaKl).append(", type=");
        String s;
        if (type == 1)
        {
            s = "PUBLIC_CONTENT";
        } else
        {
            s = "APP_CONTENT";
        }
        return stringbuilder.append(s).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public String zzys()
    {
        return zzaKl;
    }

}
