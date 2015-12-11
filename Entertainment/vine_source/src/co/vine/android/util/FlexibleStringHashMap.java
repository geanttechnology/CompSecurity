// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FlexibleStringHashMap extends HashMap
{

    private static final long serialVersionUID = 0xecdcd042260e56b3L;

    public FlexibleStringHashMap()
    {
    }

    public Object get(Object obj)
    {
        if (obj instanceof String)
        {
            Object obj1 = super.get(obj);
            if (obj1 != null)
            {
                return obj1;
            }
            for (Iterator iterator = keySet().iterator(); iterator.hasNext();)
            {
                Object obj2 = iterator.next();
                if (((String)obj).contains((CharSequence)obj2))
                {
                    return super.get(obj2);
                }
            }

            return null;
        } else
        {
            return super.get(obj);
        }
    }
}
