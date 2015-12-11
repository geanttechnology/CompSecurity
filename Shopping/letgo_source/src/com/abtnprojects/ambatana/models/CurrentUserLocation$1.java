// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            CurrentUserLocation

static final class 
    implements android.os.CurrentUserLocation._cls1
{

    public CurrentUserLocation createFromParcel(Parcel parcel)
    {
        return new CurrentUserLocation(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CurrentUserLocation[] newArray(int i)
    {
        return new CurrentUserLocation[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
