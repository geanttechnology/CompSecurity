// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.list.handler:
//            TGTListDetail

static final class 
    implements android.os.or
{

    public TGTListDetail a(Parcel parcel)
    {
        return new TGTListDetail(parcel, null);
    }

    public TGTListDetail[] a(int i)
    {
        return new TGTListDetail[i];
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
