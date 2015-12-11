// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import java.util.HashMap;

class DualHashMap
{

    HashMap mKeyToValue;
    HashMap mValueToKey;

    DualHashMap()
    {
        mKeyToValue = new HashMap();
        mValueToKey = new HashMap();
    }

    public Object get(Object obj)
    {
        return mKeyToValue.get(obj);
    }

    public Object getKey(Object obj)
    {
        return mValueToKey.get(obj);
    }

    public void put(Object obj, Object obj1)
    {
        remove(obj);
        removeByValue(obj1);
        mKeyToValue.put(obj, obj1);
        mValueToKey.put(obj1, obj);
    }

    public void remove(Object obj)
    {
        if (get(obj) != null)
        {
            mValueToKey.remove(get(obj));
        }
        mKeyToValue.remove(obj);
    }

    public void removeByValue(Object obj)
    {
        if (getKey(obj) != null)
        {
            mKeyToValue.remove(getKey(obj));
        }
        mValueToKey.remove(obj);
    }
}
