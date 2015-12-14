// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            SystemUtils, IOUtils

public static class A
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
        SystemUtils.access$000(mValues, "/proc/cpuinfo");
    }


    public A()
    {
    }
}
