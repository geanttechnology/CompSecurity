// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.os.Parcel;

// Referenced classes of package com.cyberlink.you.friends:
//            UserInfo

final class 
    implements android.os.Creator
{

    public UserInfo a(Parcel parcel)
    {
        return new UserInfo(parcel);
    }

    public UserInfo[] a(int i)
    {
        return new UserInfo[i];
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
