// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import myobfuscated.aj.g;

// Referenced classes of package myobfuscated.v:
//            ad

public final class ac
{

    private final g a;

    public ac()
    {
        this(250);
    }

    public ac(int i)
    {
        a = new g(i) {

            protected final volatile void a(Object obj, Object obj1)
            {
                ((ad)obj).a();
            }

        };
    }

    public final Object a(Object obj, int i, int j)
    {
        obj = ad.a(obj, i, j);
        Object obj1 = a.b(obj);
        ((ad) (obj)).a();
        return obj1;
    }

    public final void a(Object obj, int i, int j, Object obj1)
    {
        obj = ad.a(obj, i, j);
        a.b(obj, obj1);
    }
}
