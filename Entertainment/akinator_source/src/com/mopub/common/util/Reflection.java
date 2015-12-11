// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection
{
    public static class MethodBuilder
    {

        private Class mClass;
        private final Object mInstance;
        private boolean mIsAccessible;
        private boolean mIsStatic;
        private final String mMethodName;
        private List mParameterClasses;
        private List mParameters;

        public MethodBuilder addParam(Class class1, Object obj)
        {
            mParameterClasses.add(class1);
            mParameters.add(obj);
            return this;
        }

        public Object execute()
            throws Exception
        {
            Class aclass[] = new Class[mParameterClasses.size()];
            aclass = (Class[])mParameterClasses.toArray(aclass);
            Method method = Reflection.getDeclaredMethodWithTraversal(mClass, mMethodName, aclass);
            if (mIsAccessible)
            {
                method.setAccessible(true);
            }
            Object aobj[] = mParameters.toArray();
            if (mIsStatic)
            {
                return method.invoke(null, aobj);
            } else
            {
                return method.invoke(mInstance, aobj);
            }
        }

        public MethodBuilder setAccessible()
        {
            mIsAccessible = true;
            return this;
        }

        public MethodBuilder setStatic(Class class1)
        {
            mIsStatic = true;
            mClass = class1;
            return this;
        }

        public MethodBuilder(Object obj, String s)
        {
            mInstance = obj;
            mMethodName = s;
            mParameterClasses = new ArrayList();
            mParameters = new ArrayList();
            if (obj != null)
            {
                obj = obj.getClass();
            } else
            {
                obj = null;
            }
            mClass = ((Class) (obj));
        }
    }


    public Reflection()
    {
    }

    public static boolean classFound(String s)
    {
        try
        {
            Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static transient Method getDeclaredMethodWithTraversal(Class class1, String s, Class aclass[])
        throws NoSuchMethodException
    {
_L2:
        if (class1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Method method = class1.getDeclaredMethod(s, aclass);
        return method;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        class1 = class1.getSuperclass();
        if (true) goto _L2; else goto _L1
_L1:
        throw new NoSuchMethodException();
    }

    public static Object instantiateClassWithEmptyConstructor(String s, Class class1)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException
    {
        Preconditions.checkNotNull(s);
        s = Class.forName(s).asSubclass(class1).getDeclaredConstructor((Class[])null);
        s.setAccessible(true);
        return s.newInstance(new Object[0]);
    }
}
