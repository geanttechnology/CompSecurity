// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ForwardingMap, ClassToInstanceMap, ImmutableMap

public final class ImmutableClassToInstanceMap extends ForwardingMap
    implements ClassToInstanceMap, Serializable
{
    public static final class Builder
    {

        private final ImmutableMap.Builder mapBuilder = ImmutableMap.builder();

        private static Object cast(Class class1, Object obj)
        {
            return Primitives.wrap(class1).cast(obj);
        }

        public ImmutableClassToInstanceMap build()
        {
            ImmutableMap immutablemap = mapBuilder.build();
            if (immutablemap.isEmpty())
            {
                return ImmutableClassToInstanceMap.of();
            } else
            {
                return new ImmutableClassToInstanceMap(immutablemap);
            }
        }

        public Builder put(Class class1, Object obj)
        {
            mapBuilder.put(class1, obj);
            return this;
        }

        public Builder putAll(Map map)
        {
            Class class1;
            Object obj;
            for (map = map.entrySet().iterator(); map.hasNext(); mapBuilder.put(class1, cast(class1, obj)))
            {
                obj = (java.util.Map.Entry)map.next();
                class1 = (Class)((java.util.Map.Entry) (obj)).getKey();
                obj = ((java.util.Map.Entry) (obj)).getValue();
            }

            return this;
        }

        public Builder()
        {
        }
    }


    private static final ImmutableClassToInstanceMap EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
    private final ImmutableMap _flddelegate;

    private ImmutableClassToInstanceMap(ImmutableMap immutablemap)
    {
        _flddelegate = immutablemap;
    }


    public static Builder builder()
    {
        return new Builder();
    }

    public static ImmutableClassToInstanceMap copyOf(Map map)
    {
        if (map instanceof ImmutableClassToInstanceMap)
        {
            return (ImmutableClassToInstanceMap)map;
        } else
        {
            return (new Builder()).putAll(map).build();
        }
    }

    public static ImmutableClassToInstanceMap of()
    {
        return EMPTY;
    }

    public static ImmutableClassToInstanceMap of(Class class1, Object obj)
    {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(class1, obj));
    }

    protected volatile Object _mthdelegate()
    {
        return _mthdelegate();
    }

    protected Map _mthdelegate()
    {
        return _flddelegate;
    }

    public Object getInstance(Class class1)
    {
        return _flddelegate.get(Preconditions.checkNotNull(class1));
    }

    public Object putInstance(Class class1, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    Object readResolve()
    {
        ImmutableClassToInstanceMap immutableclasstoinstancemap = this;
        if (isEmpty())
        {
            immutableclasstoinstancemap = of();
        }
        return immutableclasstoinstancemap;
    }

}
