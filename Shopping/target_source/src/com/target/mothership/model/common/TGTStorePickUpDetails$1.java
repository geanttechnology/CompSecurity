// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTStorePickUpDetails

static final class 
    implements android.os.TGTStorePickUpDetails._cls1
{

    public TGTStorePickUpDetails a(Parcel parcel)
    {
        return new TGTStorePickUpDetails(parcel, null);
    }

    public TGTStorePickUpDetails[] a(int i)
    {
        return new TGTStorePickUpDetails[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
