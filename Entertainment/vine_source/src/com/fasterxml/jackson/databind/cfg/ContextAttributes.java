// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ContextAttributes
{
    public static class Impl extends ContextAttributes
        implements Serializable
    {

        protected static final Impl EMPTY = new Impl(Collections.emptyMap());
        protected static final Object NULL_SURROGATE = new Object();
        private static final long serialVersionUID = 1L;
        protected transient Map _nonShared;
        protected final Map _shared;

        private Map _copy(Map map)
        {
            return new HashMap(map);
        }

        public static ContextAttributes getEmpty()
        {
            return EMPTY;
        }

        public Object getAttribute(Object obj)
        {
            if (_nonShared != null)
            {
                Object obj1 = _nonShared.get(obj);
                if (obj1 != null)
                {
                    obj = obj1;
                    if (obj1 == NULL_SURROGATE)
                    {
                        obj = null;
                    }
                    return obj;
                }
            }
            return _shared.get(obj);
        }

        protected ContextAttributes nonSharedInstance(Object obj, Object obj1)
        {
            HashMap hashmap = new HashMap();
            Object obj2 = obj1;
            if (obj1 == null)
            {
                obj2 = NULL_SURROGATE;
            }
            hashmap.put(obj, obj2);
            return new Impl(_shared, hashmap);
        }

        public ContextAttributes withPerCallAttribute(Object obj, Object obj1)
        {
            Object obj2;
label0:
            {
label1:
                {
                    obj2 = obj1;
                    if (obj1 == null)
                    {
                        obj1 = this;
                        if (!_shared.containsKey(obj))
                        {
                            break label1;
                        }
                        obj2 = NULL_SURROGATE;
                    }
                    if (_nonShared != null)
                    {
                        break label0;
                    }
                    obj1 = nonSharedInstance(obj, obj2);
                }
                return ((ContextAttributes) (obj1));
            }
            _nonShared.put(obj, obj2);
            return this;
        }

        public ContextAttributes withSharedAttribute(Object obj, Object obj1)
        {
            Object obj2;
            if (this == EMPTY)
            {
                obj2 = new HashMap(8);
            } else
            {
                obj2 = _copy(_shared);
            }
            ((Map) (obj2)).put(obj, obj1);
            return new Impl(((Map) (obj2)));
        }

        public ContextAttributes withSharedAttributes(Map map)
        {
            return new Impl(map);
        }

        public ContextAttributes withoutSharedAttribute(Object obj)
        {
            while (_shared.isEmpty() || !_shared.containsKey(obj)) 
            {
                return this;
            }
            if (_shared.size() == 1)
            {
                return EMPTY;
            } else
            {
                Map map = _copy(_shared);
                map.remove(obj);
                return new Impl(map);
            }
        }


        protected Impl(Map map)
        {
            _shared = map;
            _nonShared = null;
        }

        protected Impl(Map map, Map map1)
        {
            _shared = map;
            _nonShared = map1;
        }
    }


    public ContextAttributes()
    {
    }

    public static ContextAttributes getEmpty()
    {
        return Impl.getEmpty();
    }

    public abstract Object getAttribute(Object obj);

    public abstract ContextAttributes withPerCallAttribute(Object obj, Object obj1);

    public abstract ContextAttributes withSharedAttribute(Object obj, Object obj1);

    public abstract ContextAttributes withSharedAttributes(Map map);

    public abstract ContextAttributes withoutSharedAttribute(Object obj);
}
