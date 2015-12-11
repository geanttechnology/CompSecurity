// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.o;
import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.e.e;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.aa;
import com.google.api.a.g.z;
import java.io.IOException;

// Referenced classes of package com.google.api.a.a.a:
//            q

public final class t extends com.google.api.a.d.t
{

    public final transient q a;

    private t(com.google.api.a.d.a a1, q q1)
    {
        super(a1);
        a = q1;
    }

    public static t a(com.google.api.a.e.c c1, s s1)
    {
        Object obj;
        String s2;
        com.google.api.a.d.a a1;
        obj = null;
        a1 = new com.google.api.a.d.a(s1.c, s1.d, s1.e.c);
        c.a(c1);
        s2 = s1.a;
        if (s1.a() || s2 == null) goto _L2; else goto _L1
_L1:
        if (s1.b() == null || !o.b("application/json; charset=UTF-8", s2)) goto _L2; else goto _L3
_L3:
        c1 = (q)(new e(c1)).a(s1.b(), s1.f(), com/google/api/a/a/a/q);
        s2 = c1.toPrettyString();
        obj = c1;
        c1 = s2;
_L5:
        s1 = com.google.api.a.d.t.a(s1);
        if (!aa.a(c1))
        {
            s1.append(z.a).append(c1);
            a1.d = c1;
        }
        a1.e = s1.toString();
        return new t(a1, ((q) (obj)));
_L2:
        IOException ioexception;
        try
        {
            c1 = s1.e();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            c1 = null;
        }
_L6:
        ioexception.printStackTrace();
        ioexception = c1;
        c1 = null;
        if (true) goto _L5; else goto _L4
_L4:
        ioexception;
          goto _L6
    }
}
