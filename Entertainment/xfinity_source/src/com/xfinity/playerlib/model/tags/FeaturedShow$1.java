// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags;

import android.os.Parcel;

// Referenced classes of package com.xfinity.playerlib.model.tags:
//            FeaturedShow

static final class 
    implements android.os.tor
{

    public FeaturedShow createFromParcel(Parcel parcel)
    {
        return new FeaturedShow(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public FeaturedShow[] newArray(int i)
    {
        return new FeaturedShow[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
