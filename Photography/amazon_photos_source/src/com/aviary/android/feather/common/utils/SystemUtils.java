// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            IOUtils

public final class SystemUtils
{
    public static class CpuInfo
    {

        public static final String BOGO_MIPS = "BogoMIPS";
        public static final String FEATURES = "Features";
        private static final int KHZ = 1000;
        public static final int MHZ_CPU_FAST = 1000;
        public static final String PROCESSOR = "Processor";
        private static int mCpuKiloHz = 0;
        private static HashMap mValues;

        public static int getCpuFrequencyMax()
            throws Exception
        {
            Object obj;
            Object obj2;
            Object obj3;
            if (mCpuKiloHz != 0)
            {
                break MISSING_BLOCK_LABEL_38;
            }
            obj3 = null;
            obj = null;
            obj2 = null;
            Object obj1 = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            mCpuKiloHz = Integer.parseInt(((RandomAccessFile) (obj1)).readLine());
            IOUtils.closeSilently(((java.io.Closeable) (obj1)));
_L1:
            return mCpuKiloHz;
            obj;
            obj1 = obj2;
            obj2 = obj;
_L5:
            obj = obj1;
            ((IOException) (obj2)).printStackTrace();
            IOUtils.closeSilently(((java.io.Closeable) (obj1)));
              goto _L1
            NumberFormatException numberformatexception;
            numberformatexception;
            obj1 = obj3;
_L4:
            obj = obj1;
            numberformatexception.printStackTrace();
            IOUtils.closeSilently(((java.io.Closeable) (obj1)));
              goto _L1
            obj1;
_L3:
            IOUtils.closeSilently(((java.io.Closeable) (obj)));
            throw obj1;
            numberformatexception;
            obj = obj1;
            obj1 = numberformatexception;
            if (true) goto _L3; else goto _L2
_L2:
            numberformatexception;
              goto _L4
            numberformatexception;
              goto _L5
        }

        public static int getCpuMhz()
        {
            int i = 0;
            int j;
            try
            {
                j = getCpuFrequencyMax();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return 0;
            }
            if (j > 0)
            {
                i = j / 1000;
            }
            return i;
        }

        public static float getCpuSpeed()
        {
            float f = -1F;
            if (mValues == null)
            {
                init();
            }
            String s = (String)mValues.get("BogoMIPS");
            if (s != null)
            {
                double d;
                try
                {
                    d = Double.parseDouble(s);
                }
                catch (NumberFormatException numberformatexception)
                {
                    return -1F;
                }
                f = (float)d;
            }
            return f;
        }

        private static void init()
        {
            mValues = new HashMap();
            SystemUtils.readValues(mValues, "/proc/cpuinfo");
        }


        public CpuInfo()
        {
        }
    }

    public static final class MemoryInfo
    {

        public static final String MEM_FREE = "MemFree";
        public static final String MEM_TOTAL = "MemTotal";
        private static final Pattern PROCFS_MEMFILE_FORMAT = Pattern.compile("^*([0-9]*)[ \t]kB");
        public static final int RUNTIME_MEMORY_ARRAY_SIZE = 3;
        public static final int RUNTIME_MEMORY_INDEX_FREE = 0;
        public static final int RUNTIME_MEMORY_INDEX_TOTAL = 2;
        public static final int RUNTIME_MEMORY_INDEX_USED = 1;
        private static HashMap mValues;
        private static double sRuntimeTotalMemory = -1D;
        private static double sSystemTotalMemory = -1D;

        private static double getMemoryValue(String s)
        {
            if (mValues == null)
            {
                init();
            }
            if (mValues.containsKey(s))
            {
                s = (String)mValues.get(s);
                s = PROCFS_MEMFILE_FORMAT.matcher(s);
                if (s.find())
                {
                    return (double)(Long.parseLong(s.group(1)) / 1024L);
                }
            }
            return -1D;
        }

        public static void getRuntimeMemory(double ad[])
        {
            double d = Double.valueOf(Runtime.getRuntime().totalMemory()).doubleValue() / 1048576D;
            double d1 = Double.valueOf(Runtime.getRuntime().maxMemory()).doubleValue() / 1048576D;
            ad[0] = d1 - d;
            ad[1] = d;
            ad[2] = d1;
        }

        public static double getRuntimeTotalMemory()
        {
            if (sRuntimeTotalMemory < 0.0D)
            {
                double ad[] = new double[3];
                getRuntimeMemory(ad);
                sRuntimeTotalMemory = ad[2];
            }
            return sRuntimeTotalMemory;
        }

        public static double getSystemTotalMemory()
        {
            if (sSystemTotalMemory < 0.0D)
            {
                sSystemTotalMemory = getMemoryValue("MemTotal");
            }
            return sSystemTotalMemory;
        }

        private static void init()
        {
            mValues = new HashMap();
            SystemUtils.readValues(mValues, "/proc/meminfo");
        }


        private MemoryInfo()
        {
        }
    }


    static final String TAG = "SystemUtils";

    private SystemUtils()
    {
    }

    public static boolean isUIThread(Context context)
    {
        return Thread.currentThread() == context.getMainLooper().getThread();
    }

    private static void parseLine(String s, HashMap hashmap)
    {
        s = new StringTokenizer(s, ":");
        do
        {
            if (!s.hasMoreTokens())
            {
                break;
            }
            String s1 = s.nextToken().trim();
            if (s.hasMoreTokens())
            {
                hashmap.put(s1, s.nextToken().trim());
            }
        } while (true);
    }

    private static void readValues(HashMap hashmap, String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        obj = obj2;
        Log.i("SystemUtils", (new StringBuilder()).append("readValues: ").append(s).toString());
        obj = obj2;
        s = new BufferedReader(new FileReader(new File(s)));
_L3:
        obj = s.readLine();
        if (obj == null) goto _L2; else goto _L1
_L1:
        parseLine(((String) (obj)), hashmap);
          goto _L3
        obj;
        hashmap = s;
        s = ((String) (obj));
_L7:
        obj = hashmap;
        s.printStackTrace();
        IOUtils.closeSilently(hashmap);
        return;
_L2:
        IOUtils.closeSilently(s);
        return;
        hashmap;
_L5:
        IOUtils.closeSilently(((java.io.Closeable) (obj)));
        throw hashmap;
        hashmap;
        obj = s;
        if (true) goto _L5; else goto _L4
_L4:
        s;
        hashmap = obj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void throwIfNonUiThread(Context context)
    {
        if (isUIThread(context))
        {
            throw new IllegalThreadStateException("Called from wrong thread!");
        } else
        {
            return;
        }
    }

    public static void trySleep(long l)
    {
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

}
