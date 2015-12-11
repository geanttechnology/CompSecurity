// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.util.Log;
import java.lang.reflect.Method;

public class StrictModeCompat
{

    public StrictModeCompat()
    {
    }

    public static void enable()
    {
        Object obj;
        Object obj2;
        obj2 = Class.forName("android.os.StrictMode$ThreadPolicy$Builder");
        obj = ((Class) (obj2)).newInstance();
        obj = ((Class) (obj2)).getMethod("detectDiskReads", new Class[0]).invoke(obj, new Object[0]);
        obj = ((Class) (obj2)).getMethod("detectDiskWrites", new Class[0]).invoke(obj, new Object[0]);
        obj = ((Class) (obj2)).getMethod("detectNetwork", new Class[0]).invoke(obj, new Object[0]);
        obj = ((Class) (obj2)).getMethod("penaltyLog", new Class[0]).invoke(obj, new Object[0]);
        Object obj1 = ((Class) (obj2)).getMethod("penaltyFlashScreen", new Class[0]).invoke(obj, new Object[0]);
        obj = obj1;
_L4:
        Class class2;
        obj2 = ((Class) (obj2)).getMethod("build", new Class[0]).invoke(obj, new Object[0]);
        class2 = Class.forName("android.os.StrictMode$VmPolicy$Builder");
        obj1 = class2.newInstance();
        obj = obj1;
        obj1 = class2.getMethod("detectActivityLeaks", new Class[0]).invoke(obj1, new Object[0]);
        obj = obj1;
        obj1 = class2.getMethod("detectLeakedClosableObjects", new Class[0]).invoke(obj1, new Object[0]);
        obj = obj1;
_L2:
        try
        {
            obj = class2.getMethod("detectLeakedSqlLiteObjects", new Class[0]).invoke(obj, new Object[0]);
            obj = class2.getMethod("penaltyLog", new Class[0]).invoke(obj, new Object[0]);
            obj = class2.getMethod("build", new Class[0]).invoke(obj, new Object[0]);
            Class class1 = Class.forName("android.os.StrictMode");
            class1.getMethod("setThreadPolicy", new Class[] {
                obj2.getClass()
            }).invoke(null, new Object[] {
                obj2
            });
            class1.getMethod("setVmPolicy", new Class[] {
                obj.getClass()
            }).invoke(null, new Object[] {
                obj
            });
            return;
        }
        catch (Exception exception)
        {
            Log.w(com/ebay/mobile/StrictModeCompat.getSimpleName(), "StrictMode is not available for sdk 8 and lower");
        }
        return;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        if (true) goto _L2; else goto _L1
_L1:
        nosuchmethodexception;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
