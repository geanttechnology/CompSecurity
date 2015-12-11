// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.weekly_ad;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.weekly_ad:
//            WeeklyAdHomepageData

static final class 
    implements android.os.lyAdHomepageData._cls1
{

    public WeeklyAdHomepageData a(Parcel parcel)
    {
        return new WeeklyAdHomepageData(parcel, null);
    }

    public WeeklyAdHomepageData[] a(int i)
    {
        return new WeeklyAdHomepageData[i];
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
