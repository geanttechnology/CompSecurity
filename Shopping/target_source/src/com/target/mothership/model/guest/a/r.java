// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.a.m;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.a:
//            m, l, k

public class r
    implements g
{

    private h mErrorSetTransformer;
    private com.target.mothership.model.guest.a.m mGuestErrorSetTransformer;

    public r()
    {
        mGuestErrorSetTransformer = new com.target.mothership.model.guest.a.m();
    }

    private m b(x x1)
    {
        m m1 = new m();
        m1.a(x1);
        x1 = new ArrayList();
        x1.add(com.target.mothership.model.guest.interfaces.a.m.a.ERR_UNKNOWN);
        m1.a(x1);
        m1.a(com.target.mothership.model.guest.interfaces.a.m.a.ERR_UNKNOWN);
        return m1;
    }

    public m a(x x1)
    {
        if ((new a()).a(x1) != c._ERR_UNKNOWN)
        {
            mErrorSetTransformer = new h(mGuestErrorSetTransformer, new m());
            return (m)mErrorSetTransformer.a(x1);
        }
        Object obj = new m();
        Object obj1 = com.target.mothership.b.a().k();
        Object obj2;
        try
        {
            obj2 = (l)((f) (obj1)).a(x1.a(), com/target/mothership/model/guest/a/l);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return b(x1);
        }
        if (obj2 == null || ((l) (obj2)).a() == null)
        {
            return b(x1);
        }
        obj1 = ((l) (obj2)).a();
        if (obj1 == null || ((List) (obj1)).isEmpty())
        {
            return b(x1);
        }
        obj2 = new ArrayList(((l) (obj2)).a().size());
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj2)).add(com.target.mothership.model.guest.interfaces.a.m.a.a((k)((Iterator) (obj1)).next()))) { }
        ((m) (obj)).a(x1);
        ((m) (obj)).a(((List) (obj2)));
        ((m) (obj)).a((j)((List) (obj2)).get(0));
        return ((m) (obj));
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
