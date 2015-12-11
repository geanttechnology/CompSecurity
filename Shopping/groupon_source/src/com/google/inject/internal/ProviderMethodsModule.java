// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.HierarchyTraversalFilter;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Message;
import com.google.inject.util.Modules;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.HashMultimap;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Multimap;

// Referenced classes of package com.google.inject.internal:
//            Errors, UniqueAnnotations, Annotations, ProviderMethod

public final class ProviderMethodsModule
    implements Module
{
    private static final class LogProvider
        implements Provider
    {

        private final String name;

        public volatile Object get()
        {
            return get();
        }

        public Logger get()
        {
            return Logger.getLogger(name);
        }

        public LogProvider(Method method)
        {
            name = (new StringBuilder()).append(method.getDeclaringClass().getName()).append(".").append(method.getName()).toString();
        }
    }

    private final class Signature
    {

        final int hashCode;
        final String name;
        final Class parameters[];
        final ProviderMethodsModule this$0;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof Signature)
            {
                obj = (Signature)obj;
                flag = flag1;
                if (((Signature) (obj)).name.equals(name))
                {
                    flag = flag1;
                    if (Arrays.equals(parameters, ((Signature) (obj)).parameters))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return hashCode;
        }

        Signature(Method method)
        {
            this$0 = ProviderMethodsModule.this;
            super();
            name = method.getName();
            providermethodsmodule = typeLiteral.getParameterTypes(method);
            parameters = new Class[size()];
            for (providermethodsmodule = iterator(); hasNext();)
            {
                method = (TypeLiteral)next();
                parameters[0] = method.getRawType();
            }

            hashCode = name.hashCode() + Arrays.hashCode(parameters) * 31;
        }
    }


    private static final Key LOGGER_KEY = Key.get(java/util/logging/Logger);
    private final Object _flddelegate;
    private HierarchyTraversalFilter filter;
    private final boolean skipFastClassGeneration;
    private final TypeLiteral typeLiteral;

    private ProviderMethodsModule(Object obj, boolean flag)
    {
        _flddelegate = Preconditions.checkNotNull(obj, "delegate");
        typeLiteral = TypeLiteral.get(_flddelegate.getClass());
        filter = Guice.createHierarchyTraversalFilter();
        skipFastClassGeneration = flag;
    }

    private ProviderMethod createProviderMethod(Binder binder, Method method)
    {
        Binder binder1 = binder.withSource(method);
        Object obj = new Errors(method);
        java.util.ArrayList arraylist = Lists.newArrayList();
        java.util.ArrayList arraylist1 = Lists.newArrayList();
        List list = typeLiteral.getParameterTypes(method);
        Annotation aannotation[][] = method.getParameterAnnotations();
        for (int i = 0; i < list.size(); i++)
        {
            Key key = getKey(((Errors) (obj)), (TypeLiteral)list.get(i), method, aannotation[i]);
            binder = key;
            if (key.equals(LOGGER_KEY))
            {
                binder = Key.get(java/util/logging/Logger, UniqueAnnotations.create());
                binder1.bind(binder).toProvider(new LogProvider(method));
            }
            arraylist.add(Dependency.get(binder));
            arraylist1.add(binder1.getProvider(binder));
        }

        binder = getKey(((Errors) (obj)), typeLiteral.getReturnType(method), method, method.getAnnotations());
        Class class1 = Annotations.findScopeAnnotation(((Errors) (obj)), method.getAnnotations());
        for (obj = ((Errors) (obj)).getMessages().iterator(); ((Iterator) (obj)).hasNext(); binder1.addError((Message)((Iterator) (obj)).next())) { }
        return ProviderMethod.create(binder, method, _flddelegate, ImmutableSet.copyOf(arraylist), arraylist1, class1, skipFastClassGeneration);
    }

    public static Module forModule(Module module)
    {
        return forObject(module, false);
    }

    public static Module forObject(Object obj)
    {
        return forObject(obj, true);
    }

    private static Module forObject(Object obj, boolean flag)
    {
        if (obj instanceof ProviderMethodsModule)
        {
            return Modules.EMPTY_MODULE;
        } else
        {
            return new ProviderMethodsModule(obj, flag);
        }
    }

    private static boolean isProvider(Method method)
    {
        return !method.isBridge() && !method.isSynthetic() && method.isAnnotationPresent(com/google/inject/Provides);
    }

    private static boolean overrides(Method method, Method method1)
    {
        int i = method1.getModifiers();
        if (Modifier.isPublic(i) || Modifier.isProtected(i))
        {
            return true;
        }
        if (Modifier.isPrivate(i))
        {
            return false;
        } else
        {
            return method.getDeclaringClass().getPackage().equals(method1.getDeclaringClass().getPackage());
        }
    }

    public void configure(Binder binder)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = getProviderMethods(binder).iterator(); iterator.hasNext(); ((ProviderMethod)iterator.next()).configure(binder)) { }
        break MISSING_BLOCK_LABEL_43;
        binder;
        throw binder;
        this;
        JVM INSTR monitorexit ;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof ProviderMethodsModule) && ((ProviderMethodsModule)obj)._flddelegate == _flddelegate;
    }

    Key getKey(Errors errors, TypeLiteral typeliteral, Member member, Annotation aannotation[])
    {
        errors = Annotations.findBindingAnnotation(errors, member, aannotation);
        if (errors == null)
        {
            return Key.get(typeliteral);
        } else
        {
            return Key.get(typeliteral, errors);
        }
    }

    public List getProviderMethods(Binder binder)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        HashMultimap hashmultimap = HashMultimap.create();
        filter.reset();
label0:
        for (Class class1 = _flddelegate.getClass(); filter.isWorthScanningForMethods(com/google/inject/Provides.getName(), class1); class1 = class1.getSuperclass())
        {
            Iterator iterator1 = filter.getAllMethods(com/google/inject/Provides.getName(), class1).iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
                Method method1 = (Method)iterator1.next();
                if ((method1.getModifiers() & 0xa) == 0 && !method1.isBridge() && !method1.isSynthetic())
                {
                    hashmultimap.put(new Signature(method1), method1);
                }
                if (isProvider(method1))
                {
                    arraylist.add(createProviderMethod(binder, method1));
                }
            } while (true);
        }

        Iterator iterator = arraylist.iterator();
label1:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Method method = ((ProviderMethod)iterator.next()).getMethod();
            Iterator iterator2 = hashmultimap.get(new Signature(method)).iterator();
            Method method2;
            do
            {
                if (!iterator2.hasNext())
                {
                    continue label1;
                }
                method2 = (Method)iterator2.next();
            } while (method2.getDeclaringClass().isAssignableFrom(method.getDeclaringClass()) || !overrides(method2, method));
            binder.addError("Overriding @Provides methods is not allowed.\n\t@Provides method: %s\n\toverridden by: %s", new Object[] {
                method, method2
            });
        } while (true);
        return arraylist;
    }

    public int hashCode()
    {
        return _flddelegate.hashCode();
    }


}
