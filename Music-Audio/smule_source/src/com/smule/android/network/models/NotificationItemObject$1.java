// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            NotificationItemObject

final class 
    implements android.os.ificationItemObject._cls1
{

    public NotificationItemObject a(Parcel parcel)
    {
        return new NotificationItemObject(parcel, null);
    }

    public NotificationItemObject[] a(int i)
    {
        return new NotificationItemObject[i];
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
