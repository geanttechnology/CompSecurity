// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            OpenCallV2

final class 
    implements android.os.eator
{

    public OpenCallV2 a(Parcel parcel)
    {
        return new OpenCallV2(parcel);
    }

    public OpenCallV2[] a(int i)
    {
        return new OpenCallV2[i];
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
