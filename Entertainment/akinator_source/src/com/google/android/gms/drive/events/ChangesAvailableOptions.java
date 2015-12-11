// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.events:
//            zzd

public final class ChangesAvailableOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    final List zzajA;
    private final Set zzajB;
    final int zzajy;
    final boolean zzajz;

    ChangesAvailableOptions(int i, int j, boolean flag, List list)
    {
        Object obj;
        if (list == null)
        {
            obj = null;
        } else
        {
            obj = new HashSet(list);
        }
        this(i, j, flag, list, ((Set) (obj)));
    }

    private ChangesAvailableOptions(int i, int j, boolean flag, List list, Set set)
    {
        mVersionCode = i;
        zzajy = j;
        zzajz = flag;
        zzajA = list;
        zzajB = set;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        obj = (ChangesAvailableOptions)obj;
        if (!zzw.equal(zzajB, ((ChangesAvailableOptions) (obj)).zzajB) || zzajy != ((ChangesAvailableOptions) (obj)).zzajy)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzajz == ((ChangesAvailableOptions) (obj)).zzajz) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzajB, Integer.valueOf(zzajy), Boolean.valueOf(zzajz)
        });
    }

    public String toString()
    {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[] {
            Integer.valueOf(zzajy), Boolean.valueOf(zzajz), zzajA
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
