// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.page_item.handler:
//            TGTWeeklyAdInfo

static final class 
    implements android.os.
{

    public TGTWeeklyAdInfo a(Parcel parcel)
    {
        return new TGTWeeklyAdInfo(parcel, null);
    }

    public TGTWeeklyAdInfo[] a(int i)
    {
        return new TGTWeeklyAdInfo[i];
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
