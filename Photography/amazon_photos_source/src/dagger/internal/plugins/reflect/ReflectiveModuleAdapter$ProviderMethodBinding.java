// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.plugins.reflect;

import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.inject.Singleton;

// Referenced classes of package dagger.internal.plugins.reflect:
//            ReflectiveModuleAdapter

private final class instance extends Binding
{

    private final Object instance;
    private final Method method;
    private Binding parameters[];
    final ReflectiveModuleAdapter this$0;

    public void attach(Linker linker)
    {
        java.lang.reflect.Type atype[] = method.getGenericParameterTypes();
        java.lang.annotation.Annotation aannotation[][] = method.getParameterAnnotations();
        parameters = new Binding[atype.length];
        for (int i = 0; i < parameters.length; i++)
        {
            String s = Keys.get(atype[i], aannotation[i], (new StringBuilder()).append(method).append(" parameter ").append(i).toString());
            parameters[i] = linker.requestBinding(s, method);
        }

    }

    public Object get()
    {
        Object aobj[] = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++)
        {
            aobj[i] = parameters[i].get();
        }

        Object obj;
        try
        {
            obj = method.invoke(instance, aobj);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException(invocationtargetexception.getCause());
        }
        return obj;
    }

    public String toString()
    {
        return method.toString();
    }

    public (Method method1, String s, Object obj)
    {
        this$0 = ReflectiveModuleAdapter.this;
        super(s, null, method1.isAnnotationPresent(javax/inject/Singleton), method1);
        method = method1;
        instance = obj;
        method1.setAccessible(true);
    }
}
