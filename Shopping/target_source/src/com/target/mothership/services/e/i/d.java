// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.i;

import com.google.b.f;
import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.google.b.q;
import com.target.mothership.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.e.b.a.s;
import com.target.mothership.services.e.f.b.a;
import com.target.mothership.services.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
    implements aa
{

    public d()
    {
    }

    public a a(v v1)
    {
        f f1 = b.a().k();
        a a1 = new a();
        Object obj = (new q()).a(v1.a()).n();
        v1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        obj = ((i) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            o o1 = ((l)((Iterator) (obj)).next()).m();
            if (o1.b("cartwheelOffer") != null)
            {
                arraylist.add(f1.a(o1.b("cartwheelOffer"), com/target/mothership/services/e/e/b/a/b));
            } else
            if (o1.b("product") != null)
            {
                v1.add(f1.a(o1.b("product"), com/target/mothership/services/e/e/b/a/s));
            }
        } while (true);
        a1.b(arraylist);
        a1.a(v1);
        return a1;
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }
}
