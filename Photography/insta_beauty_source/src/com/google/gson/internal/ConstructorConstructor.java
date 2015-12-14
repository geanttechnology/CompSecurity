// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;

// Referenced classes of package com.google.gson.internal:
//            ObjectConstructor

public final class ConstructorConstructor
{

    private final Map instanceCreators;

    public ConstructorConstructor()
    {
        this(Collections.emptyMap());
    }

    public ConstructorConstructor(Map map)
    {
        instanceCreators = map;
    }

    private ObjectConstructor newDefaultConstructor(final Class constructor)
    {
        try
        {
            constructor = constructor.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible())
            {
                constructor.setAccessible(true);
            }
            constructor = new _cls2();
        }
        // Misplaced declaration of an exception variable
        catch (final Class constructor)
        {
            return null;
        }
        return constructor;
    }

    private ObjectConstructor newDefaultImplementationConstructor(Class class1)
    {
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                return new _cls3();
            }
            if (java/util/Set.isAssignableFrom(class1))
            {
                return new _cls4();
            }
            if (java/util/Queue.isAssignableFrom(class1))
            {
                return new _cls5();
            } else
            {
                return new _cls6();
            }
        }
        if (java/util/Map.isAssignableFrom(class1))
        {
            return new _cls7();
        } else
        {
            return null;
        }
    }

    private ObjectConstructor newUnsafeAllocator(final Type type, final Class rawType)
    {
        return new _cls8();
    }

    public ObjectConstructor get(final TypeToken creator)
    {
        final Type type = creator.getType();
        Class class1 = creator.getRawType();
        creator = (InstanceCreator)instanceCreators.get(type);
        if (creator != null)
        {
            creator = new _cls1();
        } else
        {
            ObjectConstructor objectconstructor = newDefaultConstructor(class1);
            creator = objectconstructor;
            if (objectconstructor == null)
            {
                ObjectConstructor objectconstructor1 = newDefaultImplementationConstructor(class1);
                creator = objectconstructor1;
                if (objectconstructor1 == null)
                {
                    return newUnsafeAllocator(type, class1);
                }
            }
        }
        return creator;
    }

    public String toString()
    {
        return instanceCreators.toString();
    }

    private class _cls2
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;
        final Constructor val$constructor;

        public Object construct()
        {
            Object obj;
            try
            {
                obj = constructor.newInstance(null);
            }
            catch (InstantiationException instantiationexception)
            {
                throw new RuntimeException((new StringBuilder()).append("Failed to invoke ").append(constructor).append(" with no args").toString(), instantiationexception);
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                throw new RuntimeException((new StringBuilder()).append("Failed to invoke ").append(constructor).append(" with no args").toString(), invocationtargetexception.getTargetException());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new AssertionError(illegalaccessexception);
            }
            return obj;
        }

        _cls2()
        {
            this$0 = ConstructorConstructor.this;
            constructor = constructor1;
            super();
        }
    }


    private class _cls3
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;

        public Object construct()
        {
            return new TreeSet();
        }

        _cls3()
        {
            this$0 = ConstructorConstructor.this;
            super();
        }
    }


    private class _cls4
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;

        public Object construct()
        {
            return new LinkedHashSet();
        }

        _cls4()
        {
            this$0 = ConstructorConstructor.this;
            super();
        }
    }


    private class _cls5
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;

        public Object construct()
        {
            return new LinkedList();
        }

        _cls5()
        {
            this$0 = ConstructorConstructor.this;
            super();
        }
    }


    private class _cls6
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;

        public Object construct()
        {
            return new ArrayList();
        }

        _cls6()
        {
            this$0 = ConstructorConstructor.this;
            super();
        }
    }


    private class _cls7
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;

        public Object construct()
        {
            return new LinkedHashMap();
        }

        _cls7()
        {
            this$0 = ConstructorConstructor.this;
            super();
        }
    }


    private class _cls8
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;
        private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
        final Class val$rawType;
        final Type val$type;

        public Object construct()
        {
            Object obj;
            try
            {
                obj = unsafeAllocator.newInstance(rawType);
            }
            catch (Exception exception)
            {
                throw new RuntimeException((new StringBuilder()).append("Unable to invoke no-args constructor for ").append(type).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
            }
            return obj;
        }

        _cls8()
        {
            this$0 = ConstructorConstructor.this;
            rawType = class1;
            type = type1;
            super();
        }
    }


    private class _cls1
        implements ObjectConstructor
    {

        final ConstructorConstructor this$0;
        final InstanceCreator val$creator;
        final Type val$type;

        public Object construct()
        {
            return creator.createInstance(type);
        }

        _cls1()
        {
            this$0 = ConstructorConstructor.this;
            creator = instancecreator;
            type = type1;
            super();
        }
    }

}
