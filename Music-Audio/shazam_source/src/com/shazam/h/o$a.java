// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.h:
//            o

public static final class 
{

    int a;
    InputStream b;
    public Map c;

    public final  a(Map map)
    {
        if (map != null)
        {
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                List list = (List)map.get(s);
                if (s != null && list != null)
                {
                    c.put(s.toLowerCase(), list);
                }
            } while (true);
        }
        return this;
    }

    public final o a()
    {
        return new o(this, (byte)0);
    }

    public am()
    {
        a = -1;
        c = new HashMap();
    }
}
