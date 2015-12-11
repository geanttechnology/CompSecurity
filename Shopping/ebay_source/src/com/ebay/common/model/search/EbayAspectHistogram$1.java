// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;

// Referenced classes of package com.ebay.common.model.search:
//            EbayAspectHistogram

static final class 
    implements android.os.AspectHistogram._cls1
{

    public EbayAspectHistogram createFromParcel(Parcel parcel)
    {
        return new EbayAspectHistogram(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayAspectHistogram[] newArray(int i)
    {
        return new EbayAspectHistogram[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
