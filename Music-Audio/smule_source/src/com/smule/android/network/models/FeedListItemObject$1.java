// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            FeedListItemObject

final class 
    implements android.os..FeedListItemObject._cls1
{

    public FeedListItemObject a(Parcel parcel)
    {
        return new FeedListItemObject(parcel, null);
    }

    public FeedListItemObject[] a(int i)
    {
        return new FeedListItemObject[i];
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
