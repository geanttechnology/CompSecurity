// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.w;

import com.bumptech.glide.load.e;
import myobfuscated.q.k;
import myobfuscated.v.ac;
import myobfuscated.v.ae;
import myobfuscated.v.af;
import myobfuscated.v.t;

public final class b
    implements ae
{

    private final ac a;

    public b()
    {
        this(null);
    }

    public b(ac ac1)
    {
        a = ac1;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        e = (t)obj;
        obj = e;
        if (a != null)
        {
            obj = (t)a.a(e, 0, 0);
            if (obj == null)
            {
                a.a(e, 0, 0, e);
                obj = e;
            }
        }
        return new af(((com.bumptech.glide.load.b) (obj)), new k(((t) (obj))));
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
