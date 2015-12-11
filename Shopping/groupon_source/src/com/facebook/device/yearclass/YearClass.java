// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.device.yearclass;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.facebook.device.yearclass:
//            DeviceInfo

public class YearClass
{

    private static volatile Integer mYearCategory;

    public YearClass()
    {
    }

    private static int categorizeByYear(Context context)
    {
        ArrayList arraylist = new ArrayList();
        conditionallyAdd(arraylist, getNumCoresYear());
        conditionallyAdd(arraylist, getClockSpeedYear());
        conditionallyAdd(arraylist, getRamYear(context));
        if (arraylist.isEmpty())
        {
            return -1;
        }
        Collections.sort(arraylist);
        if ((arraylist.size() & 1) == 1)
        {
            return ((Integer)arraylist.get(arraylist.size() / 2)).intValue();
        } else
        {
            int i = arraylist.size() / 2 - 1;
            int j = ((Integer)arraylist.get(i)).intValue();
            return (((Integer)arraylist.get(i + 1)).intValue() - ((Integer)arraylist.get(i)).intValue()) / 2 + j;
        }
    }

    private static void conditionallyAdd(ArrayList arraylist, int i)
    {
        if (i != -1)
        {
            arraylist.add(Integer.valueOf(i));
        }
    }

    public static int get(Context context)
    {
        if (mYearCategory != null) goto _L2; else goto _L1
_L1:
        com/facebook/device/yearclass/YearClass;
        JVM INSTR monitorenter ;
        if (mYearCategory == null)
        {
            mYearCategory = Integer.valueOf(categorizeByYear(context));
        }
        com/facebook/device/yearclass/YearClass;
        JVM INSTR monitorexit ;
_L2:
        return mYearCategory.intValue();
        context;
        com/facebook/device/yearclass/YearClass;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static int getClockSpeedYear()
    {
        long l = DeviceInfo.getCPUMaxFreqKHz();
        if (l == -1L)
        {
            return -1;
        }
        if (l <= 0x80e80L)
        {
            return 2008;
        }
        if (l <= 0x975e0L)
        {
            return 2009;
        }
        if (l <= 0xf9060L)
        {
            return 2010;
        }
        if (l <= 0x129da0L)
        {
            return 2011;
        }
        if (l <= 0x173180L)
        {
            return 2012;
        }
        return l > 0x1ed2a0L ? 2014 : 2013;
    }

    private static int getNumCoresYear()
    {
        int i = DeviceInfo.getNumberOfCPUCores();
        if (i < 1)
        {
            return -1;
        }
        if (i == 1)
        {
            return 2008;
        }
        return i > 3 ? 2012 : 2011;
    }

    private static int getRamYear(Context context)
    {
        long l = DeviceInfo.getTotalMemory(context);
        if (l <= 0L)
        {
            return -1;
        }
        if (l <= 0xc000000L)
        {
            return 2008;
        }
        if (l <= 0x12200000L)
        {
            return 2009;
        }
        if (l <= 0x20000000L)
        {
            return 2010;
        }
        if (l <= 0x40000000L)
        {
            return 2011;
        }
        if (l <= 0x60000000L)
        {
            return 2012;
        }
        return l > 0x80000000L ? 2014 : 2013;
    }
}
