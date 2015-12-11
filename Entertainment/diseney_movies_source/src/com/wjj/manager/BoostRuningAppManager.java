// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.wjj.eneity.RuningApp;
import java.io.PrintStream;
import java.util.List;

public class BoostRuningAppManager
{
    public static interface BoostRuningAppManagerListener
    {

        public abstract void DownCountSize(long l, RuningApp runingapp);
    }


    private ActivityManager aManager;
    private Context mcontext;
    private PackageManager pManager;

    public BoostRuningAppManager(Context context)
    {
        aManager = (ActivityManager)context.getSystemService("activity");
        pManager = context.getPackageManager();
        mcontext = context;
    }

    public void Killprogress(String s)
    {
        aManager.killBackgroundProcesses(s);
    }

    public int getRuningUserApp(BoostRuningAppManagerListener boostruningappmanagerlistener)
    {
        List list = mcontext.getPackageManager().getInstalledApplications(8192);
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                return 1;
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
                    boostruningappmanagerlistener.DownCountSize(runingapp.memory, runingapp);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
            }
            i++;
        } while (true);
    }
}
