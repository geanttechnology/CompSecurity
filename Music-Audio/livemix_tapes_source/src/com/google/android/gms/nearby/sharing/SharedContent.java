// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.nearby.sharing:
//            zzc, ViewableItem, LocalContent

public class SharedContent
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int versionCode;
    private String zzaKm;
    private ViewableItem zzaKn[];
    private LocalContent zzaKo[];

    private SharedContent()
    {
        versionCode = 2;
    }

    SharedContent(int i, String s, ViewableItem aviewableitem[], LocalContent alocalcontent[])
    {
        versionCode = i;
        zzaKm = s;
        zzaKn = aviewableitem;
        zzaKo = alocalcontent;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof SharedContent))
            {
                return false;
            }
            obj = (SharedContent)obj;
            if (!zzw.equal(zzaKn, ((SharedContent) (obj)).zzaKn) || !zzw.equal(zzaKo, ((SharedContent) (obj)).zzaKo) || !zzw.equal(zzaKm, ((SharedContent) (obj)).zzaKm))
            {
                return false;
            }
        }
        return true;
    }

    public String getUri()
    {
        return zzaKm;
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaKn, zzaKo, zzaKm
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("SharedContent[viewableItems=").append(Arrays.toString(zzaKn)).append(", localContents=").append(Arrays.toString(zzaKo)).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public ViewableItem[] zzyt()
    {
        return zzaKn;
    }

    public LocalContent[] zzyu()
    {
        return zzaKo;
    }

}
