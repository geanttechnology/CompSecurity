// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MemoryManager
{

    private Context context;

    public MemoryManager(Context context1)
    {
        context = context1;
    }

    private long getFreeSize(String s)
    {
        s = new StatFs(s);
        long l = s.getAvailableBlocks();
        return (long)s.getBlockSize() * l;
    }

    private long getTotalSize(String s)
    {
        s = new StatFs(s);
        long l = s.getBlockCount();
        return (long)s.getBlockSize() * l;
    }

    public int clearMemory()
    {
        int i = 0;
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        Iterator iterator = activitymanager.getRunningAppProcesses().iterator();
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    return i;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
            } while (runningappprocessinfo.importance < 300);
            activitymanager.killBackgroundProcesses(runningappprocessinfo.processName);
            i++;
        } while (true);
    }

    public long getAvailMemory()
    {
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        activitymanager.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem;
    }

    public long getPhoneFreeSize()
    {
        return getFreeSize(Environment.getRootDirectory().getAbsolutePath());
    }

    public long getPhoneTotalSize()
    {
        String s = Environment.getRootDirectory().getAbsolutePath();
        String s1 = Environment.getDataDirectory().getAbsolutePath();
        String s2 = Environment.getDownloadCacheDirectory().getAbsolutePath();
        return getTotalSize(s) + getTotalSize(s1) + getTotalSize(s2);
    }

    public long getSDFreeSize()
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            return getFreeSize(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else
        {
            return 0L;
        }
    }

    public long getSDTotalSize()
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            return getTotalSize(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else
        {
            return 0L;
        }
    }

    public long getSecondSDFreeSize()
    {
        Map map = System.getenv();
        if (map.containsKey("SECONDARY_STORAGE"))
        {
            return getFreeSize(((String)map.get("SECONDARY_STORAGE")).split(":")[0]);
        } else
        {
            return 0L;
        }
    }

    public long getSecondSDTotalSize()
    {
        Map map = System.getenv();
        if (map.containsKey("SECONDARY_STORAGE"))
        {
            return getTotalSize(((String)map.get("SECONDARY_STORAGE")).split(":")[0]);
        } else
        {
            return 0L;
        }
    }

    public long totalMemory()
    {
        Object obj;
        Object obj3;
        obj = null;
        obj3 = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"));
        int i = Integer.valueOf(((BufferedReader) (obj1)).readLine().split("\\s+")[1]).intValue();
        long l = i * 1024;
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        return l;
        Object obj2;
        obj2;
        obj1 = obj3;
_L4:
        obj = obj1;
        ((IOException) (obj2)).printStackTrace();
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        return 0L;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
