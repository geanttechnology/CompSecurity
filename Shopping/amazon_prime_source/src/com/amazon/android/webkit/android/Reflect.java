// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class Reflect
{
    private static class CastingInvocationHandler
        implements InvocationHandler
    {

        private Class originalClass;
        private Object receiver;

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
        {
            obj = originalClass.getMethod(method.getName(), method.getParameterTypes());
            try
            {
                obj = ((Method) (obj)).invoke(receiver, aobj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw ((InvocationTargetException) (obj)).getCause();
            }
            return obj;
        }

        public CastingInvocationHandler(Class class1, Object obj)
        {
            receiver = obj;
            originalClass = obj.getClass();
            obj = class1.getMethods();
            int j = obj.length;
            int i = 0;
            while (i < j) 
            {
                class1 = obj[i];
                try
                {
                    originalClass.getMethod(class1.getName(), class1.getParameterTypes());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new ClassCastException((new StringBuilder()).append("Type ").append(originalClass).append(" does not allow access to the method ").append(class1).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new ClassCastException((new StringBuilder()).append("Type ").append(originalClass).append(" does not have the method ").append(class1).toString());
                }
                i++;
            }
        }
    }

    private static class TypeVariableBindings
    {

        private final List bindings;

        public Class get(TypeVariable typevariable)
        {
            for (int i = bindings.size() - 1; i >= 0; i--)
            {
                Entry entry = (Entry)bindings.get(i);
                if (entry.getKey().equals(typevariable))
                {
                    return entry.getValue();
                }
            }

            return null;
        }

        public void pop(int i)
        {
            int k = bindings.size();
            for (int j = bindings.size() - 1; j >= k - i; j--)
            {
                bindings.remove(j);
            }

        }

        public void put(TypeVariable typevariable, Class class1)
        {
            bindings.add(new Entry(typevariable, class1));
        }

        public Class resolve(Type type)
        {
            if (type instanceof Class)
            {
                return (Class)type;
            }
            if (type instanceof ParameterizedType)
            {
                return (Class)((ParameterizedType)type).getRawType();
            }
            if (type instanceof TypeVariable)
            {
                return get((TypeVariable)type);
            } else
            {
                return null;
            }
        }

        private TypeVariableBindings()
        {
            bindings = new ArrayList();
        }

    }

    private static class TypeVariableBindings.Entry
        implements java.util.Map.Entry
    {

        private final TypeVariable key;
        private final Class value;

        public volatile Object getKey()
        {
            return getKey();
        }

        public TypeVariable getKey()
        {
            return key;
        }

        public Class getValue()
        {
            return value;
        }

        public volatile Object getValue()
        {
            return getValue();
        }

        public Class setValue(Class class1)
        {
            throw new UnsupportedOperationException();
        }

        public volatile Object setValue(Object obj)
        {
            return setValue((Class)obj);
        }

        public TypeVariableBindings.Entry(TypeVariable typevariable, Class class1)
        {
            key = typevariable;
            value = class1;
        }
    }


    private Reflect()
    {
    }

    public static Object cast(Class class1, Object obj)
        throws ClassCastException
    {
        ClassLoader classloader = class1.getClassLoader();
        obj = new CastingInvocationHandler(class1, obj);
        return Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, ((InvocationHandler) (obj)));
    }

    public static Class getOptionalClass(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static transient Method getOptionalMethod(Class class1, String s, Class aclass[])
    {
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

    public static transient Method getOptionalPrivateMethod(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getDeclaredMethod(s, aclass);
            class1.setAccessible(true);
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

    public static Class getRequiredClass(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public static transient Method getRequiredMethod(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static transient Constructor getRequiredPrivateConstructor(Class class1, Class aclass[])
    {
        try
        {
            class1 = class1.getDeclaredConstructor(aclass);
            class1.setAccessible(true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static Field getRequiredPrivateField(Class class1, String s)
    {
        try
        {
            class1 = class1.getDeclaredField(s);
            class1.setAccessible(true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static transient Method getRequiredPrivateMethod(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getDeclaredMethod(s, aclass);
            class1.setAccessible(true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static transient Object invokeConstructor(Constructor constructor, Object aobj[])
    {
        try
        {
            constructor = ((Constructor) (constructor.newInstance(aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Constructor constructor)
        {
            throw new AssertionError(constructor);
        }
        // Misplaced declaration of an exception variable
        catch (Constructor constructor)
        {
            throw new AssertionError(constructor);
        }
        // Misplaced declaration of an exception variable
        catch (Constructor constructor)
        {
            throw new AssertionError(constructor);
        }
        // Misplaced declaration of an exception variable
        catch (Constructor constructor)
        {
            aobj = constructor.getCause();
            if (aobj instanceof Error)
            {
                throw (Error)aobj;
            }
            if (aobj instanceof RuntimeException)
            {
                throw (RuntimeException)aobj;
            } else
            {
                throw new AssertionError(constructor);
            }
        }
        return constructor;
    }

    public static transient Object invokeMethod(Method method, Object obj, Object aobj[])
    {
        try
        {
            method = ((Method) (method.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new AssertionError(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new AssertionError(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            obj = method.getCause();
            if (obj instanceof Error)
            {
                throw (Error)obj;
            }
            if (obj instanceof RuntimeException)
            {
                throw (RuntimeException)obj;
            } else
            {
                throw new AssertionError(method);
            }
        }
        return method;
    }

    public static Object readField(Field field, Object obj)
    {
        try
        {
            field = ((Field) (field.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new AssertionError(field);
        }
        return field;
    }

    public static Class[] resolveGenericTypeParameters(Class class1, Class class2)
    {
        return resolveGenericTypeParameters(class1, class2, new TypeVariableBindings());
    }

    private static Class[] resolveGenericTypeParameters(Class class1, Class class2, TypeVariableBindings typevariablebindings)
    {
        if (class2.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Class []) (obj));
_L2:
        if (class1 == class2)
        {
            class2 = class2.getTypeParameters();
            class1 = new Class[class2.length];
            int i = 0;
            do
            {
                obj = class1;
                if (i >= class2.length)
                {
                    continue; /* Loop/switch isn't completed */
                }
                class1[i] = typevariablebindings.get(class2[i]);
                i++;
            } while (true);
        }
        Class aclass[] = resolveGenericTypeParameters(class1.getGenericSuperclass(), class2, typevariablebindings);
        obj = aclass;
        if (aclass == null)
        {
            Type atype[] = class1.getGenericInterfaces();
            int k = atype.length;
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= k)
                    {
                        break label1;
                    }
                    class1 = resolveGenericTypeParameters(atype[j], class2, typevariablebindings);
                    obj = class1;
                    if (class1 != null)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    private static Class[] resolveGenericTypeParameters(ParameterizedType parameterizedtype, Class class1, TypeVariableBindings typevariablebindings)
    {
        TypeVariable atypevariable[];
        Class class2;
        class2 = (Class)parameterizedtype.getRawType();
        atypevariable = class2.getTypeParameters();
        parameterizedtype = parameterizedtype.getActualTypeArguments();
        for (int i = 0; i < atypevariable.length; i++)
        {
            typevariablebindings.put(atypevariable[i], typevariablebindings.resolve(parameterizedtype[i]));
        }

        parameterizedtype = resolveGenericTypeParameters(class2, class1, typevariablebindings);
        typevariablebindings.pop(atypevariable.length);
        return parameterizedtype;
        parameterizedtype;
        typevariablebindings.pop(atypevariable.length);
        throw parameterizedtype;
    }

    private static Class[] resolveGenericTypeParameters(Type type, Class class1, TypeVariableBindings typevariablebindings)
    {
        if (type != null)
        {
            if (type instanceof Class)
            {
                return resolveGenericTypeParameters((Class)type, class1, typevariablebindings);
            }
            if (type instanceof ParameterizedType)
            {
                return resolveGenericTypeParameters((ParameterizedType)type, class1, typevariablebindings);
            }
        }
        return null;
    }

    public static void writeField(Field field, Object obj, Object obj1)
    {
        try
        {
            field.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new AssertionError(field);
        }
    }
}
