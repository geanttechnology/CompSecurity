// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Exposed;
import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.Provider;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.internal.util.StackTraceElements;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.HasDependencies;
import com.google.inject.spi.ProviderInstanceBinding;
import com.google.inject.spi.ProviderWithExtensionVisitor;
import com.google.inject.spi.ProvidesMethodBinding;
import com.google.inject.spi.ProvidesMethodTargetVisitor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            Exceptions

public abstract class ProviderMethod
    implements HasDependencies, ProviderWithExtensionVisitor, ProvidesMethodBinding
{
    private static final class ReflectionProviderMethod extends ProviderMethod
    {

        Object doProvision(Object aobj[])
            throws IllegalAccessException, InvocationTargetException
        {
            return method.invoke(instance, aobj);
        }

        ReflectionProviderMethod(Key key1, Method method1, Object obj, ImmutableSet immutableset, List list, Class class1)
        {
            super(key1, method1, obj, immutableset, list, class1, null);
        }
    }


    private final ImmutableSet dependencies;
    private final boolean exposed;
    protected final Object instance;
    private final Key key;
    protected final Method method;
    private final List parameterProviders;
    private final Class scopeAnnotation;

    private ProviderMethod(Key key1, Method method1, Object obj, ImmutableSet immutableset, List list, Class class1)
    {
        key = key1;
        scopeAnnotation = class1;
        instance = obj;
        dependencies = immutableset;
        method = method1;
        parameterProviders = list;
        exposed = method1.isAnnotationPresent(com/google/inject/Exposed);
    }


    static ProviderMethod create(Key key1, Method method1, Object obj, ImmutableSet immutableset, List list, Class class1, boolean flag)
    {
        if (!Modifier.isPublic(method1.getModifiers()) || !Modifier.isPublic(method1.getDeclaringClass().getModifiers()))
        {
            method1.setAccessible(true);
        }
        return new ReflectionProviderMethod(key1, method1, obj, immutableset, list, class1);
    }

    public Object acceptExtensionVisitor(BindingTargetVisitor bindingtargetvisitor, ProviderInstanceBinding providerinstancebinding)
    {
        if (bindingtargetvisitor instanceof ProvidesMethodTargetVisitor)
        {
            return ((ProvidesMethodTargetVisitor)bindingtargetvisitor).visit(this);
        } else
        {
            return bindingtargetvisitor.visit(providerinstancebinding);
        }
    }

    public void configure(Binder binder)
    {
        binder = binder.withSource(method);
        if (scopeAnnotation != null)
        {
            binder.bind(key).toProvider(this).in(scopeAnnotation);
        } else
        {
            binder.bind(key).toProvider(this);
        }
        if (exposed)
        {
            ((PrivateBinder)binder).expose(key);
        }
    }

    abstract Object doProvision(Object aobj[])
        throws IllegalAccessException, InvocationTargetException;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ProviderMethod)
        {
            obj = (ProviderMethod)obj;
            flag = flag1;
            if (method.equals(((ProviderMethod) (obj)).method))
            {
                flag = flag1;
                if (instance.equals(((ProviderMethod) (obj)).instance))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public Object get()
    {
        Object aobj[] = new Object[parameterProviders.size()];
        for (int i = 0; i < aobj.length; i++)
        {
            aobj[i] = ((Provider)parameterProviders.get(i)).get();
        }

        Object obj;
        try
        {
            obj = doProvision(aobj);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw Exceptions.rethrowCause(invocationtargetexception);
        }
        return obj;
    }

    public Set getDependencies()
    {
        return dependencies;
    }

    public Object getEnclosingInstance()
    {
        return instance;
    }

    public Object getInstance()
    {
        return instance;
    }

    public Key getKey()
    {
        return key;
    }

    public Method getMethod()
    {
        return method;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            method
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("@Provides ").append(StackTraceElements.forMember(method)).toString();
    }
}
