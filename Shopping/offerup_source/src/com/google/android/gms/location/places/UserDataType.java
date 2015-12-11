// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zzm

public final class UserDataType
    implements SafeParcelable
{

    public static final zzm CREATOR = new zzm();
    public static final UserDataType zzaGI;
    public static final UserDataType zzaGJ;
    public static final UserDataType zzaGK;
    public static final Set zzaGL;
    final int mVersionCode;
    final String zzGq;
    final int zzaGM;

    UserDataType(int i, String s, int j)
    {
        zzx.zzcr(s);
        mVersionCode = i;
        zzGq = s;
        zzaGM = j;
    }

    private static UserDataType zzy(String s, int i)
    {
        return new UserDataType(0, s, i);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof UserDataType))
            {
                return false;
            }
            obj = (UserDataType)obj;
            if (!zzGq.equals(((UserDataType) (obj)).zzGq) || zzaGM != ((UserDataType) (obj)).zzaGM)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return zzGq.hashCode();
    }

    public final String toString()
    {
        return zzGq;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    static 
    {
        zzaGI = zzy("test_type", 1);
        zzaGJ = zzy("labeled_place", 6);
        zzaGK = zzy("here_content", 7);
        zzaGL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new UserDataType[] {
            zzaGI, zzaGJ, zzaGK
        })));
    }
}
