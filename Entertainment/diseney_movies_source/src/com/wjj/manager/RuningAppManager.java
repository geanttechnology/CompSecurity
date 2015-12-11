// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.wjj.eneity.RuningApp;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuningAppManager
{
    public static interface RuningAppManagerListener
    {

        public abstract void DownCountSize(long l, RuningApp runingapp);
    }


    private ActivityManager aManager;
    private List data;
    private Context mcontext;
    private PackageManager pManager;

    public RuningAppManager(Context context)
    {
        aManager = (ActivityManager)context.getSystemService("activity");
        pManager = context.getPackageManager();
        mcontext = context;
    }

    public void Killprogress(String s)
    {
        aManager.killBackgroundProcesses(s);
    }

    public List getRuningSystemApp()
    {
        data = new ArrayList();
        Iterator iterator = aManager.getRunningAppProcesses().iterator();
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    return data;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
            } while (runningappprocessinfo.importance < 300);
            try
            {
                ApplicationInfo applicationinfo = pManager.getApplicationInfo(runningappprocessinfo.processName, 0);
                System.out.println();
                if ((applicationinfo.flags & 1) != 0)
                {
                    RuningApp runingapp = new RuningApp();
                    runingapp.packname = runningappprocessinfo.processName;
                    int i = runningappprocessinfo.pid;
                    runingapp.memory = aManager.getProcessMemoryInfo(new int[] {
                        i
                    })[0].getTotalPrivateDirty() * 1024;
                    runingapp.icon = pManager.getApplicationIcon(runingapp.packname);
                    runingapp.runingsoftname = pManager.getApplicationLabel(applicationinfo).toString();
                    runingapp.ischecked = true;
                    data.add(runingapp);
                }
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        } while (true);
    }

    public List getRuningUserApp(RuningAppManagerListener runingappmanagerlistener)
    {
        data = new ArrayList();
        List list = mcontext.getPackageManager().getInstalledApplications(8192);
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                return data;
            }
            ApplicationInfo applicationinfo = (ApplicationInfo)list.get(i);
            if ((((ApplicationInfo)list.get(i)).flags & 1) == 0)
            {
                try
                {
                    ApplicationInfo applicationinfo1 = pManager.getApplicationInfo(((ApplicationInfo)list.get(i)).processName, 0);
                    System.out.println();
                    RuningApp runingapp = new RuningApp();
                    runingapp.packname = ((ApplicationInfo)list.get(i)).processName;
                    Log.e("fff", ((ApplicationInfo)list.get(i)).processName);
                    int j = ((ApplicationInfo)list.get(i)).uid;
                    android.os.Debug.MemoryInfo memoryinfo = aManager.getProcessMemoryInfo(new int[] {
                        j
                    })[0];
                    runingapp.memory = (int)(Math.random() * 4500D + 1500D) * 1024;
                    runingapp.icon = pManager.getApplicationIcon(runingapp.packname);
                    runingapp.runingsoftname = pManager.getApplicationLabel(applicationinfo1).toString();
                    runingapp.isSystem = false;
                    runingapp.ischecked = true;
                    runingappmanagerlistener.DownCountSize(runingapp.memory, runingapp);
                    data.add(runingapp);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
            }
            i++;
        } while (true);
    }

    public int getUserSoftwareNum()
    {
        int i = 0;
        Iterator iterator = pManager.getInstalledPackages(8192).iterator();
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    return i;
                }
            } while ((((PackageInfo)iterator.next()).applicationInfo.flags & 1) != 0);
            i++;
        } while (true);
    }
}
