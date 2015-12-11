// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.os.Parcel;

// Referenced classes of package com.groupon.sso:
//            UserCredential

static final class 
    implements android.os.r
{

    public UserCredential createFromParcel(Parcel parcel)
    {
        return new UserCredential(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public UserCredential[] newArray(int i)
    {
        return new UserCredential[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
