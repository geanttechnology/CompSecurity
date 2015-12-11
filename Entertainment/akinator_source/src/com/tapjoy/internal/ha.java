// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gr, fw, bp, bu

final class ha extends gr
    implements fw
{

    public static final bp a = new bp() {

        public final Object a(bu bu1)
        {
            String s2 = null;
            int i = 1;
            bu1.i();
            String s1 = null;
            String s = null;
            while (bu1.k()) 
            {
                String s3 = bu1.m();
                if ("id".equals(s3))
                {
                    s = bu1.n();
                } else
                if ("name".equals(s3))
                {
                    s1 = bu1.n();
                } else
                if ("quantity".equals(s3))
                {
                    i = bu1.s();
                } else
                if ("token".equals(s3))
                {
                    s2 = bu1.n();
                } else
                {
                    bu1.t();
                }
            }
            bu1.j();
            return new ha(s, s1, i, s2);
        }

    };
    private final String b;
    private final String c;
    private final int d;
    private final String e;

    ha(String s, String s1, int i, String s2)
    {
        b = s;
        c = s1;
        d = i;
        e = s2;
    }

    public final String a()
    {
        return b;
    }

    public final String b()
    {
        return c;
    }

    public final int c()
    {
        return d;
    }

    public final String d()
    {
        return e;
    }

}
