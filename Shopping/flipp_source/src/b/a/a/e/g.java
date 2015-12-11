// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.a;
import b.a.a.b.t;
import b.a.a.c;
import java.io.DataInput;

// Referenced classes of package b.a.a.e:
//            e, c

final class g
{

    final e a;
    final String b;
    final int c;

    private g(e e1, String s, int i)
    {
        a = e1;
        b = s;
        c = i;
    }

    static g a(DataInput datainput)
    {
        return new g(new e((char)datainput.readUnsignedByte(), datainput.readUnsignedByte(), datainput.readByte(), datainput.readUnsignedByte(), datainput.readBoolean(), (int)b.a.a.e.c.a(datainput)), datainput.readUTF(), (int)b.a.a.e.c.a(datainput));
    }

    public final long a(long l, int i, int j)
    {
        e e1 = a;
        t t1;
        long l1;
        long l2;
        if (e1.a == 'w')
        {
            i += j;
        } else
        if (e1.a != 's')
        {
            i = 0;
        }
        l2 = (long)i + l;
        t1 = t.L();
        l = t1.C().b(l2, e1.b);
        l = t1.e().b(l, 0);
        l1 = e1.a(t1, t1.e().a(l, e1.f));
        if (e1.d == 0)
        {
            l = l1;
            if (l1 <= l2)
            {
                l = e1.a(t1, t1.E().a(l1, 1));
            }
        } else
        {
            l1 = e1.c(t1, l1);
            l = l1;
            if (l1 <= l2)
            {
                l = t1.E().a(l1, 1);
                l = e1.c(t1, e1.a(t1, t1.C().b(l, e1.b)));
            }
        }
        return l - (long)i;
    }

    public final long b(long l, int i, int j)
    {
        e e1 = a;
        t t1;
        long l1;
        long l2;
        if (e1.a == 'w')
        {
            i += j;
        } else
        if (e1.a != 's')
        {
            i = 0;
        }
        l2 = (long)i + l;
        t1 = t.L();
        l = t1.C().b(l2, e1.b);
        l = t1.e().b(l, 0);
        l1 = e1.b(t1, t1.e().a(l, e1.f));
        if (e1.d == 0)
        {
            l = l1;
            if (l1 >= l2)
            {
                l = e1.b(t1, t1.E().a(l1, -1));
            }
        } else
        {
            l1 = e1.c(t1, l1);
            l = l1;
            if (l1 >= l2)
            {
                l = t1.E().a(l1, -1);
                l = e1.c(t1, e1.b(t1, t1.C().b(l, e1.b)));
            }
        }
        return l - (long)i;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof g)
            {
                if (c != ((g) (obj = (g)obj)).c || !b.equals(((g) (obj)).b) || !a.equals(((g) (obj)).a))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }
}
