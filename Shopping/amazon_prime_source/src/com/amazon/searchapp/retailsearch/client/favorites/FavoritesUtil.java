// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.favorites:
//            FavoritesParameter

public final class FavoritesUtil
{

    public FavoritesUtil()
    {
    }

    public static void setParameters(CollectionMap collectionmap, String s, List list, String s1)
    {
        if (s != null)
        {
            collectionmap.set(FavoritesParameter.CONFIGURATION.getName(), s);
        }
        if (list != null && !list.isEmpty())
        {
            s = new StringBuilder();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                String s2 = (String)list.next();
                if (s2 != null)
                {
                    if (s.length() > 0)
                    {
                        s.append(',');
                    }
                    s.append(s2);
                }
            } while (true);
            collectionmap.set(FavoritesParameter.ITEMS.getName(), s.toString());
        }
        if (s1 != null)
        {
            collectionmap.set(FavoritesParameter.REQUEST_TOKEN.getName(), s1);
        }
    }
}
