// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.Value;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, GenericUtils

public class ReflectionHelper
{
    public static class CannotCallMethodException extends Exception
    {

        private static final long serialVersionUID = 1L;

        public CannotCallMethodException(String s)
        {
            super(s);
        }

        public CannotCallMethodException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }

    private static class MethodLookUpInfo
    {

        private final Class mClass;
        private final String mMethodName;
        private final Class mParamTypes[];

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (MethodLookUpInfo)obj;
                if (!TextUtils.equals(mMethodName, ((MethodLookUpInfo) (obj)).mMethodName) || !Arrays.equals(mParamTypes, ((MethodLookUpInfo) (obj)).mParamTypes) || !GenericUtils.equals(mClass, ((MethodLookUpInfo) (obj)).mClass))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (mClass == null)
            {
                i = 0;
            } else
            {
                i = mClass.hashCode();
            }
            if (mMethodName != null)
            {
                j = mMethodName.hashCode();
            }
            return ((i + 31) * 31 + j) * 31 + Arrays.hashCode(mParamTypes);
        }

        public transient MethodLookUpInfo(Class class1, String s, Class aclass[])
        {
            mClass = class1;
            mMethodName = s;
            mParamTypes = aclass;
        }
    }


    private static final Map CLASS_NAME_TO_CLASS_CACHE = new ConcurrentHashMap();
    private static final Map METHOD_INFO_TO_CLASS_CACHE = new ConcurrentHashMap();
    private static final String TAG = com/amazon/identity/auth/device/utils/ReflectionHelper.getName();

    public ReflectionHelper()
    {
    }

    private Class findHiddenClass(String s)
    {
        Class class1;
        try
        {
            class1 = Class.forName(s);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            s = String.format("Failed to locate class named %s. If this is not a Kindle device, you can ignore this warning.", new Object[] {
                s
            });
            MAPLog.w(TAG, s);
            return null;
        }
        return class1;
    }

    private Method findMethod(Class class1, String s, Class aclass[])
    {
        Class class3 = null;
        Class class4 = null;
        Class class2 = null;
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            MAPLog.e(TAG, (new StringBuilder("Security Exception! Error: ")).append(class1.getMessage()).toString());
            return class2;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            MAPLog.e(TAG, "Method cannot be found. Are you sure it is public?");
            return class3;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            MAPLog.e(TAG, "IllegalArguemntException calling method");
            return class4;
        }
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        class2 = class1;
        class3 = class1;
        class4 = class1;
        MAPLog.e(TAG, "Method cannot be found. Are you sure it is public?");
        return class1;
    }

    private Object getField(Class class1, Object obj, String s)
        throws CannotCallMethodException
    {
        try
        {
            class1 = class1.getField(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new CannotCallMethodException("Cannot get field because of a security exception", class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new CannotCallMethodException(String.format("Field %s cannot be found", new Object[] {
                s
            }), class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new CannotCallMethodException("Cannot get field because of IllegalArgumentException", class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new CannotCallMethodException("Cannot get field because of IllegalAccessException", class1);
        }
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        throw new CannotCallMethodException(String.format("Field %s cannot be found", new Object[] {
            s
        }));
        class1 = ((Class) (class1.get(obj)));
        return class1;
    }

    private transient Object invoke(String s, Class class1, Object obj, Class aclass[], Object aobj[])
        throws CannotCallMethodException
    {
        Value value1;
        MethodLookUpInfo methodlookupinfo;
        methodlookupinfo = new MethodLookUpInfo(class1, s, aclass);
        value1 = (Value)METHOD_INFO_TO_CLASS_CACHE.get(methodlookupinfo);
        Value value;
        value = value1;
        if (value1 != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        value = new Value(findMethod(class1, s, aclass));
        METHOD_INFO_TO_CLASS_CACHE.put(methodlookupinfo, value);
        class1 = (Method)value.getValue();
        if (class1 == null)
        {
            try
            {
                throw new CannotCallMethodException(String.format("Method %s cannot be found or accessed!", new Object[] {
                    s
                }));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new CannotCallMethodException(s.getMessage(), s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new CannotCallMethodException("IllegalArguemntException calling method", s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new CannotCallMethodException("IllegalAccessException calling method", s);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                MAPLog.e(TAG, String.format("Exception thrown while calling method %s", new Object[] {
                    s
                }), class1.getCause());
            }
            break MISSING_BLOCK_LABEL_173;
        }
        class1 = ((Class) (class1.invoke(obj, aobj)));
        return class1;
        throw new CannotCallMethodException("Exception calling method", class1);
    }

    public Object getField(Object obj, String s)
        throws CannotCallMethodException
    {
        return getField(obj.getClass(), obj, s);
    }

    public Class getHiddenClass(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        Value value1 = (Value)CLASS_NAME_TO_CLASS_CACHE.get(s);
        Value value = value1;
        if (value1 == null)
        {
            value = new Value(findHiddenClass(s));
            CLASS_NAME_TO_CLASS_CACHE.put(s, value);
        }
        return (Class)value.getValue();
    }

    public Object getStaticField(Class class1, String s)
        throws CannotCallMethodException
    {
        return getField(class1, null, s);
    }

    public transient Object invoke(String s, Object obj, Class aclass[], Object aobj[])
        throws CannotCallMethodException
    {
        return invoke(s, obj.getClass(), obj, aclass, aobj);
    }

    public transient Object invokeStatic(String s, Class class1, Class aclass[], Object aobj[])
        throws CannotCallMethodException
    {
        return invoke(s, class1, null, aclass, aobj);
    }

    public transient Object invokeStatic(String s, String s1, Class aclass[], Object aobj[])
        throws CannotCallMethodException
    {
        Class class1 = getHiddenClass(s1);
        if (class1 == null)
        {
            s = (new StringBuilder("Cannot find class ")).append(s1).toString();
            MAPLog.e(TAG, s);
            throw new CannotCallMethodException(s);
        } else
        {
            return invoke(s, class1, null, aclass, aobj);
        }
    }

}
