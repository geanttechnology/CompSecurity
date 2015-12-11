// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            TaskInfo

public class TaskInfoProvider
{

    private ActivityManager activityManager;
    private Drawable defaultIcon;
    private PackageManager packageManager;

    public TaskInfoProvider(Context context)
    {
        defaultIcon = context.getResources().getDrawable(0x7f0200eb);
        packageManager = context.getPackageManager();
        activityManager = (ActivityManager)context.getSystemService("activity");
    }

    public boolean filterApp(ApplicationInfo applicationinfo)
    {
        while ((applicationinfo.flags & 0x80) != 0 || (applicationinfo.flags & 1) == 0) 
        {
            return true;
        }
        return false;
    }

    public List getAllTask(List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        TaskInfo taskinfo;
        Object obj;
        int i;
        if (!list.hasNext())
        {
            return arraylist;
        }
        obj = (android.app.ActivityManager.RunningAppProcessInfo)list.next();
        taskinfo = new TaskInfo();
        i = ((android.app.ActivityManager.RunningAppProcessInfo) (obj)).pid;
        taskinfo.setId(i);
        obj = ((android.app.ActivityManager.RunningAppProcessInfo) (obj)).processName;
        taskinfo.setPackageName(((String) (obj)));
        ApplicationInfo applicationinfo;
        applicationinfo = packageManager.getPackageInfo(((String) (obj)), 0).applicationInfo;
        taskinfo.setIcon(applicationinfo.loadIcon(packageManager));
        taskinfo.setName(applicationinfo.loadLabel(packageManager).toString());
        boolean flag;
        if (filterApp(applicationinfo))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        try
        {
            taskinfo.setSystemProcess(flag);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            taskinfo.setName(((String) (obj)));
            taskinfo.setSystemProcess(true);
            taskinfo.setIcon(defaultIcon);
        }
        taskinfo.setMemory(activityManager.getProcessMemoryInfo(new int[] {
            i
        })[0].getTotalPrivateDirty());
        arraylist.add(taskinfo);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
