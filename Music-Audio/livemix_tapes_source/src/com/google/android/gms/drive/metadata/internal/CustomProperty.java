// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzc

public class CustomProperty
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final String mValue;
    final int mVersionCode;
    final CustomPropertyKey zzakk;

    CustomProperty(int i, CustomPropertyKey custompropertykey, String s)
    {
        mVersionCode = i;
        zzx.zzb(custompropertykey, "key");
        zzakk = custompropertykey;
        mValue = s;
    }

    public CustomProperty(CustomPropertyKey custompropertykey, String s)
    {
        this(1, custompropertykey, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getValue()
    {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public CustomPropertyKey zzqZ()
    {
        return zzakk;
    }

}
