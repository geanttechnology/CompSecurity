// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableMap, Iterables, Maps, Iterators, 
//            UnmodifiableIterator

final class ImmutableEnumMap extends ImmutableMap.IteratorBasedImmutableMap
{
    private static class EnumSerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        final EnumMap _flddelegate;

        Object readResolve()
        {
            return new ImmutableEnumMap(_flddelegate);
        }

        EnumSerializedForm(EnumMap enummap)
        {
            _flddelegate = enummap;
        }
    }


    private final transient EnumMap _flddelegate;

    private ImmutableEnumMap(EnumMap enummap)
    {
        _flddelegate = enummap;
        boolean flag;
        if (!enummap.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
    }


    static ImmutableMap asImmutable(EnumMap enummap)
    {
        switch (enummap.size())
        {
        default:
            return new ImmutableEnumMap(enummap);

        case 0: // '\0'
            return ImmutableMap.of();

        case 1: // '\001'
            enummap = (java.util.Map.Entry)Iterables.getOnlyElement(enummap.entrySet());
            break;
        }
        return ImmutableMap.of(enummap.getKey(), enummap.getValue());
    }

    public boolean containsKey(Object obj)
    {
        return _flddelegate.containsKey(obj);
    }

    UnmodifiableIterator entryIterator()
    {
        return Maps.unmodifiableEntryIterator(_flddelegate.entrySet().iterator());
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        Object obj1 = obj;
        if (obj instanceof ImmutableEnumMap)
        {
            obj1 = ((ImmutableEnumMap)obj)._flddelegate;
        }
        return _flddelegate.equals(obj1);
    }

    public Object get(Object obj)
    {
        return _flddelegate.get(obj);
    }

    boolean isPartialView()
    {
        return false;
    }

    UnmodifiableIterator keyIterator()
    {
        return Iterators.unmodifiableIterator(_flddelegate.keySet().iterator());
    }

    public int size()
    {
        return _flddelegate.size();
    }

    Object writeReplace()
    {
        return new EnumSerializedForm(_flddelegate);
    }
}
