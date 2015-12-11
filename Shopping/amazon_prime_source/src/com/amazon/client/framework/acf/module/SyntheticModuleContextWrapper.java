// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.amazon.client.framework.androidresparser.AndroidManifest;
import dalvik.system.DexClassLoader;
import java.io.IOException;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            ModuleContextWrapper, PrivateApk, IsolatingClassLoader

class SyntheticModuleContextWrapper extends ModuleContextWrapper
{

    private final LayoutInflater mInflater;
    private final PackageInfo mPackageInfo = new PackageInfo();
    private final Resources mResources;
    private final android.content.res.Resources.Theme mTheme;

    SyntheticModuleContextWrapper(Context context, PrivateApk privateapk)
        throws android.content.pm.PackageManager.NameNotFoundException, IOException
    {
        super(context, makeSyntheticClassLoader(context, privateapk));
        mPackageInfo.packageName = privateapk.manifest.getPackageName();
        PackageManager packagemanager = context.getPackageManager();
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        mPackageInfo.applicationInfo = new ApplicationInfo(applicationinfo);
        mPackageInfo.applicationInfo.packageName = mPackageInfo.packageName;
        mPackageInfo.applicationInfo.nativeLibraryDir = null;
        mPackageInfo.applicationInfo.sourceDir = privateapk.apkpath;
        mPackageInfo.applicationInfo.publicSourceDir = privateapk.apkpath;
        mPackageInfo.applicationInfo.dataDir = privateapk.datapath;
        mPackageInfo.applicationInfo.nativeLibraryDir = privateapk.nativelibpath;
        mPackageInfo.applicationInfo.metaData = privateapk.manifest.getMetaData();
        mResources = packagemanager.getResourcesForApplication(mPackageInfo.applicationInfo);
        mInflater = LayoutInflater.from(context).cloneInContext(this);
        mTheme = mResources.newTheme();
        if (mPackageInfo.applicationInfo.theme != 0)
        {
            mTheme.applyStyle(mPackageInfo.applicationInfo.theme, false);
        }
    }

    private static ClassLoader makeSyntheticClassLoader(Context context, PrivateApk privateapk)
    {
        Bundle bundle = privateapk.manifest.getMetaData();
        boolean flag = true;
        boolean flag1 = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("kuromame.Module.isolate", true);
            flag1 = bundle.getBoolean("kuromame.Module.patch", false);
        }
        if (flag1)
        {
            return context.getClassLoader();
        }
        if (flag)
        {
            return new IsolatingClassLoader(privateapk.apkpath, privateapk.dexoptpath, privateapk.nativelibpath, context.getClassLoader());
        } else
        {
            return new DexClassLoader(privateapk.apkpath, privateapk.dexoptpath, privateapk.nativelibpath, context.getClassLoader());
        }
    }

    public ApplicationInfo getApplicationInfo()
    {
        return new ApplicationInfo(mPackageInfo.applicationInfo);
    }

    public AssetManager getAssets()
    {
        return mResources.getAssets();
    }

    public String getPackageCodePath()
    {
        return mPackageInfo.applicationInfo.sourceDir;
    }

    public String getPackageName()
    {
        return mPackageInfo.packageName;
    }

    public String getPackageResourcePath()
    {
        return mPackageInfo.applicationInfo.sourceDir;
    }

    public Resources getResources()
    {
        return mResources;
    }

    public Object getSystemService(String s)
    {
        if ("layout_inflater".equals(s))
        {
            return mInflater;
        } else
        {
            return super.getSystemService(s);
        }
    }

    public android.content.res.Resources.Theme getTheme()
    {
        return mTheme;
    }
}
