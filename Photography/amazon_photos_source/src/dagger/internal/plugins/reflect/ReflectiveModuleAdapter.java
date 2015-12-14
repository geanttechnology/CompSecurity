// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.plugins.reflect;

import dagger.Module;
import dagger.Provides;
import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.SetBinding;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import javax.inject.Singleton;

final class ReflectiveModuleAdapter extends ModuleAdapter
{
    private final class ProviderMethodBinding extends Binding
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

        public ProviderMethodBinding(Method method1, String s, Object obj)
        {
            this$0 = ReflectiveModuleAdapter.this;
            super(s, null, method1.isAnnotationPresent(javax/inject/Singleton), method1);
            method = method1;
            instance = obj;
            method1.setAccessible(true);
        }
    }


    final Class moduleClass;

    public ReflectiveModuleAdapter(Class class1, Module module)
    {
        super(toMemberKeys(module.entryPoints()), module.staticInjections(), module.overrides(), module.includes(), module.complete());
        moduleClass = class1;
    }

    private void handleBindings(Map map, Method method, String s)
    {
        map.put(s, new ProviderMethodBinding(method, s, module));
    }

    private void handleSetBindings(Map map, Method method, String s)
    {
        SetBinding.add(map, Keys.getElementKey(method.getGenericReturnType(), method.getAnnotations(), method), new ProviderMethodBinding(method, s, module));
    }

    private static String[] toMemberKeys(Class aclass[])
    {
        String as[] = new String[aclass.length];
        for (int i = 0; i < aclass.length; i++)
        {
            as[i] = Keys.getMembersKey(aclass[i]);
        }

        return as;
    }

    public void getBindings(Map map)
    {
        Class class1 = moduleClass;
_L6:
        Method amethod[];
        int i;
        int j;
        if (class1 == java/lang/Object)
        {
            break; /* Loop/switch isn't completed */
        }
        amethod = class1.getDeclaredMethods();
        j = amethod.length;
        i = 0;
_L2:
        Method method;
        String s;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        method = amethod[i];
        Provides provides = (Provides)method.getAnnotation(dagger/Provides);
        if (provides != null)
        {
            s = Keys.get(method.getGenericReturnType(), method.getAnnotations(), method);
            static class _cls1
            {

                static final int $SwitchMap$dagger$Provides$Type[];

                static 
                {
                    $SwitchMap$dagger$Provides$Type = new int[dagger.Provides.Type.values().length];
                    try
                    {
                        $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.UNIQUE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.SET.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.dagger.Provides.Type[provides.type().ordinal()])
            {
            default:
                throw new AssertionError((new StringBuilder()).append("Unknown @Provides type ").append(provides.type()).toString());

            case 2: // '\002'
                break; /* Loop/switch isn't completed */

            case 1: // '\001'
                handleBindings(map, method, s);
                break;
            }
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        handleSetBindings(map, method, s);
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        class1 = class1.getSuperclass();
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected Object newModule()
    {
        Object obj;
        try
        {
            obj = moduleClass.getDeclaredConstructor(new Class[0]);
            ((Constructor) (obj)).setAccessible(true);
            obj = ((Constructor) (obj)).newInstance(new Object[0]);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new IllegalArgumentException(invocationtargetexception.getCause());
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Failed to construct ").append(moduleClass.getName()).toString(), nosuchmethodexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Failed to construct ").append(moduleClass.getName()).toString(), instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError();
        }
        return obj;
    }
}
