// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            NotificationItemAggObject

final class 
    implements android.os.cationItemAggObject._cls1
{

    public NotificationItemAggObject a(Parcel parcel)
    {
        return new NotificationItemAggObject(parcel, null);
    }

    public NotificationItemAggObject[] a(int i)
    {
        return new NotificationItemAggObject[i];
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
