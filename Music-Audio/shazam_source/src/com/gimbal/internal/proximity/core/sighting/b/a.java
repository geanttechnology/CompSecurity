// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.b;

import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.g.d;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.g;
import com.gimbal.internal.proximity.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting.b:
//            d, f, c, b, 
//            e

public class a
    implements com.gimbal.internal.proximity.core.sighting.b.d
{

    private static final b a = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/sighting/b/a.getSimpleName());
    private List b;
    private d c;
    private com.gimbal.internal.proximity.core.g.a d;
    private Map e;

    public a(g g, com.gimbal.internal.proximity.core.g.a a1, d d1, Map map)
    {
        c = d1;
        d = a1;
        e = map;
        b = new ArrayList();
        b.add(new f(c));
        b.add(new com.gimbal.internal.proximity.core.sighting.b.c(g));
        b.add(new com.gimbal.internal.proximity.core.sighting.b.b(g, d, e));
        b.add(new com.gimbal.internal.proximity.core.sighting.b.e(g, d, c, com.gimbal.internal.proximity.e.a().b, com.gimbal.internal.proximity.e.a().f));
    }

    public final boolean a(Sighting sighting)
    {
label0:
        {
            if (CollectionUtils.isEmpty(b))
            {
                break label0;
            }
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((com.gimbal.internal.proximity.core.sighting.b.d)iterator.next()).a(sighting));
            return true;
        }
        a.d("No resolver strategy resolved sighting [{}]", new Object[] {
            sighting
        });
        return false;
    }

}
