// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.b;
import com.target.mothership.services.apigee.d.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ad
{
    public static class a
        implements k
    {

        public ad a(l l1, Type type, j j)
            throws p
        {
            type = new ad();
            b.a().k();
            j = l1.m();
            l1 = new ArrayList();
            if (j.a("orderItem"))
            {
                for (j = j.d("orderItem").iterator(); j.hasNext(); l1.add(d.a(((l)j.next()).m()))) { }
            }
            ad.a(type, l1);
            return type;
        }

        public Object deserialize(l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public a()
        {
        }
    }


    private List mItems;

    public ad()
    {
    }

    static List a(ad ad1, List list)
    {
        ad1.mItems = list;
        return list;
    }

    public List a()
    {
        return mItems;
    }
}
