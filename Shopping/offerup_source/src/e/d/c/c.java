// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;


// Referenced classes of package e.d.c:
//            a, d

class c
{

    private int a;
    private d b[];
    private long c;

    c()
    {
        a = a.a;
        b = new d[a];
        for (int i = 0; i < a; i++)
        {
            b[i] = new d(e.d.c.a.b());
        }

    }

    public final d a()
    {
        d ad[] = b;
        long l = c;
        c = 1L + l;
        return ad[(int)(l % (long)a)];
    }
}
