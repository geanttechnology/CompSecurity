// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.d;
import com.bumptech.glide.load.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import myobfuscated.v.ae;
import myobfuscated.v.af;
import myobfuscated.x.b;

// Referenced classes of package com.bumptech.glide.load.engine:
//            h, l, ab

public final class e
{

    final List a = new ArrayList();
    final List b = new ArrayList();
    public d c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public com.bumptech.glide.load.engine.h h;
    public com.bumptech.glide.load.e i;
    public Map j;
    public Class k;
    boolean l;
    boolean m;
    public com.bumptech.glide.load.b n;
    public Priority o;
    public l p;
    public boolean q;

    e()
    {
    }

    final List a()
    {
        if (!l)
        {
            l = true;
            a.clear();
            List list = c.a.a(d);
            int j1 = list.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                af af1 = ((ae)list.get(i1)).buildLoadData(d, e, f, i);
                if (af1 != null)
                {
                    a.add(af1);
                }
            }

        }
        return a;
    }

    final List a(File file)
    {
        return c.a.a(file);
    }

    final boolean a(Class class1)
    {
        return b(class1) != null;
    }

    final ab b(Class class1)
    {
        return c.a.a(class1, g, k);
    }

    final List b()
    {
        if (!m)
        {
            m = true;
            b.clear();
            List list = a();
            int j1 = list.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                af af1 = (af)list.get(i1);
                b.add(af1.a);
                b.addAll(af1.b);
            }

        }
        return b;
    }

    final h c(Class class1)
    {
        h h1 = (h)j.get(class1);
        Object obj = h1;
        if (h1 == null)
        {
            if (j.isEmpty() && q)
            {
                throw new IllegalArgumentException((new StringBuilder("Missing transformation for ")).append(class1).append(". If you wish to ignore unknown resource types, use the optional transformation methods.").toString());
            }
            obj = myobfuscated.x.b.a();
        }
        return ((h) (obj));
    }
}
