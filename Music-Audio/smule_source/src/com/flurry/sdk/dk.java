// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            fu, dl

public class dk
{

    private int a;
    private int b;
    private fu c;
    private fu d;
    private dl e;

    private dk()
    {
    }


    static int a(dk dk1, int i)
    {
        dk1.a = i;
        return i;
    }

    public static dk a(dk dk1, dk dk2)
    {
        if (dk1 == null || dk2 == null)
        {
            return null;
        }
        fu fu1 = new fu();
        fu fu2 = dk1.c();
        if (fu2 != null)
        {
            fu1.a(fu2);
        }
        fu2 = dk2.c();
        if (fu2 != null)
        {
            fu1.a(fu2);
        }
        fu2 = new fu();
        dk1 = dk1.d();
        if (dk1 != null)
        {
            fu2.a(dk1);
        }
        dk1 = dk2.d();
        if (dk1 != null)
        {
            fu2.a(dk1);
        }
        dk1 = new a();
        dk1.a(dk2.a());
        dk1.b(dk2.b());
        dk1.a(fu1);
        dk1.b(fu2);
        dk1.a(dk2.e());
        return dk1.a();
    }

    static dl a(dk dk1, dl dl)
    {
        dk1.e = dl;
        return dl;
    }

    static fu a(dk dk1, fu fu1)
    {
        dk1.c = fu1;
        return fu1;
    }

    static int b(dk dk1, int i)
    {
        dk1.b = i;
        return i;
    }

    static fu b(dk dk1, fu fu1)
    {
        dk1.d = fu1;
        return fu1;
    }

    public int a()
    {
        return a;
    }

    public int b()
    {
        return b;
    }

    public fu c()
    {
        return c;
    }

    public fu d()
    {
        return d;
    }

    public dl e()
    {
        return e;
    }

    private class a
    {

        private dk a;

        public a a(int i)
        {
            dk.a(a, i);
            return this;
        }

        public a a(dl dl)
        {
            dk.a(a, dl);
            return this;
        }

        public a a(fu fu1)
        {
            dk.a(a, fu1);
            return this;
        }

        public dk a()
        {
            return a;
        }

        public a b(int i)
        {
            dk.b(a, i);
            return this;
        }

        public a b(fu fu1)
        {
            dk.b(a, fu1);
            return this;
        }

        public a()
        {
            a = new dk();
        }
    }

}
