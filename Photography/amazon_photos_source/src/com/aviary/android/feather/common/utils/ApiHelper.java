// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;


public final class ApiHelper
{
    public static interface VersionCodes
    {

        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
        public static final int JELLY_BEAN_MR2 = 18;
        public static final int KITKAT = 19;
    }


    public static final boolean AT_LEAST_11;
    public static final boolean AT_LEAST_12;
    public static final boolean AT_LEAST_13;
    public static final boolean AT_LEAST_14;
    public static final boolean AT_LEAST_16;
    public static final boolean AT_LEAST_17;
    public static final boolean AT_LEAST_19;
    public static final boolean EFFECT_INTENSITY_AVAILABLE;
    public static final boolean HAS_POST_ON_ANIMATION;
    static final int MEMORY_HIGH = 500;
    static final int MEMORY_LOW = 128;
    static final int MEMORY_MEDIUM = 256;

    private ApiHelper()
    {
    }

    public static boolean fastPreviewEnabled()
    {
        return SystemUtils.CpuInfo.getCpuMhz() >= 1000;
    }

    public static boolean isHiResOriginalAvailable()
    {
        return false;
    }

    public static boolean isHoneyComb()
    {
        return android.os.Build.VERSION.SDK_INT >= 11 && android.os.Build.VERSION.SDK_INT < 14;
    }

    public static boolean isIceCreamSandwich()
    {
        return android.os.Build.VERSION.SDK_INT >= 14 && android.os.Build.VERSION.SDK_INT < 16;
    }

    public static boolean isJellyBean()
    {
        return android.os.Build.VERSION.SDK_INT >= 16 && android.os.Build.VERSION.SDK_INT < 18;
    }

    public static boolean isRestoreAvailable()
    {
        return AT_LEAST_14 && SystemUtils.MemoryInfo.getRuntimeTotalMemory() >= 256D;
    }

    public static boolean isUndoRedoAvailable()
    {
        return AT_LEAST_14 && SystemUtils.MemoryInfo.getSystemTotalMemory() > 500D;
    }

    public static boolean listAnimationsAvailable()
    {
        return AT_LEAST_16 && SystemUtils.CpuInfo.getCpuMhz() >= 1000;
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_11 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_12 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_13 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_14 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_16 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_17 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AT_LEAST_19 = flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        HAS_POST_ON_ANIMATION = flag;
        EFFECT_INTENSITY_AVAILABLE = AT_LEAST_14;
    }
}
