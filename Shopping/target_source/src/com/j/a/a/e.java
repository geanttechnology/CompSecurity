// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import com.j.a.e.j;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            b

class e
    implements j
{

    final com.j.a.j a;
    final JSONObject b;
    final b c;

    e(b b1, com.j.a.j j1, JSONObject jsonobject)
    {
        c = b1;
        a = j1;
        b = jsonobject;
        super();
    }

    public void a(Exception exception)
    {
        w.b("Flushing App User Attributes", exception);
        com.j.a.a.b.a(c, b);
        com.j.a.a.b.a(c, a);
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Flushed App User Attributes!");
        if (jsonobject != null && jsonobject.length() > 0)
        {
            com.j.a.d.e.e().k().a(jsonobject);
        }
        if (a != null)
        {
            a.a();
        }
    }
}
