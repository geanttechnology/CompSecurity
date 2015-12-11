// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c;

import com.google.api.a.d.ac;
import com.google.api.a.d.f;
import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.m;
import com.google.api.a.d.p;
import com.google.api.a.d.r;
import com.google.api.a.d.v;

public final class b
    implements l, r
{

    private final boolean a;

    public b()
    {
        this((byte)0);
    }

    private b(byte byte0)
    {
        a = false;
    }

    public final void a(p p1)
    {
        p1.a = this;
    }

    public final void b(p p1)
    {
        String s;
        boolean flag1;
        flag1 = true;
        s = p1.h;
        if (s.equals("POST")) goto _L2; else goto _L1
_L1:
        if (!s.equals("GET")) goto _L4; else goto _L3
_L3:
        if (p1.i.d().length() <= 2048) goto _L6; else goto _L5
_L5:
        boolean flag = flag1;
_L13:
        if (!flag) goto _L8; else goto _L7
_L7:
        s = p1.h;
        p1.a("POST");
        p1.b.a("X-HTTP-Method-Override", s);
        if (!s.equals("GET")) goto _L10; else goto _L9
_L9:
        p1.f = new ac(p1.i.c());
        p1.i.clear();
_L8:
        return;
_L4:
        flag = flag1;
        if (a)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        flag = flag1;
        if (!p1.g.a(s))
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L10:
        if (p1.f != null) goto _L8; else goto _L11
_L11:
        p1.f = new f();
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
