// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.a.d;
import com.j.a.c.e;
import com.j.a.g.h;
import com.j.a.g.k;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            e, aj

class ah
    implements k
{

    final String a;
    final com.j.a.d.e b;

    ah(com.j.a.d.e e1, String s)
    {
        b = e1;
        a = s;
        super();
    }

    public void a(e e1, Exception exception)
    {
        if (exception == null) goto _L2; else goto _L1
_L1:
        w.b("Reading TLProperties from disk", exception);
_L4:
        return;
_L2:
        if (e1 == null) goto _L4; else goto _L3
_L3:
        exception = e1.c();
        if (exception == null) goto _L6; else goto _L5
_L5:
        if (e.a(b, e.a(b))) goto _L4; else goto _L7
_L7:
        aj.a().a(e.a(b));
        if (!exception.has("token")) goto _L6; else goto _L8
_L8:
        exception = exception.getString("token");
        if (exception == null) goto _L10; else goto _L9
_L9:
        if (!a.equals(exception)) goto _L11; else goto _L10
_L10:
        e.b(b, e1);
        b.a(false, null);
        e.b(b);
        e.a(b, e.a(b).l());
_L6:
        e.c(b).d();
        return;
_L11:
        try
        {
            h.a().b();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            w.b("Getting token from disk TLProperties", e1);
        }
        if (true) goto _L6; else goto _L12
_L12:
    }
}
