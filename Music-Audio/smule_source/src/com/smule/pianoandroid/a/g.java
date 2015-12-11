// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.smule.android.c.aa;
import com.smule.pianoandroid.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.a:
//            e, c, a

class g extends e
{

    protected List a;

    private g()
    {
        super(null);
        a = new ArrayList();
    }

    g(c._cls1 _pcls1)
    {
        this();
    }

    public a a_(Map map)
    {
        if (map.size() == 1) goto _L2; else goto _L1
_L1:
        aa.b(c.a(), (new StringBuilder()).append("Expected one condition key. Got : ").append(map).toString());
        map = null;
_L4:
        return map;
_L2:
        Iterator iterator = ((List)map.get((String)map.keySet().iterator().next())).iterator();
        do
        {
            map = this;
            if (!iterator.hasNext())
            {
                continue;
            }
            map = (Map)iterator.next();
            map = c.a().a(map);
            if (map != null)
            {
                a.add(map);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
