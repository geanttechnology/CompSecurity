// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.c.e;
import com.j.a.g.h;
import com.j.a.g.w;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            i, a

class ba
    implements com.a.a.o.b
{

    final Date a;
    final i b;
    final a c;

    ba(a a1, Date date, i j)
    {
        c = a1;
        a = date;
        b = j;
        super();
    }

    public void a(JSONObject jsonobject)
    {
        w.a("Got Properties Response!", a);
        try
        {
            e e1 = new e(jsonobject);
            b.a(e1);
            h.a().a(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            w.b("Parsing TLProperties", jsonobject);
        }
        b.a(jsonobject);
    }

    public void onResponse(Object obj)
    {
        a((JSONObject)obj);
    }
}
