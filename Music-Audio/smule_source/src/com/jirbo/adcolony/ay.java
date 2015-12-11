// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;

// Referenced classes of package com.jirbo.adcolony:
//            h

class ay
    implements Serializable
{

    String a;
    int b;
    int c;
    int d;

    ay()
    {
        a = "";
    }

    ay(String s)
    {
        a = "";
        a = s;
    }

    h a()
    {
        h h1 = new h();
        h1.b("uuid", a);
        h1.b("skipped_plays", b);
        h1.b("play_order_index", c);
        return h1;
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.a("uuid", "error");
            b = h1.f("skipped_plays");
            c = h1.f("play_order_index");
            return true;
        }
    }
}
