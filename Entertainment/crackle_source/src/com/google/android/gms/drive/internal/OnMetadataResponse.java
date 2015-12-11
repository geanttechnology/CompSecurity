// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            v

public class OnMetadataResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new v();
    final int kg;
    final MetadataBundle qZ;

    OnMetadataResponse(int i, MetadataBundle metadatabundle)
    {
        kg = i;
        qZ = metadatabundle;
    }

    public MetadataBundle cU()
    {
        return qZ;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        v.a(this, parcel, i);
    }

}
