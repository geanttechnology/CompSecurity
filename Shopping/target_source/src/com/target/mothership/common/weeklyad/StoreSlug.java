// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.common.weeklyad:
//            Slug

public class StoreSlug extends Slug
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StoreSlug a(Parcel parcel)
        {
            return new StoreSlug(parcel);
        }

        public StoreSlug[] a(int i)
        {
            return new StoreSlug[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };

    public StoreSlug(Parcel parcel)
    {
        super(parcel);
    }

    public StoreSlug(String s)
    {
        super(s);
    }

}
