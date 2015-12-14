// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            d

class a extends m
{

    final ArrayList a;
    final com.cyberlink.beautycircle.utility.d b;

    protected void a()
    {
        Globals.a("listAllCircles cancelled");
        a(0x80000005);
    }

    protected void a(int i)
    {
        Globals.a("Network error");
        e.e(new Object[] {
            Integer.valueOf(i)
        });
    }

    protected void a(d d1)
    {
        if (d1 == null || d1.b == null || d1.b.isEmpty())
        {
            a(0x80000003);
            return;
        }
        CircleType circletype;
        for (d1 = d1.b.iterator(); d1.hasNext(); a.add(circletype))
        {
            circletype = (CircleType)d1.next();
        }

        d.a(b, a);
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    k.d(com.cyberlink.beautycircle.utility.d d1, ArrayList arraylist)
    {
        b = d1;
        a = arraylist;
        super();
    }
}
