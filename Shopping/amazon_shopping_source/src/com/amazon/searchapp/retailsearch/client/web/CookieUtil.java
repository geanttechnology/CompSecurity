// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            CollectionMap

public class CookieUtil
{

    public CookieUtil()
    {
    }

    public static String createRequestHeader(CollectionMap collectionmap)
    {
        if (collectionmap.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(256);
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)collectionmap.next();
            Iterator iterator = ((List)entry.getValue()).iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(";");
                }
                stringbuilder.append((String)entry.getKey()).append("=").append(s);
            }
        }

        return stringbuilder.toString();
    }
}
