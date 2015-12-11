// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class BundleUtils
{

    private BundleUtils()
    {
    }

    public static Bundle constructEmptyBundleIfNull(Bundle bundle)
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        return bundle1;
    }

    public static void sanitizeSerializableOptions(Bundle bundle)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (obj instanceof Enum)
            {
                bundle.putString(s, obj.toString());
            }
        } while (true);
    }

    public static String toString(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder("[");
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); stringbuilder.append(s).append("=").append(bundle.get(s)).append(", "))
        {
            s = (String)iterator.next();
        }

        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public static Map toStringStringMap(Bundle bundle)
    {
        if (bundle != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Map) (obj));
_L2:
        HashMap hashmap = new HashMap();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            obj = hashmap;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (String)iterator.next();
            Object obj1 = bundle.get(((String) (obj)));
            if (obj1 instanceof String)
            {
                hashmap.put(obj, (String)obj1);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
