// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableMap, Iterables, ImmutableSet, Iterators, 
//            UnmodifiableIterator, ImmutableMapEntrySet, Maps

final class ImmutableEnumMap extends ImmutableMap
{

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

    ImmutableSet createEntrySet()
    {
        return new ImmutableMapEntrySet() {

            final ImmutableEnumMap this$0;

            public volatile Iterator iterator()
            {
                return iterator();
            }

            public UnmodifiableIterator iterator()
            {
                return new UnmodifiableIterator() {

                    private final Iterator backingIterator;
                    final _cls2 this$1;

                    public boolean hasNext()
                    {
                        return backingIterator.hasNext();
                    }

                    public volatile Object next()
                    {
                        return next();
                    }

                    public java.util.Map.Entry next()
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)backingIterator.next();
                        return Maps.immutableEntry(entry.getKey(), entry.getValue());
                    }

            
            {
                this$1 = _cls2.this;
                super();
                backingIterator = _flddelegate.entrySet().iterator();
            }
                };
            }

            ImmutableMap map()
            {
                return ImmutableEnumMap.this;
            }

            
            {
                this$0 = ImmutableEnumMap.this;
                super();
            }
        };
    }

    ImmutableSet createKeySet()
    {
        return new ImmutableSet() {

            final ImmutableEnumMap this$0;

            public boolean contains(Object obj)
            {
                return _flddelegate.containsKey(obj);
            }

            boolean isPartialView()
            {
                return true;
            }

            public volatile Iterator iterator()
            {
                return iterator();
            }

            public UnmodifiableIterator iterator()
            {
                return Iterators.unmodifiableIterator(_flddelegate.keySet().iterator());
            }

            public int size()
            {
                return ImmutableEnumMap.this.size();
            }

            
            {
                this$0 = ImmutableEnumMap.this;
                super();
            }
        };
    }

    public Object get(Object obj)
    {
        return _flddelegate.get(obj);
    }

    boolean isPartialView()
    {
        return false;
    }

    public int size()
    {
        return _flddelegate.size();
    }

}
