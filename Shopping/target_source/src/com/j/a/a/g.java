// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import com.j.a.e.j;
import com.j.a.g.w;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            d

class g
    implements j
{

    final com.j.a.j a;
    final ArrayList b;
    final d c;

    g(d d1, com.j.a.j j1, ArrayList arraylist)
    {
        c = d1;
        a = j1;
        b = arraylist;
        super();
    }

    public void a(Exception exception)
    {
        w.b("Flushing Event Queue", exception);
        d.a(c).addAll(b);
        d.a(c, a);
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Flushed Event Queue!");
        if (a != null)
        {
            a.a();
        }
    }
}
