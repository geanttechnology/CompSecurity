// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class np
{

    private static final String a = np.getName();

    public np()
    {
    }

    public static Object a(Class class1, String s, Object obj)
    {
        try
        {
            class1 = class1.getDeclaredField(s);
            class1.setAccessible(true);
            class1 = ((Class) (class1.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.w(a, Log.getStackTraceString(class1));
            return null;
        }
        return class1;
    }

    public static transient Object a(Class class1, String s, Class aclass[], Object obj, Object aobj[])
    {
        try
        {
            class1 = class1.getDeclaredMethod(s, aclass);
            class1.setAccessible(true);
            class1 = ((Class) (class1.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.w(a, Log.getStackTraceString(class1));
            return null;
        }
        return class1;
    }

    public static void a(Class class1, String s, Object obj, Object obj1)
    {
        try
        {
            class1 = class1.getDeclaredField(s);
            class1.setAccessible(true);
            class1.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.w(a, Log.getStackTraceString(class1));
        }
    }

}
