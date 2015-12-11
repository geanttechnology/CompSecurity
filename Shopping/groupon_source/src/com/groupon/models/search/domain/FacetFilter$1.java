// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;

// Referenced classes of package com.groupon.models.search.domain:
//            FacetFilter

static final class 
    implements android.os.ator
{

    public FacetFilter createFromParcel(Parcel parcel)
    {
        return new FacetFilter(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public FacetFilter[] newArray(int i)
    {
        return new FacetFilter[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
