// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.q.d;

// Referenced classes of package com.bumptech.glide.load.engine:
//            GlideException, ad

public final class j
{

    final myobfuscated.ac.d a;
    private final Class b;
    private final List c;
    private final android.support.v4.util.Pools.Pool d;
    private final String e;

    public j(Class class1, Class class2, Class class3, List list, myobfuscated.ac.d d1, android.support.v4.util.Pools.Pool pool)
    {
        b = class1;
        c = list;
        a = d1;
        d = pool;
        e = (new StringBuilder("Failed DecodePath{")).append(class1.getSimpleName()).append("->").append(class2.getSimpleName()).append("->").append(class3.getSimpleName()).append("}").toString();
    }

    private ad a(d d1, int i, int k, e e1, List list)
    {
        Object obj;
        int l;
        int i1;
        obj = null;
        i1 = c.size();
        l = 0;
_L5:
        Object obj1 = obj;
        if (l >= i1) goto _L2; else goto _L1
_L1:
        f f1 = (f)c.get(l);
        if (!f1.a(d1.a(), e1))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj1 = f1.a(d1.a(), i, k, e1);
        obj = obj1;
_L3:
        obj1 = obj;
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        l++;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (Log.isLoggable("DecodePath", 2))
        {
            (new StringBuilder("Failed to decode data for ")).append(f1);
        }
        list.add(obj1);
        if (true) goto _L3; else goto _L2
_L2:
        if (obj1 == null)
        {
            throw new GlideException(e, new ArrayList(list));
        }
        return ((ad) (obj1));
        if (true) goto _L5; else goto _L4
_L4:
    }

    final ad a(d d1, int i, int k, e e1)
    {
        List list = (List)d.acquire();
        d1 = a(d1, i, k, e1, list);
        d.release(list);
        return d1;
        d1;
        d.release(list);
        throw d1;
    }

    public final String toString()
    {
        return (new StringBuilder("DecodePath{ dataClass=")).append(b).append(", decoders=").append(c).append(", transcoder=").append(a).append('}').toString();
    }
}
