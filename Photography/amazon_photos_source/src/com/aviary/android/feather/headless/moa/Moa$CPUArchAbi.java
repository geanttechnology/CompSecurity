// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;


// Referenced classes of package com.aviary.android.feather.headless.moa:
//            Moa

public static final class  extends Enum
{

    private static final CPU_TYPE_ARM7 $VALUES[];
    public static final CPU_TYPE_ARM7 CPU_TYPE_ARM5;
    public static final CPU_TYPE_ARM7 CPU_TYPE_ARM7;
    public static final CPU_TYPE_ARM7 CPU_TYPE_NONE;
    public static final CPU_TYPE_ARM7 CPU_TYPE_X86;

    static  parseInt(int i)
    {
         a[] = values();
        if (i >= 0 && i < a.length)
        {
            return a[i];
        } else
        {
            return CPU_TYPE_NONE;
        }
    }

    public static CPU_TYPE_NONE valueOf(String s)
    {
        return (CPU_TYPE_NONE)Enum.valueOf(com/aviary/android/feather/headless/moa/Moa$CPUArchAbi, s);
    }

    public static CPU_TYPE_NONE[] values()
    {
        return (CPU_TYPE_NONE[])$VALUES.clone();
    }

    static 
    {
        CPU_TYPE_NONE = new <init>("CPU_TYPE_NONE", 0);
        CPU_TYPE_X86 = new <init>("CPU_TYPE_X86", 1);
        CPU_TYPE_ARM5 = new <init>("CPU_TYPE_ARM5", 2);
        CPU_TYPE_ARM7 = new <init>("CPU_TYPE_ARM7", 3);
        $VALUES = (new .VALUES[] {
            CPU_TYPE_NONE, CPU_TYPE_X86, CPU_TYPE_ARM5, CPU_TYPE_ARM7
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
