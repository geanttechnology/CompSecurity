// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, y, v, he

final class a
    implements ce
{

    final y a;

    public final void a(he he, Map map)
    {
        if (a.a(map) && map.containsKey("isVisible"))
        {
            boolean flag;
            if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            he = a;
            flag = Boolean.valueOf(flag).booleanValue();
            he = ((y) (he)).e.iterator();
            while (he.hasNext()) 
            {
                ((v)he.next()).a(flag);
            }
        }
    }

    (y y1)
    {
        a = y1;
        super();
    }
}
