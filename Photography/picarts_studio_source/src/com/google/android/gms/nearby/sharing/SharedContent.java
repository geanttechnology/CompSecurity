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
    private String zzaRm;
    private ViewableItem zzaRn[];
    private LocalContent zzaRo[];

    private SharedContent()
    {
        versionCode = 2;
    }

    SharedContent(int i, String s, ViewableItem aviewableitem[], LocalContent alocalcontent[])
    {
        versionCode = i;
        zzaRm = s;
        zzaRn = aviewableitem;
        zzaRo = alocalcontent;
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
            if (!zzw.equal(zzaRn, ((SharedContent) (obj)).zzaRn) || !zzw.equal(zzaRo, ((SharedContent) (obj)).zzaRo) || !zzw.equal(zzaRm, ((SharedContent) (obj)).zzaRm))
            {
                return false;
            }
        }
        return true;
    }

    public String getUri()
    {
        return zzaRm;
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaRn, zzaRo, zzaRm
        });
    }

    public String toString()
    {
        return (new StringBuilder("SharedContent[viewableItems=")).append(Arrays.toString(zzaRn)).append(", localContents=").append(Arrays.toString(zzaRo)).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public ViewableItem[] zzBk()
    {
        return zzaRn;
    }

    public LocalContent[] zzBl()
    {
        return zzaRo;
    }

}
