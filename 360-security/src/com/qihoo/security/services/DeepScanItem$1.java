// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.qihoo.security.services;

import android.os.Parcel;

// Referenced classes of package com.qihoo.security.services:
//            DeepScanItem

class 
    implements android.os.tor
{

    public DeepScanItem a(Parcel parcel)
    {
        return new DeepScanItem(parcel);
    }

    public DeepScanItem[] a(int i)
    {
        return new DeepScanItem[i];
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
