// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;

// Referenced classes of package com.pointinside.products:
//            CustomerData

static final class 
    implements android.os.tor
{

    public CustomerData createFromParcel(Parcel parcel)
    {
        java.util.ArrayList arraylist;
        if (parcel.readByte() == 0)
        {
            arraylist = parcel.createStringArrayList();
        } else
        {
            arraylist = null;
        }
        if (parcel.readByte() == 0)
        {
            parcel = parcel.createStringArrayList();
        } else
        {
            parcel = null;
        }
        return new CustomerData(arraylist, parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CustomerData[] newArray(int i)
    {
        return new CustomerData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
