// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;

// Referenced classes of package com.gau.go.launcherex.gowidget.weather.model:
//            ThemeDataBean

final class w
    implements android.os.Parcelable.Creator
{

    w()
    {
    }

    public ThemeDataBean a(Parcel parcel)
    {
        return new ThemeDataBean(parcel, null);
    }

    public ThemeDataBean[] a(int i)
    {
        return new ThemeDataBean[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
