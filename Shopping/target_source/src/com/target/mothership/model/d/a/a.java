// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.d.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.d;
import com.target.mothership.model.guest.a.k;
import com.target.mothership.model.guest.a.l;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
    implements d
{

    public a()
    {
    }

    private List a()
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(c._ERR_UNKNOWN);
        return arraylist;
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }

    public List a(x x1)
    {
        if (x1 == null || x1.a() == null)
        {
            return a();
        }
        Object obj = (new com.target.mothership.model.common.a.a()).a(x1);
        if (obj != c._ERR_UNKNOWN)
        {
            x1 = new ArrayList(1);
            x1.add(obj);
            return x1;
        }
        obj = b.a().k();
        try
        {
            obj = (l)((f) (obj)).a(x1.a(), com/target/mothership/model/guest/a/l);
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            return a();
        }
        if (obj == null || ((l) (obj)).a() == null)
        {
            return a();
        }
        x1 = new ArrayList(((l) (obj)).a().size());
        for (obj = ((l) (obj)).a().iterator(); ((Iterator) (obj)).hasNext(); x1.add(((k)((Iterator) (obj)).next()).a())) { }
        return x1;
    }
}
