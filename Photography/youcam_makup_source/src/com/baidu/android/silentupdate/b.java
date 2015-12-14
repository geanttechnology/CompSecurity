// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.silentupdate;

import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b
{

    private static final String a = "PushClassloader";

    b()
    {
    }

    public static ClassLoader a(String s, String s1, String s2, Context context)
    {
        s2 = new DexClassLoader(s, s1, s2, context.getClassLoader());
        return s2;
        s2;
        s2 = new DexFile(context.getPackageResourcePath());
        Class class1 = Class.forName("dalvik.system.DexFile");
        Method method = class1.getDeclaredMethod("openDexFile", new Class[] {
            java/lang/String, java/lang/String, Integer.TYPE
        });
        method.setAccessible(true);
        int i = ((Integer)method.invoke(s2, new Object[] {
            s, s1, Integer.valueOf(0)
        })).intValue();
        s1 = class1.getDeclaredField("mCookie");
        s1.setAccessible(true);
        s1.set(s2, Integer.valueOf(i));
        s1 = class1.getDeclaredField("mFileName");
        s1.setAccessible(true);
        s1.set(s2, s);
        s = new PathClassLoader(context.getPackageResourcePath(), context.getClassLoader());
        s1 = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
        s1.setAccessible(true);
        s1 = ((String) (s1.get(s)));
        context = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
        context.setAccessible(true);
        s1 = ((String) ((Object[])(Object[])context.get(s1)));
        if (s1.length <= 0)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        context = Class.forName("dalvik.system.DexPathList$Element").getDeclaredField("dexFile");
        context.setAccessible(true);
        context.set(s1[0], s2);
        return s;
        s;
_L2:
        return null;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a(ClassLoader classloader, ClassLoader classloader1)
    {
        for (ClassLoader classloader2 = classloader1; classloader2 != null; classloader2 = classloader2.getParent())
        {
            if (classloader2 == classloader)
            {
                Log.d("PushClassloader", "the classloader has been inserted");
                return true;
            }
        }

        Field field = Class.forName("java.lang.ClassLoader").getDeclaredField("parent");
        field.setAccessible(true);
        field.set(classloader, field.get(classloader1));
        field.set(classloader1, classloader);
        return true;
        classloader;
_L2:
        return false;
        classloader;
        continue; /* Loop/switch isn't completed */
        classloader;
        continue; /* Loop/switch isn't completed */
        classloader;
        continue; /* Loop/switch isn't completed */
        classloader;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
