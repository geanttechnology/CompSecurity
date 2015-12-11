// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.wjj.eneity.RubSoftware;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RubSoftwareManager
{
    public static interface RubSoftwareManagerListener
    {

        public abstract void DownCount(List list, long l);
    }


    private String PATH_CACHE;
    private Context context;
    private String packagename;
    private PackageManager pm;

    public RubSoftwareManager(Context context1)
    {
        PATH_CACHE = (new StringBuilder("/data/data/")).append(packagename).append("/cache").toString();
        context = context1;
        context1.getPackageManager();
        pm = context1.getPackageManager();
    }

    public static void delFile(File file)
    {
        if (!file.isDirectory()) goto _L2; else goto _L1
_L1:
        File afile[] = file.listFiles();
        if (afile == null || afile.length <= 0) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        j = afile.length;
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L2
_L2:
        file.delete();
        return;
_L4:
        delFile(afile[i]);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static long getSize(File file)
    {
        if (!file.isFile()) goto _L2; else goto _L1
_L1:
        long l = file.length();
_L4:
        return l;
_L2:
        long l1 = 0L;
        l = l1;
        if (!file.isDirectory())
        {
            continue;
        }
        file = file.listFiles();
        l = l1;
        if (file == null)
        {
            continue;
        }
        l = l1;
        if (file.length <= 0)
        {
            continue;
        }
        int j = file.length;
        int i = 0;
        do
        {
            l = l1;
            if (i >= j)
            {
                continue;
            }
            l1 += getSize(file[i]);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getApplicationInfo(RubSoftwareManagerListener rubsoftwaremanagerlistener)
    {
        Object obj = pm.getInstalledPackages(8192);
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            RubSoftware rubsoftware;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    return arraylist;
                }
                Object obj1 = (PackageInfo)((Iterator) (obj)).next();
                rubsoftware = new RubSoftware();
                rubsoftware.packnane = ((PackageInfo) (obj1)).packageName;
                rubsoftware.version = ((PackageInfo) (obj1)).versionName;
                rubsoftware.icon = ((PackageInfo) (obj1)).applicationInfo.loadIcon(pm);
                rubsoftware.softname = ((PackageInfo) (obj1)).applicationInfo.loadLabel(pm).toString();
                rubsoftware.size = (new File(((PackageInfo) (obj1)).applicationInfo.publicSourceDir)).length() / 1024L;
                if (Environment.getExternalStorageState().equals("mounted"))
                {
                    obj1 = (new StringBuilder("data/data/")).append(((PackageInfo) (obj1)).packageName).append("/cache").toString();
                    File file = new File(((String) (obj1)));
                    if (file.exists())
                    {
                        rubsoftware.cachepath = ((String) (obj1));
                        rubsoftware.allcache = getSize(file);
                    }
                }
            } while (rubsoftware.allcache <= 0L);
            rubsoftware.ischecked = true;
            arraylist.add(rubsoftware);
            rubsoftwaremanagerlistener.DownCount(arraylist, rubsoftware.allcache);
        } while (true);
    }

    public List getSysRubSoftware(RubSoftwareManagerListener rubsoftwaremanagerlistener)
    {
        Object obj = pm.getInstalledPackages(8192);
        rubsoftwaremanagerlistener = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            PackageInfo packageinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    return rubsoftwaremanagerlistener;
                }
                packageinfo = (PackageInfo)((Iterator) (obj)).next();
            } while ((packageinfo.applicationInfo.flags & 1) == 0);
            RubSoftware rubsoftware = new RubSoftware();
            rubsoftware.packnane = packageinfo.packageName;
            rubsoftware.version = packageinfo.versionName;
            rubsoftware.icon = packageinfo.applicationInfo.loadIcon(pm);
            rubsoftware.softname = packageinfo.applicationInfo.loadLabel(pm).toString();
            rubsoftwaremanagerlistener.add(rubsoftware);
        } while (true);
    }

    public List getUserRubSoftware(RubSoftwareManagerListener rubsoftwaremanagerlistener)
    {
        Object obj = pm.getInstalledPackages(8192);
        rubsoftwaremanagerlistener = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            PackageInfo packageinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    return rubsoftwaremanagerlistener;
                }
                packageinfo = (PackageInfo)((Iterator) (obj)).next();
            } while ((packageinfo.applicationInfo.flags & 1) != 0);
            RubSoftware rubsoftware = new RubSoftware();
            rubsoftware.packnane = packageinfo.packageName;
            rubsoftware.version = packageinfo.versionName;
            rubsoftware.icon = packageinfo.applicationInfo.loadIcon(pm);
            rubsoftware.softname = packageinfo.applicationInfo.loadLabel(pm).toString();
            rubsoftwaremanagerlistener.add(rubsoftware);
        } while (true);
    }
}
