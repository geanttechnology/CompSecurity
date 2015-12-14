// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.os.Build;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            CpuArch, ArmArchHelper

class CpuArchHelper
{

    CpuArchHelper()
    {
    }

    static String getArmeabiv7CpuAbi()
    {
        return "armeabi-v7a";
    }

    static CpuArch getCpuArch()
    {
        String as[];
        int j;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            as = Build.SUPPORTED_ABIS;
        } else
        {
            as = new String[1];
            as[0] = Build.CPU_ABI;
        }
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = as[i];
            if (((String) (obj)).equals(getx86CpuAbi()))
            {
                return CpuArch.x86;
            }
            if (!((String) (obj)).equals(getArmeabiv7CpuAbi()))
            {
                continue;
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                return CpuArch.ARMv7_NEON;
            }
            obj = new ArmArchHelper();
            String s = ((ArmArchHelper) (obj)).cpuArchFromJNI();
            if (!((ArmArchHelper) (obj)).isARM_v7_CPU(s))
            {
                continue;
            }
            if (((ArmArchHelper) (obj)).isNeonSupported(s))
            {
                return CpuArch.ARMv7_NEON;
            } else
            {
                return CpuArch.ARMv7;
            }
        }

        return CpuArch.NONE;
    }

    static String getx86CpuAbi()
    {
        return "x86";
    }
}
