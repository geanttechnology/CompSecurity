// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.os.Parcel;

// Referenced classes of package com.urbanairship.location:
//            LocationRequestOptions

final class 
    implements android.os.questOptions._cls1
{

    public final LocationRequestOptions createFromParcel(Parcel parcel)
    {
        return new LocationRequestOptions(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final LocationRequestOptions[] newArray(int i)
    {
        return new LocationRequestOptions[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
