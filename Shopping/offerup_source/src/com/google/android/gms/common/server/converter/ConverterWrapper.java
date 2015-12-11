// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.server.converter:
//            zza, StringToIntConverter

public class ConverterWrapper
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zzagO;

    ConverterWrapper(int i, StringToIntConverter stringtointconverter)
    {
        mVersionCode = i;
        zzagO = stringtointconverter;
    }

    private ConverterWrapper(StringToIntConverter stringtointconverter)
    {
        mVersionCode = 1;
        zzagO = stringtointconverter;
    }

    public static ConverterWrapper zza(com.google.android.gms.common.server.response.FastJsonResponse.zza zza1)
    {
        if (zza1 instanceof StringToIntConverter)
        {
            return new ConverterWrapper((StringToIntConverter)zza1);
        } else
        {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.server.converter.zza.zza(this, parcel, i);
    }

    StringToIntConverter zzpy()
    {
        return zzagO;
    }

    public com.google.android.gms.common.server.response.FastJsonResponse.zza zzpz()
    {
        if (zzagO != null)
        {
            return zzagO;
        } else
        {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
    }

}
