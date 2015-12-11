// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            BiMap, HashBiMap, Hashing, Maps, 
//            AbstractMapEntry

private final class <init> extends AbstractMap
    implements BiMap, Serializable
{
    class InverseEntry extends AbstractMapEntry
    {

        HashBiMap.BiEntry _flddelegate;
        final _cls1 this$3;

        public Object getKey()
        {
            return _flddelegate.value;
        }

        public Object getValue()
        {
            return _flddelegate.key;
        }

        public Object setValue(Object obj)
        {
            Object obj1 = _flddelegate.key;
            int i = Hashing.smearedHash(obj);
            if (i == _flddelegate.keyHash && Objects.equal(obj, obj1))
            {
                return obj;
            }
            class _cls1 extends HashBiMap.Itr
            {

                final _cls1 this$2;

                volatile Object output(HashBiMap.BiEntry bientry)
                {
                    return output(bientry);
                }

                java.util.Map.Entry output(HashBiMap.BiEntry bientry)
                {
                    return new InverseEntry(bientry);
                }

            
            {
                this$2 = _cls1.this;
                super(this$0);
            }
            }

            class _cls1 extends Maps.EntrySet
            {

                final HashBiMap.Inverse this$1;

                public Iterator iterator()
                {
                    return new _cls1();
                }

                Map map()
                {
                    return HashBiMap.Inverse.this;
                }

            
            {
                this$1 = HashBiMap.Inverse.this;
                super();
            }
            }

            boolean flag;
            if (HashBiMap.access$300(this$0, obj, i) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "value already present: %s", new Object[] {
                obj
            });
            HashBiMap.access$200(this$0, _flddelegate);
            obj = new HashBiMap.BiEntry(obj, i, _flddelegate.value, _flddelegate.valueHash);
            _flddelegate = ((HashBiMap.BiEntry) (obj));
            HashBiMap.access$500(this$0, ((HashBiMap.BiEntry) (obj)), null);
            expectedModCount = HashBiMap.access$100(this$0);
            return obj1;
        }

        InverseEntry(HashBiMap.BiEntry bientry)
        {
            this$3 = _cls1.this;
            super();
            _flddelegate = bientry;
        }
    }

    private final class InverseKeySet extends Maps.KeySet
    {

        final HashBiMap.Inverse this$1;

        public Iterator iterator()
        {
            return new HashBiMap.Itr() {

                final InverseKeySet this$2;

                Object output(HashBiMap.BiEntry bientry)
                {
                    return bientry.value;
                }

            
            {
                this$2 = InverseKeySet.this;
                super(this$0);
            }
            };
        }

        public boolean remove(Object obj)
        {
            obj = HashBiMap.access$400(this$0, obj, Hashing.smearedHash(obj));
            if (obj == null)
            {
                return false;
            } else
            {
                HashBiMap.access$200(this$0, ((HashBiMap.BiEntry) (obj)));
                return true;
            }
        }

        InverseKeySet()
        {
            this$1 = HashBiMap.Inverse.thi