// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.os.Parcel;
import android.os.Parcelable;

public class AppUpdateInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

        public AppUpdateInfo[] a(int l)
        {
            return null;
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private long f;
    private String g;
    private long h;
    private String i;
    private String j;
    private String k;

    public AppUpdateInfo()
    {
    }

    public AppUpdateInfo(String s, String s1, String s2, int l, String s3, long l1, 
            String s4, long l2, String s5, String s6, String s7)
    {
        a = s;
        b = s1;
        c = s2;
        d = l;
        e = s3;
        f = l1;
        g = s4;
        h = l2;
        i = s5;
        j = s6;
        k = s7;
    }

    static int a(AppUpdateInfo appupdateinfo, int l)
    {
        appupdateinfo.d = l;
        return l;
    }

    static long a(AppUpdateInfo appupdateinfo, long l)
    {
        appupdateinfo.f = l;
        return l;
    }

    static String a(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.a = s;
        return s;
    }

    static long b(AppUpdateInfo appupdateinfo, long l)
    {
        appupdateinfo.h = l;
        return l;
    }

    static String b(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.b = s;
        return s;
    }

    static String c(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.c = s;
        return s;
    }

    static String d(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.e = s;
        return s;
    }

    static String e(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.g = s;
        return s;
    }

    static String f(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.i = s;
        return s;
    }

    static String g(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.j = s;
        return s;
    }

    static String h(AppUpdateInfo appupdateinfo, String s)
    {
        appupdateinfo.k = s;
        return s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAppChangeLog()
    {
        return j;
    }

    public String getAppIconUrl()
    {
        return i;
    }

    public String getAppMd5()
    {
        return k;
    }

    public String getAppPackage()
    {
        return c;
    }

    public String getAppPath()
    {
        return g;
    }

    public long getAppPathSize()
    {
        return h;
    }

    public long getAppSize()
    {
        return f;
    }

    public String getAppSname()
    {
        return a;
    }

    public String getAppUrl()
    {
        return e;
    }

    public int getAppVersionCode()
    {
        return d;
    }

    public String getAppVersionName()
    {
        return b;
    }

    public void setAppChangeLog(String s)
    {
        j = s;
    }

    public void setAppIconUrl(String s)
    {
        i = s;
    }

    public void setAppMd5(String s)
    {
        k = s;
    }

    public void setAppPackage(String s)
    {
        c = s;
    }

    public void setAppPath(String s)
    {
        g = s;
    }

    public void setAppPathSize(long l)
    {
        h = l;
    }

    public void setAppSize(long l)
    {
        f = l;
    }

    public void setAppSname(String s)
    {
        a = s;
    }

    public void setAppUrl(String s)
    {
        e = s;
    }

    public void setAppVersionCode(int l)
    {
        d = l;
    }

    public void setAppVersionName(String s)
    {
        b = s;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeInt(d);
        parcel.writeString(e);
        parcel.writeLong(f);
        parcel.writeString(g);
        parcel.writeLong(h);
        parcel.writeString(i);
        parcel.writeString(j);
        parcel.writeString(k);
    }

}
