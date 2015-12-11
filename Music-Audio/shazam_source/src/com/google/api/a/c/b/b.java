// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.b;

import com.google.api.a.d.h;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.g.x;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.api.a.c.b:
//            a

public final class b
{
    public static final class a
    {

        final com.google.api.a.c.b.a a;
        final Class b;
        final Class c;
        final p d;

        public a(com.google.api.a.c.b.a a1, Class class1, Class class2, p p)
        {
            a = a1;
            b = class1;
            c = class2;
            d = p;
        }
    }


    public h a;
    public List b;
    private final q c;
    private x d;

    public b(v v1, r r)
    {
        a = new h("https://www.googleapis.com/batch");
        b = new ArrayList();
        d = x.a;
        if (r == null)
        {
            v1 = v1.a(null);
        } else
        {
            v1 = v1.a(r);
        }
        c = v1;
    }
}
