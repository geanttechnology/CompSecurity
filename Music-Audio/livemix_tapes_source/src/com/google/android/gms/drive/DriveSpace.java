// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive:
//            zzg

public class DriveSpace
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    public static final DriveSpace zzagH;
    public static final DriveSpace zzagI;
    public static final DriveSpace zzagJ;
    public static final Set zzagK;
    public static final String zzagL;
    private final String mName;
    final int mVersionCode;

    DriveSpace(int i, String s)
    {
        mVersionCode = i;
        mName = (String)zzx.zzv(s);
    }

    private DriveSpace(String s)
    {
        this(1, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != com/google/android/gms/drive/DriveSpace)
        {
            return false;
        } else
        {
            return mName.equals(((DriveSpace)obj).mName);
        }
    }

    public String getName()
    {
        return mName;
    }

    public int hashCode()
    {
        return 0x4a54c0de ^ mName.hashCode();
    }

    public String toString()
    {
        return mName;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

    static 
    {
        zzagH = new DriveSpace("DRIVE");
        zzagI = new DriveSpace("APP_DATA_FOLDER");
        zzagJ = new DriveSpace("PHOTOS");
        zzagK = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[] {
            zzagH, zzagI, zzagJ
        })));
        zzagL = TextUtils.join(",", zzagK.toArray());
    }
}
