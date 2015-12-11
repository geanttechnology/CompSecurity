// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.device.yearclass;

import android.app.ActivityManager;
import android.content.Context;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo
{

    private static final FileFilter CPU_FILTER = new FileFilter() {

        public boolean accept(File file)
        {
            file = file.getName();
            if (!file.startsWith("cpu")) goto _L2; else goto _L1
_L1:
            int i = 3;
_L5:
            if (i >= file.length())
            {
                break; /* Loop/switch isn't completed */
            }
            if (file.charAt(i) >= '0' && file.charAt(i) <= '9') goto _L3; else goto _L2
_L2:
            return false;
_L3:
            i++;
            if (true) goto _L5; else goto _L4
_L4:
            return true;
        }

    };

    private static int extractValue(byte abyte0[], int i)
    {
        for (; i < abyte0.length && abyte0[i] != 10; i++)
        {
            if (abyte0[i] >= 48 && abyte0[i] <= 57)
            {
                int j;
                for (j = i + 1; j < abyte0.length && abyte0[j] >= 48 && abyte0[j] <= 57; j++) { }
                return Integer.parseInt(new String(abyte0, 0, i, j - i));
            }
        }

        return -1;
    }

    public static int getCPUMaxFreqKHz()
    {
        int i;
        int k;
        i = -1;
        k = 0;
_L4:
        Object obj;
        if (k >= getNumberOfCPUCores())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        obj = new File((new StringBuilder()).append("/sys/devices/system/cpu/cpu").append(k).append("/cpufreq/cpuinfo_max_freq").toString());
        int j = i;
        byte abyte0[];
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        abyte0 = new byte[128];
        obj = new FileInputStream(((File) (obj)));
        ((FileInputStream) (obj)).read(abyte0);
        j = 0;
_L2:
        if (abyte0[j] < 48 || abyte0[j] > 57)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        Integer integer = Integer.valueOf(Integer.parseInt(new String(abyte0, 0, j)));
        j = i;
        if (integer.intValue() > i)
        {
            j = integer.intValue();
        }
        ((FileInputStream) (obj)).close();
        break MISSING_BLOCK_LABEL_218;
        Object obj1;
        obj1;
        ((FileInputStream) (obj)).close();
        j = i;
        break MISSING_BLOCK_LABEL_218;
        obj1;
        try
        {
            ((FileInputStream) (obj)).close();
            throw obj1;
        }
        catch (IOException ioexception)
        {
            j = -1;
        }
        break; /* Loop/switch isn't completed */
        j = i;
        if (i != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new FileInputStream("/proc/cpuinfo");
        j = parseFileForValue("cpu MHz", ((FileInputStream) (obj)));
        k = j * 1000;
        j = i;
        if (k > i)
        {
            j = k;
        }
        ((FileInputStream) (obj)).close();
        return j;
        obj1;
        ((FileInputStream) (obj)).close();
        throw obj1;
        k++;
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
        return j;
    }

    public static int getNumberOfCPUCores()
    {
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            return 1;
        }
        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(CPU_FILTER).length;
        }
        catch (SecurityException securityexception)
        {
            return -1;
        }
        catch (NullPointerException nullpointerexception)
        {
            return -1;
        }
        return i;
    }

    public static long getTotalMemory(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryinfo);
            if (memoryinfo != null)
            {
                return memoryinfo.totalMem;
            } else
            {
                return -1L;
            }
        }
        long l1 = -1L;
        long l = l1;
        Exception exception;
        int i;
        try
        {
            context = new FileInputStream("/proc/meminfo");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return l;
        }
        i = parseFileForValue("MemTotal", context);
        l1 = (long)i * 1024L;
        l = l1;
        context.close();
        return l1;
        exception;
        l = l1;
        context.close();
        l = l1;
        throw exception;
    }

    private static int parseFileForValue(String s, FileInputStream fileinputstream)
    {
        byte abyte0[] = new byte[1024];
        int l = fileinputstream.read(abyte0);
        int j = 0;
          goto _L1
_L2:
        int i;
        int k;
        k = i;
        if (j >= l)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        k = j - i;
        if (abyte0[j] != s.charAt(k))
        {
            k = i;
            break MISSING_BLOCK_LABEL_138;
        }
        if (k != s.length() - 1)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        i = extractValue(abyte0, j);
        return i;
        j++;
          goto _L2
        s;
_L3:
        return -1;
        s;
        if (true) goto _L3; else goto _L1
_L1:
        if (j >= l) goto _L3; else goto _L4
_L4:
        if (abyte0[j] != 10)
        {
            k = j;
            if (j != 0)
            {
                break MISSING_BLOCK_LABEL_138;
            }
        }
        i = j;
        if (abyte0[j] == 10)
        {
            i = j + 1;
        }
        j = i;
          goto _L2
        j = k + 1;
          goto _L1
    }

}
