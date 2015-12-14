// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.ad;
import myobfuscated.aj.g;

// Referenced classes of package myobfuscated.t:
//            l, m

public final class k extends g
    implements l
{

    private m a;

    public k(int i)
    {
        super(i);
    }

    protected final int a(Object obj)
    {
        return ((ad)obj).c();
    }

    public final ad a(b b)
    {
        return (ad)super.c(b);
    }

    public final ad a(b b, ad ad1)
    {
        return (ad)super.b(b, ad1);
    }

    public final void a(int i)
    {
        if (i >= 40)
        {
            b(0);
        } else
        if (i >= 20)
        {
            b(b() / 2);
            return;
        }
    }

    protected final volatile void a(Object obj, Object obj1)
    {
        obj = (ad)obj1;
        if (a != null)
        {
            a.a(((ad) (obj)));
        }
    }

    public final void a(m m1)
    {
        a = m1;
    }
}
