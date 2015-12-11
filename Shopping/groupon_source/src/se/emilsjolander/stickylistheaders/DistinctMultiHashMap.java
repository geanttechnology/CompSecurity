// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class DistinctMultiHashMap
{
    static interface IDMapper
    {

        public abstract Object keyToKeyId(Object obj);

        public abstract Object valueToValueId(Object obj);
    }


    private IDMapper mIDMapper;
    LinkedHashMap mKeyToValuesMap;
    LinkedHashMap mValueToKeyIndexer;

    DistinctMultiHashMap()
    {
        this(new IDMapper() {

            public Object keyToKeyId(Object obj)
            {
                return obj;
            }

            public Object valueToValueId(Object obj)
            {
                return obj;
            }

        });
    }

    DistinctMultiHashMap(IDMapper idmapper)
    {
        mKeyToValuesMap = new LinkedHashMap();
        mValueToKeyIndexer = new LinkedHashMap();
        mIDMapper = idmapper;
    }

    public void add(Object obj, Object obj1)
    {
        Object obj2 = mIDMapper.keyToKeyId(obj);
        if (mKeyToValuesMap.get(obj2) == null)
        {
            mKeyToValuesMap.put(obj2, new ArrayList());
        }
        obj2 = getKey(obj1);
        if (obj2 != null)
        {
            ((List)mKeyToValuesMap.get(mIDMapper.keyToKeyId(obj2))).remove(obj1);
        }
        mValueToKeyIndexer.put(mIDMapper.valueToValueId(obj1), obj);
        if (!containsValue((List)mKeyToValuesMap.get(mIDMapper.keyToKeyId(obj)), obj1))
        {
            ((List)mKeyToValuesMap.get(mIDMapper.keyToKeyId(obj))).add(obj1);
        }
    }

    protected boolean containsValue(List list, Object obj)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj1 = list.next();
            if (mIDMapper.valueToValueId(obj1).equals(mIDMapper.valueToValueId(obj)))
            {
                return true;
            }
        }

        return false;
    }

    public List get(Object obj)
    {
        return (List)mKeyToValuesMap.get(mIDMapper.keyToKeyId(obj));
    }

    public Object getKey(Object obj)
    {
        return mValueToKeyIndexer.get(mIDMapper.valueToValueId(obj));
    }
}
