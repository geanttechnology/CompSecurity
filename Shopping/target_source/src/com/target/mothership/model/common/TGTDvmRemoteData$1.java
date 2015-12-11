// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.common:
//            TGTDvmRemoteData

static final class 
    implements android.os.mmon.TGTDvmRemoteData._cls1
{

    public TGTDvmRemoteData a(Parcel parcel)
    {
        return new TGTDvmRemoteData(parcel, null);
    }

    public TGTDvmRemoteData[] a(int i)
    {
        return new TGTDvmRemoteData[i];
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
