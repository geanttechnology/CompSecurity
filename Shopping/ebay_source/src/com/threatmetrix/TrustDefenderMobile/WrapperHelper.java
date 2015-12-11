// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class WrapperHelper
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/WrapperHelper.getName();

    WrapperHelper()
    {
    }

    static Class getClass(String s)
    {
        Class class1;
        try
        {
            class1 = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d(TAG, "getClass failed:", s);
            return null;
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append(s).append(" getClass failed: ").toString(), exception);
            return null;
        }
        return class1;
    }

    static Field getField(Class class1, String s)
    {
        if (class1 == null)
        {
            return null;
        }
        try
        {
            class1 = class1.getDeclaredField(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    static transient Method getMethod(Class class1, String s, Class aclass[])
    {
        if (class1 == null)
        {
            return null;
        }
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    static Object getValue(Object obj, Field field)
    {
        if (obj == null || field == null)
        {
            return null;
        }
        try
        {
            obj = field.get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return obj;
    }

    static transient Object invoke(Object obj, Method method, Object aobj[])
    {
        Object obj1 = null;
        if (method != null)
        {
            boolean flag = false;
            try
            {
                obj = method.invoke(obj, aobj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(TAG, (new StringBuilder()).append(method.getName()).append(" invoke failed: ").toString(), ((Throwable) (obj)));
                flag = true;
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(TAG, (new StringBuilder()).append(method.getName()).append(" invoke failed: ").toString(), ((Throwable) (obj)));
                flag = true;
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(TAG, (new StringBuilder()).append(method.getName()).append(" invoke failed: ").toString(), ((Throwable) (obj)));
                flag = true;
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(TAG, (new StringBuilder()).append(method.getName()).append(" invoke failed: ").toString(), ((Throwable) (obj)));
                flag = true;
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(TAG, (new StringBuilder()).append(method.getName()).append(" invoke failed: ").toString(), ((Throwable) (obj)));
                flag = true;
                obj = obj1;
            }
            if (!flag)
            {
                return obj;
            }
        }
        return null;
    }

}
