// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
            Log.v("AmazonMapsV2", "Arguments do not match the parameter list.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" was not found.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" does not have that constructor.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" could not be created.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" is not accessible.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" constructor threw an exception.").toString());
            Log.v("AmazonMapsV2", Log.getStackTraceString(context));
            return null;
        }
        return context;
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
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" does not match the parameter list.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(class1.getName()).append(" class not found.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" is inaccessible.").toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append(s).append(" does not exist.").toString());
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
}
