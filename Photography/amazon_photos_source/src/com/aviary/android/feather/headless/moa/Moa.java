// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import android.content.Context;
import android.graphics.Bitmap;
import com.aviary.android.feather.headless.AviaryInitializationException;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaResult

public final class Moa
{
    public static final class CPUArchAbi extends Enum
    {

        private static final CPUArchAbi $VALUES[];
        public static final CPUArchAbi CPU_TYPE_ARM5;
        public static final CPUArchAbi CPU_TYPE_ARM7;
        public static final CPUArchAbi CPU_TYPE_NONE;
        public static final CPUArchAbi CPU_TYPE_X86;

        static CPUArchAbi parseInt(int i)
        {
            CPUArchAbi acpuarchabi[] = values();
            if (i >= 0 && i < acpuarchabi.length)
            {
                return acpuarchabi[i];
            } else
            {
                return CPU_TYPE_NONE;
            }
        }

        public static CPUArchAbi valueOf(String s)
        {
            return (CPUArchAbi)Enum.valueOf(com/aviary/android/feather/headless/moa/Moa$CPUArchAbi, s);
        }

        public static CPUArchAbi[] values()
        {
            return (CPUArchAbi[])$VALUES.clone();
        }

        static 
        {
            CPU_TYPE_NONE = new CPUArchAbi("CPU_TYPE_NONE", 0);
            CPU_TYPE_X86 = new CPUArchAbi("CPU_TYPE_X86", 1);
            CPU_TYPE_ARM5 = new CPUArchAbi("CPU_TYPE_ARM5", 2);
            CPU_TYPE_ARM7 = new CPUArchAbi("CPU_TYPE_ARM7", 3);
            $VALUES = (new CPUArchAbi[] {
                CPU_TYPE_NONE, CPU_TYPE_X86, CPU_TYPE_ARM5, CPU_TYPE_ARM7
            });
        }

        private CPUArchAbi(String s, int i)
        {
            super(s, i);
        }
    }


    public static final Object M_LOCK = new Object();

    private Moa()
    {
    }

    public static void applyActions(MoaResult moaresult)
    {
        synchronized (M_LOCK)
        {
            n_applyActions(moaresult);
        }
        return;
        moaresult;
        obj;
        JVM INSTR monitorexit ;
        throw moaresult;
    }

    public static boolean cpuIsArmv7()
    {
        return n_cpuIsArmv7();
    }

    public static String[] getActions()
    {
        String as[];
        synchronized (M_LOCK)
        {
            as = n_getActions();
        }
        return as;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static CPUArchAbi getCpuBuild()
    {
        return CPUArchAbi.parseInt(n_getCpuBuild());
    }

    public static int getCpuFamily()
    {
        return n_getCpuFamily();
    }

    public static String[] getEffects()
    {
        String as[];
        synchronized (M_LOCK)
        {
            as = n_getEffects();
        }
        return as;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getMoaLiteVersion()
    {
        return n_getMoaLiteVersion();
    }

    public static String getProclistVersion()
    {
        return n_getProclistVersion();
    }

    public static int getVersion()
    {
        return n_getVersion();
    }

    public static boolean hasHeadless()
    {
        return n_hasHeadless();
    }

    public static void init(Context context, String s, int i)
        throws AviaryInitializationException
    {
        Object obj = M_LOCK;
        obj;
        JVM INSTR monitorenter ;
        i = n_init(context, s, i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw AviaryInitializationException.fromInt(i);
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        obj;
        JVM INSTR monitorexit ;
    }

    static native void n_applyActions(MoaResult moaresult);

    static native boolean n_cpuIsArmv7();

    static native String[] n_getActions();

    static native int n_getCpuBuild();

    static native int n_getCpuFamily();

    static native String[] n_getEffects();

    static native String n_getMoaLiteVersion();

    static native String n_getProclistVersion();

    static native int n_getVersion();

    static native boolean n_hasHeadless();

    static native int n_init(Context context, String s, int i);

    static native void n_notifyPixelsChanged(Bitmap bitmap);

    static native void n_setid(String s);

    public static void notifyPixelsChanged(Bitmap bitmap)
    {
        n_notifyPixelsChanged(bitmap);
    }

    public static void setId(String s)
    {
        synchronized (M_LOCK)
        {
            n_setid(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static 
    {
        System.loadLibrary("cutils");
        System.loadLibrary("aviary_moalite");
        System.loadLibrary("aviary_native");
    }
}
