// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTPickUpStoreAddress

static final class 
    implements android.os.TGTPickUpStoreAddress._cls1
{

    public TGTPickUpStoreAddress a(Parcel parcel)
    {
        return new TGTPickUpStoreAddress(parcel, null);
    }

    public TGTPickUpStoreAddress[] a(int i)
    {
        return new TGTPickUpStoreAddress[i];
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
