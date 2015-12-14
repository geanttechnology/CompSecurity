// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.text.TextUtils;

final class CpuArch extends Enum
{

    private static final CpuArch $VALUES[];
    public static final CpuArch ARMv7;
    public static final CpuArch ARMv7_NEON;
    public static final CpuArch NONE;
    public static final CpuArch x86;
    private String sha1;

    private CpuArch(String s, int i, String s1)
    {
        super(s, i);
        sha1 = s1;
    }

    static CpuArch fromString(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            CpuArch acpuarch[] = values();
            int j = acpuarch.length;
            for (int i = 0; i < j; i++)
            {
                CpuArch cpuarch = acpuarch[i];
                if (s.equalsIgnoreCase(cpuarch.sha1))
                {
                    return cpuarch;
                }
            }

        }
        return NONE;
    }

    public static CpuArch valueOf(String s)
    {
        return (CpuArch)Enum.valueOf(com/github/hiteshsondhi88/libffmpeg/CpuArch, s);
    }

    public static CpuArch[] values()
    {
        return (CpuArch[])$VALUES.clone();
    }

    String getSha1()
    {
        return sha1;
    }

    static 
    {
        x86 = new CpuArch("x86", 0, "1b3daf0402c38ec0019ec436d71a1389514711bd");
        ARMv7 = new CpuArch("ARMv7", 1, "e27cf3c432b121896fc8af2d147eff88d3074dd5");
        ARMv7_NEON = new CpuArch("ARMv7_NEON", 2, "9463c40e898c53dcac59b8ba39cfd590e2f1b1bf");
        NONE = new CpuArch("NONE", 3, null);
        $VALUES = (new CpuArch[] {
            x86, ARMv7, ARMv7_NEON, NONE
        });
    }
}
