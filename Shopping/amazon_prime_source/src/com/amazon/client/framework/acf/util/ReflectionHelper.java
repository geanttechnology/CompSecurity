// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.util;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.client.framework.acf.util:
//            AcfLog

public class ReflectionHelper
{
    public static class ParameterSet
    {

        public final Class type;
        public final Object value;

        public ParameterSet(Class class1, Object obj)
        {
            type = class1;
            value = obj;
        }
    }


    public static final String TAG = AcfLog.getTag(com/amazon/client/framework/acf/util/ReflectionHelper);

    public ReflectionHelper()
    {
    }

    public static transient Object constructObject(Context context, String s, Class class1, ParameterSet aparameterset[])
        throws ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        context = context.getClassLoader().loadClass(s);
        s = new Class[aparameterset.length];
        Object aobj[] = new Object[aparameterset.length];
        for (int i = 0; i < aparameterset.length; i++)
        {
            s[i] = aparameterset[i].type;
            aobj[i] = aparameterset[i].value;
        }

        return class1.cast(context.getConstructor(s).newInstance(aobj));
    }

    public static Object constructObjectIfExists(Context context, String s, Class class1)
    {
        return constructObjectIfExists(context, s, class1, new ParameterSet[0]);
    }

    public static transient Object constructObjectIfExists(Context context, String s, Class class1, ParameterSet aparameterset[])
    {
        try
        {
            context = ((Context) (constructObject(context, s, class1, aparameterset)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, "Arguments do not match the parameter list.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" was not found.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" does not have that constructor.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" could not be created.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" is not accessible.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" constructor threw an exception:").toString(), context.getCause());
            return null;
        }
        return context;
    }

    public static int intProperty(Object obj, String s, int i)
    {
        int j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        j = i;
        if (s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        String s1;
        if (s.length() > 1)
        {
            s1 = String.format("get%c%s", new Object[] {
                Character.valueOf(Character.toUpperCase(s.charAt(0))), s.substring(1)
            });
        } else
        {
            s1 = String.format("get%c", new Object[] {
                Character.valueOf(Character.toUpperCase(s.charAt(0)))
            });
        }
        try
        {
            obj = obj.getClass().getMethod(s1, (Class[])null).invoke(obj, (Object[])null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, "Object is not of the expected type.");
            return i;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" does not exist.").toString());
            return i;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" is not of the desired type.").toString());
            return i;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" is not accessible.").toString());
            return i;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" threw an exception.").toString());
            Log.v(TAG, Log.getStackTraceString(((Throwable) (obj))));
            return i;
        }
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        j = ((Integer)java/lang/Integer.cast(obj)).intValue();
        return j;
    }

    public static transient Object invokeMethod(Class class1, Object obj, String s, ParameterSet aparameterset[])
        throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        Class aclass[] = new Class[aparameterset.length];
        Object aobj[] = new Object[aparameterset.length];
        for (int i = 0; i < aparameterset.length; i++)
        {
            aclass[i] = aparameterset[i].type;
            aobj[i] = aparameterset[i].value;
        }

        return class1.getMethod(s, aclass).invoke(obj, aobj);
    }

    public static Object invokeMethodIfExists(Class class1, Object obj, String s)
        throws InvocationTargetException
    {
        return invokeMethodIfExists(class1, obj, s, new ParameterSet[0]);
    }

    public static transient Object invokeMethodIfExists(Class class1, Object obj, String s, ParameterSet aparameterset[])
        throws InvocationTargetException
    {
        try
        {
            obj = invokeMethod(class1, obj, s, aparameterset);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" does not match the parameter list.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v(TAG, (new StringBuilder()).append(class1.getName()).append(" class not found.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" is inaccessible.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.v(TAG, (new StringBuilder()).append(s).append(" does not exist.").toString());
            return null;
        }
        return obj;
    }

    public static transient Object invokeStaticMethod(Context context, String s, String s1, ParameterSet aparameterset[])
        throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        return invokeMethod(context.getClassLoader().loadClass(s), null, s1, aparameterset);
    }

    public static ParameterSet param(Class class1, Object obj)
    {
        return new ParameterSet(class1, obj);
    }

    public static boolean setFieldIfExists(Class class1, Object obj, String s, Object obj1)
    {
        class1 = class1.getDeclaredField(s);
        class1.setAccessible(true);
        class1.set(obj, obj1);
        return true;
        class1;
_L2:
        return false;
        class1;
        continue; /* Loop/switch isn't completed */
        class1;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
