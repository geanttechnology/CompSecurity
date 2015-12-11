// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mobile.sdk.environment.CpuInfo;
import com.jumio.mobile.sdk.environment.Environment;

public class cu
{

    public static boolean a()
    {
        boolean flag1 = false;
        Environment.loadCpuInfoLib();
        String s = c();
        boolean flag;
        boolean flag2;
        if (b().equals("ARM") && s.contains("ARMv7") && s.contains("NEON"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = b().equals("ARM64");
        if (flag || flag2)
        {
            flag1 = true;
        }
        return flag1;
    }

    public static String b()
    {
        int i = CpuInfo.getCpuFamily();
        switch (i)
        {
        default:
            return (new StringBuilder("UNKNOWN (")).append(i).append(")").toString();

        case 1: // '\001'
            return "ARM";

        case 2: // '\002'
            return "X86";

        case 3: // '\003'
            return "MIPS";

        case 4: // '\004'
            return "ARM64";

        case 5: // '\005'
            return "X86_64";

        case 6: // '\006'
            return "MIPS64";
        }
    }

    public static String c()
    {
        String s;
        int i;
        int j;
        i = CpuInfo.getCpuFamily();
        j = CpuInfo.getCpuFeatures();
        s = "";
        i;
        JVM INSTR tableswitch 1 4: default 44
    //                   1 49
    //                   2 604
    //                   3 44
    //                   4 693;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        s = "";
_L6:
        return s;
_L2:
        String s1 = s;
        if ((j & 1) == 1)
        {
            s1 = (new StringBuilder()).append("").append("ARMv7 ").toString();
        }
        s = s1;
        if ((j & 2) == 2)
        {
            s = (new StringBuilder()).append(s1).append("VFPv3 ").toString();
        }
        s1 = s;
        if ((j & 4) == 4)
        {
            s1 = (new StringBuilder()).append(s).append("NEON ").toString();
        }
        s = s1;
        if ((j & 8) == 8)
        {
            s = (new StringBuilder()).append(s1).append("LDREX_STREX ").toString();
        }
        s1 = s;
        if ((j & 0x10) == 16)
        {
            s1 = (new StringBuilder()).append(s).append("VFPv2 ").toString();
        }
        s = s1;
        if ((j & 0x20) == 32)
        {
            s = (new StringBuilder()).append(s1).append("VFP_D32 ").toString();
        }
        s1 = s;
        if ((j & 0x40) == 64)
        {
            s1 = (new StringBuilder()).append(s).append("VFP_FP16 ").toString();
        }
        s = s1;
        if ((j & 0x80) == 128)
        {
            s = (new StringBuilder()).append(s1).append("VFP_FMA ").toString();
        }
        s1 = s;
        if ((j & 0x100) == 256)
        {
            s1 = (new StringBuilder()).append(s).append("NEON_FMA ").toString();
        }
        s = s1;
        if ((j & 0x200) == 512)
        {
            s = (new StringBuilder()).append(s1).append("IDIV_ARM ").toString();
        }
        s1 = s;
        if ((j & 0x400) == 1024)
        {
            s1 = (new StringBuilder()).append(s).append("IDIV_THUMB2 ").toString();
        }
        s = s1;
        if ((j & 0x800) == 2048)
        {
            s = (new StringBuilder()).append(s1).append("iWMMXt ").toString();
        }
        s1 = s;
        if ((j & 0x1000) == 4096)
        {
            s1 = (new StringBuilder()).append(s).append("AES ").toString();
        }
        s = s1;
        if ((j & 0x2000) == 8192)
        {
            s = (new StringBuilder()).append(s1).append("PMULL ").toString();
        }
        s1 = s;
        if ((j & 0x4000) == 16384)
        {
            s1 = (new StringBuilder()).append(s).append("SHA1 ").toString();
        }
        String s4 = s1;
        if ((0x8000 & j) == 32768)
        {
            s4 = (new StringBuilder()).append(s1).append("SHA2 ").toString();
        }
        s = s4;
        if ((0x10000 & j) == 0x10000)
        {
            return (new StringBuilder()).append(s4).append("CRC32 ").toString();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((j & 1) == 1)
        {
            s = (new StringBuilder()).append("").append("SSSE3 ").toString();
        }
        String s2 = s;
        if ((j & 2) == 2)
        {
            s2 = (new StringBuilder()).append(s).append("POPCNT ").toString();
        }
        s = s2;
        if ((j & 4) == 4)
        {
            return (new StringBuilder()).append(s2).append("MOVBE ").toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        String s3 = s;
        if ((j & 1) == 1)
        {
            s3 = (new StringBuilder()).append("").append("FP ").toString();
        }
        s = s3;
        if ((j & 2) == 2)
        {
            s = (new StringBuilder()).append(s3).append("ASIMD ").toString();
        }
        s3 = s;
        if ((j & 4) == 4)
        {
            s3 = (new StringBuilder()).append(s).append("AES ").toString();
        }
        s = s3;
        if ((j & 8) == 8)
        {
            s = (new StringBuilder()).append(s3).append("PMULL ").toString();
        }
        s3 = s;
        if ((j & 0x10) == 16)
        {
            s3 = (new StringBuilder()).append(s).append("SHA1 ").toString();
        }
        String s5 = s3;
        if ((j & 0x20) == 32)
        {
            s5 = (new StringBuilder()).append(s3).append("SHA2 ").toString();
        }
        s = s5;
        if ((j & 0x40) == 64)
        {
            return (new StringBuilder()).append(s5).append("CRC32 ").toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
