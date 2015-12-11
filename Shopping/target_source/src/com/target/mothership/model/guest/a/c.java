// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.g;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.a:
//            p, l, k

public class c
    implements g
{

    public c()
    {
    }

    private p a(x x1, com.target.mothership.model.guest.interfaces.a.a a1, String s)
    {
        p p1 = new p();
        p1.a(x1);
        p1.a(a1);
        x1 = new ArrayList(1);
        x1.add(a1);
        p1.a(x1);
        p1.a(s);
        return p1;
    }

    private com.target.mothership.model.guest.interfaces.a.c b(x x1)
    {
        p p1 = new p();
        p1.a(x1);
        x1 = new ArrayList();
        com.target.mothership.model.guest.interfaces.a.a a1 = com.target.mothership.model.guest.interfaces.a.a.ERR_UNKNOWN;
        x1.add(a1);
        p1.a(x1);
        p1.a(a1);
        return p1;
    }

    public com.target.mothership.model.guest.interfaces.a.c a(x x1)
    {
        if (x1.a() == null)
        {
            return b(x1);
        }
        Object obj = (new a()).a(x1);
        if (obj != com.target.mothership.model.common.a.c._ERR_UNKNOWN)
        {
            return a(x1, com.target.mothership.model.guest.interfaces.a.a.a(((com.target.mothership.model.common.a.c) (obj))), null);
        }
        Object obj1 = com.target.mothership.b.a().k();
        try
        {
            obj = (l)((f) (obj1)).a(x1.a(), com/target/mothership/model/guest/a/l);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (obj != null && ((l) (obj)).a() != null && !((l) (obj)).a().isEmpty())
        {
            obj1 = com.target.mothership.model.guest.interfaces.a.a.a(((k)((l) (obj)).a().get(0)).a());
            obj = null;
        } else
        {
            try
            {
                obj = (k)((f) (obj1)).a(x1.a(), com/target/mothership/model/guest/a/k);
            }
            catch (Exception exception)
            {
                return b(x1);
            }
            obj1 = com.target.mothership.model.guest.interfaces.a.a.a(((k) (obj)).a());
            obj = ((k) (obj)).b();
        }
        return a(x1, ((com.target.mothership.model.guest.interfaces.a.a) (obj1)), ((String) (obj)));
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
