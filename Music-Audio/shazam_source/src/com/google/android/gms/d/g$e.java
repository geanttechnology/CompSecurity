// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            kw, g, la, kv, 
//            ku, lc

public static final class s extends kw
{

    private static volatile c c[];
    public int a;
    public int b;

    public static s[] b()
    {
        if (c == null)
        {
            synchronized (la.a)
            {
                if (c == null)
                {
                    c = new c[0];
                }
            }
        }
        return c;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final int a()
    {
        return super.a() + kv.b(1, a) + kv.b(2, b);
    }

    public final lc a(ku ku1)
    {
        do
        {
            int i = ku1.a();
            switch (i)
            {
            default:
                if (a(ku1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                a = ku1.e();
                break;

            case 16: // '\020'
                b = ku1.e();
                break;
            }
        } while (true);
    }

    public final void a(kv kv1)
    {
        kv1.a(1, a);
        kv1.a(2, b);
        super.a(kv1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof )
            {
                obj = ()obj;
                flag = flag1;
                if (a == ((a) (obj)).a)
                {
                    flag = flag1;
                    if (b == ((b) (obj)).b)
                    {
                        return a(((kw) (obj)));
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return ((a + 527) * 31 + b) * 31 + c();
    }

    public ()
    {
        a = 0;
        b = 0;
        r = null;
        s = -1;
    }
}
