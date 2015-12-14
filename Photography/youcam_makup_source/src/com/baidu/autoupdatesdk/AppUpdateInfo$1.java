// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.os.Parcel;

// Referenced classes of package com.baidu.autoupdatesdk:
//            AppUpdateInfo

final class 
    implements android.os.or
{

    public AppUpdateInfo a(Parcel parcel)
    {
        AppUpdateInfo appupdateinfo = new AppUpdateInfo();
        AppUpdateInfo.a(appupdateinfo, parcel.readString());
        AppUpdateInfo.b(appupdateinfo, parcel.readString());
        AppUpdateInfo.c(appupdateinfo, parcel.readString());
        AppUpdateInfo.a(appupdateinfo, parcel.readInt());
        AppUpdateInfo.d(appupdateinfo, parcel.readString());
        AppUpdateInfo.a(appupdateinfo, parcel.readLong());
        AppUpdateInfo.e(appupdateinfo, parcel.readString());
        AppUpdateInfo.b(appupdateinfo, parcel.readLong());
        AppUpdateInfo.f(appupdateinfo, parcel.readString());
        AppUpdateInfo.g(appupdateinfo, parcel.readString());
        AppUpdateInfo.h(appupdateinfo, parcel.readString());
        return appupdateinfo;
    }

    public AppUpdateInfo[] a(int i)
    {
        return null;
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
