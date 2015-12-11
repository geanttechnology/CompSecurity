// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral.util;

import android.os.Parcel;

// Referenced classes of package io.branch.referral.util:
//            LinkProperties

static final class 
    implements android.os.r
{

    public LinkProperties createFromParcel(Parcel parcel)
    {
        return new LinkProperties(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LinkProperties[] newArray(int i)
    {
        return new LinkProperties[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
