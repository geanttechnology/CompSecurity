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
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.drive:
//            zzh

public class DriveSpace
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    public static final DriveSpace zzaiR;
    public static final DriveSpace zzaiS;
    public static final DriveSpace zzaiT;
    public static final Set zzaiU;
    public static final String zzaiV;
    private static final Pattern zzaiW = Pattern.compile("[A-Z0-9_]*");
    private final String mName;
    final int mVersionCode;

    DriveSpace(int i, String s)
    {
        mVersionCode = i;
        mName = (String)zzx.zzw(s);
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
        zzh.zza(this, parcel, i);
    }

    static 
    {
        zzaiR = new DriveSpace("DRIVE");
        zzaiS = new DriveSpace("APP_DATA_FOLDER");
        zzaiT = new DriveSpace("PHOTOS");
        zzaiU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[] {
            zzaiR, zzaiS, zzaiT
        })));
        zzaiV = TextUtils.join(",", zzaiU.toArray());
    }
}
