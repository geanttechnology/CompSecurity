// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.plugins.reflect;

import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

final class ReflectiveAtInjectBinding extends Binding
{

    private final Constructor constructor;
    private final Binding fieldBindings[];
    private final Field fields[];
    private final String keys[];
    private final Binding parameterBindings[];
    private final Class supertype;
    private Binding supertypeBinding;

    private ReflectiveAtInjectBinding(String s, String s1, boolean flag, Class class1, Field afield[], Constructor constructor1, int i, 
            Class class2, String as[])
    {
        super(s, s1, flag, class1);
        constructor = constructor1;
        fields = afield;
        supertype = class2;
        keys = as;
        parameterBindings = new Binding[i];
        fieldBindings = new Binding[afield.length];
    }

    public static Binding create(Class class1, boolean flag)
    {
        boolean flag1 = class1.isAnnotationPresent(javax/inject/Singleton);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (Class class2 = class1; class2 != java/lang/Object; class2 = class2.getSuperclass())
        {
            Field afield[] = class2.getDeclaredFields();
            int l = afield.length;
            int i = 0;
            while (i < l) 
            {
                Field field = afield[i];
                if (field.isAnnotationPresent(javax/inject/Inject) && !Modifier.isStatic(field.getModifiers()))
                {
                    field.setAccessible(true);
                    arraylist1.add(field);
                    arraylist.add(Keys.get(field.getGenericType(), field.getAnnotations(), field));
                }
                i++;
            }
        }

        Object obj = null;
        Constructor aconstructor[] = getConstructorsForType(class1);
        int i1 = aconstructor.length;
        int j = 0;
        while (j < i1) 
        {
            Constructor constructor1 = aconstructor[j];
            if (constructor1.isAnnotationPresent(javax/inject/Inject))
            {
                if (obj != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Too many injectable constructors on ").append(class1.getName()).toString());
                }
                obj = constructor1;
            }
            j++;
        }
        Object obj1 = obj;
        if (obj == null)
        {
            if (arraylist1.isEmpty() && flag)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("No injectable members on ").append(class1.getName()).append(". Do you want to add an injectable constructor?").toString());
            }
            Object obj2;
            java.lang.reflect.Type atype[];
            Class class3;
            java.lang.annotation.Annotation aannotation[][];
            int k;
            int j1;
            int k1;
            try
            {
                obj1 = class1.getDeclaredConstructor(new Class[0]);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                nosuchmethodexception = ((NoSuchMethodException) (obj));
            }
        }
        if (obj1 != null)
        {
            obj2 = Keys.get(class1);
            ((Constructor) (obj1)).setAccessible(true);
            atype = ((Constructor) (obj1)).getGenericParameterTypes();
            k1 = atype.length;
            obj = obj2;
            j1 = k1;
            if (k1 != 0)
            {
                aannotation = ((Constructor) (obj1)).getParameterAnnotations();
                k = 0;
                do
                {
                    obj = obj2;
                    j1 = k1;
                    if (k >= atype.length)
                    {
                        break;
                    }
                    arraylist.add(Keys.get(atype[k], aannotation[k], obj1));
                    k++;
                } while (true);
            }
        } else
        {
            obj = null;
            j1 = 0;
            if (flag1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("No injectable constructor on @Singleton ").append(class1.getName()).toString());
            }
        }
        class3 = class1.getSuperclass();
        obj2 = class3;
        if (class3 != null)
        {
            if (Keys.isPlatformType(class3.getName()))
            {
                obj2 = null;
            } else
            {
                arraylist.add(Keys.getMembersKey(class3));
                obj2 = class3;
            }
        }
        return new ReflectiveAtInjectBinding(((String) (obj)), Keys.getMembersKey(class1), flag1, class1, (Field[])arraylist1.toArray(new Field[arraylist1.size()]), ((Constructor) (obj1)), j1, ((Class) (obj2)), (String[])arraylist.toArray(new String[arraylist.size()]));
    }

    private static Constructor[] getConstructorsForType(Class class1)
    {
        return (Constructor[])class1.getDeclaredConstructors();
    }

    public void attach(Linker linker)
    {
        int i = 0;
        for (int j = 0; j < fields.length; j++)
        {
            if (fieldBindings[j] == null)
            {
                fieldBindings[j] = linker.requestBinding(keys[i], fields[j]);
            }
            i++;
        }

        int l = i;
        if (constructor != null)
        {
            int k = 0;
            do
            {
                l = i;
                if (k >= parameterBindings.length)
                {
                    break;
                }
                if (parameterBindings[k] == null)
                {
                    parameterBindings[k] = linker.requestBinding(keys[i], constructor);
                }
                i++;
                k++;
            } while (true);
        }
        if (supertype != null && supertypeBinding == null)
        {
            supertypeBinding = linker.requestBinding(keys[l], membersKey, false);
        }
    }

    public Object get()
    {
        if (constructor == null)
        {
            throw new UnsupportedOperationException();
        }
        Object aobj[] = new Object[parameterBindings.length];
        for (int i = 0; i < parameterBindings.length; i++)
        {
            aobj[i] = parameterBindings[i].get();
        }

        Object obj;
        try
        {
            obj = constructor.newInstance(aobj);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException(invocationtargetexception.getCause());
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RuntimeException(instantiationexception);
        }
        injectMembers(obj);
        return obj;
    }

    public void injectMembers(Object obj)
    {
        int i = 0;
        do
        {
            try
            {
                if (i >= fields.length)
                {
                    break;
                }
                fields[i].set(obj, fieldBindings[i].get());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError(obj);
            }
            i++;
        } while (true);
        if (supertypeBinding != null)
        {
            supertypeBinding.injectMembers(obj);
        }
        return;
    }

    public String toString()
    {
        if (provideKey != null)
        {
            return provideKey;
        } else
        {
            return membersKey;
        }
    }
}
