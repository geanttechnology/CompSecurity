// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.utility.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksImageAdapter

class a
    implements e
{

    final List a;
    final LooksImageAdapter b;

    public volatile void a(Object obj)
    {
        a((Map)obj);
    }

    public void a(Map map)
    {
        if (map != null)
        {
            if (LooksImageAdapter.k() == null)
            {
                LooksImageAdapter.a(map);
            } else
            {
                map = new HashMap(map);
                map.keySet().removeAll(LooksImageAdapter.k().keySet());
                LooksImageAdapter.k().putAll(map);
            }
            map = a.iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                as as1 = (as)map.next();
                if (!LooksImageAdapter.k().containsKey(as1.a()))
                {
                    LooksImageAdapter.k().put(as1.a(), null);
                }
            } while (true);
        }
    }

    public void b(Object obj)
    {
    }

    public void c(Object obj)
    {
    }

    (LooksImageAdapter looksimageadapter, List list)
    {
        b = looksimageadapter;
        a = list;
        super();
    }
}
