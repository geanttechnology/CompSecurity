// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;

// Referenced classes of package co.vine.android.api:
//            VineMilestone

static final class 
    implements android.os.or
{

    public VineMilestone createFromParcel(Parcel parcel)
    {
        return new VineMilestone(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VineMilestone[] newArray(int i)
    {
        return new VineMilestone[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
