// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.w;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            j, a

class bb
    implements com.a.a.o.b
{

    final Date a;
    final j b;
    final a c;

    bb(a a1, Date date, j j1)
    {
        c = a1;
        a = date;
        b = j1;
        super();
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Flushed App User!", a);
        b.a(jsonobject);
    }

    public void onResponse(Object obj)
    {
        a((JSONObject)obj);
    }
}
