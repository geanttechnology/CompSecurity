// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.wjj.eneity.SoftApk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SoftApkManager
{
    public static interface SoftApkManagerListener
    {

        public abstract void DownCount(List list);
    }

    public static interface SoftApkManagerListener2
    {

        public abstract void DownCount(long l);
    }


    private Context context;
    private List data;
    private PackageManager pm;

    public SoftApkManager(Context context1)
    {
        context = context1;
        context1.getPackageManager();
        pm = context1.getPackageManager();
        data = new ArrayList();
    }

    public List GetAllApk(SoftApkManagerListener softapkmanagerlistener, String s)
    {
        PackageInfo packageinfo = pm.getPackageArchiveInfo(s, 1);
        SoftApk softapk = new SoftApk();
        ApplicationInfo applicationinfo = packageinfo.applicationInfo;
        applicationinfo.sourceDir = s;
        applicationinfo.publicSourceDir = s;
        softapk.apkpackname = applicationinfo.packageName;
        softapk.apkname = pm.getApplicationLabel(applicationinfo).toString();
        softapk.apkversioncode = packageinfo.versionName;
        softapk.icon = pm.getApplicationIcon(applicationinfo);
        softapk.apksize = (new File(packageinfo.applicationInfo.publicSourceDir)).length();
        data.add(softapk);
        softapkmanagerlistener.DownCount(data);
        return data;
    }

    public SoftApk GetAllApk2(SoftApkManagerListener2 softapkmanagerlistener2, String s)
    {
        PackageInfo packageinfo = pm.getPackageArchiveInfo(s, 1);
        SoftApk softapk = new SoftApk();
        ApplicationInfo applicationinfo = packageinfo.applicationInfo;
        applicationinfo.sourceDir = s;
        applicationinfo.publicSourceDir = s;
        softapk.apkpackname = applicationinfo.packageName;
        softapk.apkname = pm.getApplicationLabel(applicationinfo).toString();
        softapk.apkversioncode = packageinfo.versionName;
        softapk.icon = pm.getApplicationIcon(applicationinfo);
        softapk.apksize = (new File(packageinfo.applicationInfo.publicSourceDir)).length();
        softapkmanagerlistener2.DownCount(softapk.apksize);
        return softapk;
    }
}
