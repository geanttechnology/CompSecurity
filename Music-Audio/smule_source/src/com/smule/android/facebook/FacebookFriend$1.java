// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.os.Parcel;

// Referenced classes of package com.smule.android.facebook:
//            FacebookFriend

final class 
    implements android.os.r
{

    public FacebookFriend a(Parcel parcel)
    {
        return new FacebookFriend(parcel);
    }

    public FacebookFriend[] a(int i)
    {
        return new FacebookFriend[i];
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
