// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;

// Referenced classes of package com.target.mothership.model.weeklyad.handler:
//            TGTWeeklyAdPage

static final class 
    implements android.os.
{

    public TGTWeeklyAdPage a(Parcel parcel)
    {
        return new TGTWeeklyAdPage(parcel, null);
    }

    public TGTWeeklyAdPage[] a(int i)
    {
        return new TGTWeeklyAdPage[i];
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
