// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import com.jumio.mobile.sdk.PlatformNotSupportedException;
import com.jumio.mobile.sdk.ResourceNotFoundException;

// Referenced classes of package jumiomobile:
//            cb, ab, cv, g, 
//            cu

public abstract class cc
{

    private static int a = 0x100000;
    private static int b = 16;

    public cc()
    {
        cb.a();
    }

    protected static void checkMemoryAllocation()
    {
        Runtime runtime = Runtime.getRuntime();
        long l = runtime.totalMemory() / (long)a;
        long l1 = runtime.maxMemory() / (long)a;
        long l2 = l1 - l;
        if (l2 < (long)b)
        {
            ab.d((new StringBuilder("Critical memory warning: Heap situation ")).append(l).append("/").append(l1).append("MB , free ").append(l2).append("MB").toString());
        }
    }

    public static boolean checkResource(Activity activity, String s, String s1)
    {
        if (!cv.a(s, activity.getClassLoader()))
        {
            throw new ResourceNotFoundException((new StringBuilder()).append(s1).append(" package not found").toString());
        } else
        {
            return true;
        }
    }

    public static boolean checkSDKRequirements()
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            throw new PlatformNotSupportedException("SDK Version 14 required");
        }
        if (g.a() == 0)
        {
            throw new PlatformNotSupportedException("No useable camera present");
        }
        if (!cu.a())
        {
            throw new PlatformNotSupportedException("ARMv7 CPU Architecture with NEON Intrinsics required");
        } else
        {
            checkMemoryAllocation();
            return true;
        }
    }

    public static String getSDKVersion()
    {
        return "JMSDK 1.7.0 (1441790640-34)";
    }

    public static boolean isSupportedPlatform()
    {
        boolean flag;
        try
        {
            flag = checkSDKRequirements();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public void destroy()
    {
        this;
        JVM INSTR monitorenter ;
        System.gc();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract void start();

}
