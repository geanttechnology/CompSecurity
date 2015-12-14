// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            SystemUtils

public static final class 
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
        SystemUtils.access$000(mValues, "/proc/meminfo");
    }


    private ()
    {
    }
}
