// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.search:
//            EbayCategorySummary

static final class 
    implements android.os.CategorySummary._cls1
{

    public EbayCategorySummary createFromParcel(Parcel parcel)
    {
        return new EbayCategorySummary(parcel.readLong(), parcel.readString());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayCategorySummary[] newArray(int i)
    {
        return new EbayCategorySummary[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
