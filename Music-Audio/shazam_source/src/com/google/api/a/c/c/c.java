// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.c;

import com.google.api.a.d.o;
import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.d.t;
import com.google.api.a.e.f;
import com.google.api.a.e.i;
import com.google.api.a.g.aa;
import com.google.api.a.g.z;
import java.io.IOException;
import java.util.Collections;

// Referenced classes of package com.google.api.a.c.c:
//            a

public final class c extends t
{

    private final transient a a;

    private c(com.google.api.a.d.t.a a1, a a2)
    {
        super(a1);
        a = a2;
    }

    public static c a(com.google.api.a.e.c c1, s s1)
    {
        Object obj;
        Object obj1;
        Object obj4;
        com.google.api.a.d.t.a a1;
        obj1 = null;
        obj = null;
        obj4 = null;
        a1 = new com.google.api.a.d.t.a(s1.c, s1.d, s1.e.c);
        com.google.api.a.f.a.a.a.a.c.a(c1);
        if (s1.a() || !o.b("application/json; charset=UTF-8", s1.a)) goto _L2; else goto _L1
_L1:
        Object obj2 = s1.b();
        if (obj2 == null) goto _L2; else goto _L3
_L3:
        obj1 = c1.a(s1.b());
        obj = ((f) (obj1)).c();
        c1 = ((com.google.api.a.e.c) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        c1 = ((f) (obj1)).n();
        if (c1 == null) goto _L5; else goto _L4
_L4:
        ((f) (obj1)).a(Collections.singleton("error"));
        if (((f) (obj1)).c() == i.d) goto _L5; else goto _L6
_L6:
        c1 = (a)((f) (obj1)).a(com/google/api/a/c/c/a);
        obj2 = c1;
        obj = obj1;
        obj4 = c1.toPrettyString();
        obj2 = obj4;
        obj4 = c1;
_L20:
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        s1.c();
        obj = obj4;
        c1 = ((com.google.api.a.e.c) (obj2));
_L10:
        s1 = t.a(s1);
        if (!aa.a(c1))
        {
            s1.append(z.a).append(c1);
            a1.d = c1;
        }
        a1.e = s1.toString();
        return new c(a1, ((a) (obj)));
_L8:
        c1 = ((com.google.api.a.e.c) (obj2));
        obj = obj4;
        if (obj4 != null) goto _L10; else goto _L9
_L9:
        ((f) (obj1)).a();
        c1 = ((com.google.api.a.e.c) (obj2));
        obj = obj4;
          goto _L10
        obj1;
        obj = obj4;
        c1 = ((com.google.api.a.e.c) (obj2));
_L17:
        ((IOException) (obj1)).printStackTrace();
          goto _L10
        IOException ioexception;
        ioexception;
        obj1 = null;
        c1 = null;
_L19:
        obj2 = c1;
        obj = obj1;
        ioexception.printStackTrace();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        s1.c();
        obj = c1;
        c1 = null;
          goto _L10
        if (c1 != null) goto _L12; else goto _L11
_L11:
        ((f) (obj1)).a();
        obj = c1;
        c1 = null;
          goto _L10
        obj2;
        obj = null;
        c1 = null;
_L18:
        if (obj != null) goto _L14; else goto _L13
_L13:
        s1.c();
_L16:
        throw obj2;
_L14:
        if (c1 != null) goto _L16; else goto _L15
_L15:
        ((f) (obj)).a();
          goto _L16
_L2:
        c1 = s1.e();
        obj = obj1;
          goto _L10
        obj1;
        c1 = null;
          goto _L17
        obj1;
        obj = c1;
        c1 = null;
          goto _L17
        obj2;
        c1 = null;
        obj = obj1;
          goto _L18
        Exception exception;
        exception;
        c1 = ((com.google.api.a.e.c) (obj2));
        obj2 = exception;
          goto _L18
        ioexception;
        c1 = null;
          goto _L19
        ioexception;
          goto _L19
_L12:
        obj = c1;
        c1 = null;
          goto _L10
_L5:
        obj2 = null;
          goto _L20
        exception;
        Object obj3 = null;
        obj = c1;
        c1 = obj3;
          goto _L17
    }
}
