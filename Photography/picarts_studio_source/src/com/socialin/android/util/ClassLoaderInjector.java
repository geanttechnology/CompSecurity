// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.util.Log;
import com.socialin.android.NoProGuard;
import com.socialin.android.d;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ClassLoaderInjector
    implements NoProGuard
{

    public ClassLoaderInjector()
    {
    }

    public static void add(File file, File file1, PathClassLoader pathclassloader)
    {
        try
        {
            file = ((File) (Class.forName("dalvik.system.DexPathList").getConstructor(new Class[] {
                java/lang/ClassLoader, java/lang/String, java/lang/String, java/io/File
            }).newInstance(new Object[] {
                pathclassloader, file.getAbsolutePath(), null, file1
            })));
            d.a((new StringBuilder("adding  dex paths  = ")).append(file).toString());
            file = ((File) (joinArrays(getDexElements(getPathList(pathclassloader)), getDexElements(file))));
            setDexElements(getPathList(pathclassloader), file);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("ClassLoaderInjector", "Error", file);
        }
    }

    private static Object getDexElements(Object obj)
    {
        return getField(obj, obj.getClass(), "dexElements");
    }

    private static Object getField(Object obj, Class class1, String s)
    {
        class1 = class1.getDeclaredField(s);
        class1.setAccessible(true);
        return class1.get(obj);
    }

    private static Object getPathList(BaseDexClassLoader basedexclassloader)
    {
        return getField(basedexclassloader, dalvik/system/BaseDexClassLoader, "pathList");
    }

    private static Object joinArrays(Object obj, Object obj1)
    {
        Object obj2 = obj.getClass().getComponentType();
        int k = Array.getLength(obj);
        int l = Array.getLength(obj1) + k;
        obj2 = Array.newInstance(((Class) (obj2)), l);
        int i = 0;
        int j;
        do
        {
            j = i;
            if (i >= k)
            {
                break;
            }
            Array.set(obj2, i, Array.get(obj, i));
            i++;
        } while (true);
        for (; j < l; j++)
        {
            Array.set(obj2, j, Array.get(obj1, j - k));
        }

        return obj2;
    }

    private static void setDexElements(Object obj, Object obj1)
    {
        setField(obj, obj.getClass(), "dexElements", obj1);
    }

    private static void setField(Object obj, Class class1, String s, Object obj1)
    {
        class1 = class1.getDeclaredField(s);
        class1.setAccessible(true);
        class1.set(obj, obj1);
    }
}
