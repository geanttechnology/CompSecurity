// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CircleType

final class a extends j
{

    final String a;

    protected CircleType a(d d1)
    {
        if (d1 == null || d1.b == null)
        {
            a(0x80000003);
            return null;
        }
        for (d1 = d1.b.iterator(); d1.hasNext();)
        {
            CircleType circletype = (CircleType)d1.next();
            if (circletype != null && circletype.defaultType != null && circletype.defaultType.equals(a))
            {
                return circletype;
            }
        }

        return null;
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    (String s)
    {
        a = s;
        super();
    }
}
