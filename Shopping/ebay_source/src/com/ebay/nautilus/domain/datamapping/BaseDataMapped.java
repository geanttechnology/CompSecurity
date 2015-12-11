// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.datamapping:
//            DataMapperFactory

public abstract class BaseDataMapped
{

    public BaseDataMapped()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DataMapperFactory.writeParcelJson(parcel, this);
    }
}
