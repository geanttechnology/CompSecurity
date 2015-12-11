// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common.a;

import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.google.b.q;
import com.google.b.r;
import com.target.mothership.services.x;
import com.target.mothership.services.z;

// Referenced classes of package com.target.mothership.model.common.a:
//            e, c

public class a
    implements e
{

    private c defaultErrorCode;

    public a()
    {
        defaultErrorCode = c._ERR_UNKNOWN;
    }

    private c a(l l1)
    {
        return d(l1);
    }

    private c a(o o1)
    {
        if (o1.a("errors"))
        {
            o1 = o1.d("errors").a(0).m();
            if (o1.a("errorKey"))
            {
                return a(o1.c("errorKey").c());
            }
        }
        return defaultErrorCode;
    }

    private c a(String s)
    {
        c ac[] = com.target.mothership.model.common.a.c.values();
        int k = ac.length;
        for (int j = 0; j < k; j++)
        {
            c c1 = ac[j];
            if (c1.a().equals(s))
            {
                return c1;
            }
        }

        return defaultErrorCode;
    }

    private c b(l l1)
    {
        o o1 = l1.m();
        if (o1.a("Error"))
        {
            return c(l1);
        }
        if (o1.a("errors"))
        {
            return a(o1);
        } else
        {
            return defaultErrorCode;
        }
    }

    private c c(l l1)
    {
        return d(l1);
    }

    private c d(l l1)
    {
        l1 = l1.m();
        if (l1.a("Error"))
        {
            l1 = l1.e("Error");
            if (l1.a("Detail"))
            {
                l1 = l1.c("Detail");
                if (l1.r())
                {
                    return a(l1.c());
                }
            }
        }
        return defaultErrorCode;
    }

    public c a(x x1)
    {
        Object obj;
label0:
        {
            if (x1.a() == null)
            {
                return defaultErrorCode;
            }
            obj = new q();
            try
            {
                obj = ((q) (obj)).a(x1.a());
                if (((l) (obj)).j())
                {
                    break label0;
                }
                x1 = defaultErrorCode;
            }
            // Misplaced declaration of an exception variable
            catch (x x1)
            {
                return defaultErrorCode;
            }
            return x1;
        }
        if (x1.b().equals(z.FORBIDDEN))
        {
            return a(((l) (obj)));
        }
        if (x1.b().equals(z.UNAUTHORIZED))
        {
            return b(((l) (obj)));
        } else
        {
            return defaultErrorCode;
        }
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
