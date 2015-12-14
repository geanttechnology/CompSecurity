// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import myobfuscated.ac.d;
import myobfuscated.f.m;

// Referenced classes of package com.bumptech.glide.load.engine:
//            GlideException, j, k, ad

public final class ab
{

    private final android.support.v4.util.Pools.Pool a;
    private final List b;
    private final String c;

    public ab(Class class1, Class class2, Class class3, List list, android.support.v4.util.Pools.Pool pool)
    {
        a = pool;
        b = (List)m.a(list);
        c = (new StringBuilder("Failed LoadPath{")).append(class1.getSimpleName()).append("->").append(class2.getSimpleName()).append("->").append(class3.getSimpleName()).append("}").toString();
    }

    private ad a(myobfuscated.q.d d1, e e, int i, int l, k k1, List list)
    {
        ad ad;
        int i1;
        int j1;
        j1 = b.size();
        ad = null;
        i1 = 0;
_L6:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        Object obj = (j)b.get(i1);
        ad ad1 = k1.a(((j) (obj)).a(d1, i, l, e));
        obj = ((j) (obj)).a.a(ad1);
        ad = ((ad) (obj));
_L4:
        obj = ad;
        if (ad != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i1++;
        continue; /* Loop/switch isn't completed */
        obj;
        list.add(obj);
        if (true) goto _L4; else goto _L3
_L2:
        obj = ad;
_L3:
        if (obj == null)
        {
            throw new GlideException(c, new ArrayList(list));
        }
        return ((ad) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final ad a(myobfuscated.q.d d1, e e, int i, int l, k k1)
    {
        List list = (List)a.acquire();
        d1 = a(d1, e, i, l, k1, list);
        a.release(list);
        return d1;
        d1;
        a.release(list);
        throw d1;
    }

    public final String toString()
    {
        return (new StringBuilder("LoadPath{decodePaths=")).append(Arrays.toString(b.toArray(new j[b.size()]))).append('}').toString();
    }
}
