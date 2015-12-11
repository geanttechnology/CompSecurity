// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package b.a.a.d:
//            ag, aj, ac, al, 
//            am, ae, ah, ak, 
//            ai

public final class ad
{

    List a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private ai f;
    private boolean g;
    private boolean h;
    private ag i[];

    public ad()
    {
        b = 1;
        c = 2;
        d = 10;
        e = false;
        f = null;
        if (a == null)
        {
            a = new ArrayList();
        } else
        {
            a.clear();
        }
        g = false;
        h = false;
        i = new ag[10];
    }

    private static ac a(List list, boolean flag, boolean flag1)
    {
        if (flag && flag1)
        {
            throw new IllegalStateException("Builder has created neither a printer nor a parser");
        }
        int j = list.size();
        if (j >= 2 && (list.get(0) instanceof aj))
        {
            aj aj1 = (aj)list.get(0);
            if (aj1.b == null && aj1.a == null)
            {
                Object obj = a(list.subList(2, j), flag, flag1);
                list = ((ac) (obj)).a;
                obj = ((ac) (obj)).b;
                aj1.a = list;
                aj1.b = ((al) (obj));
                return new ac(aj1, aj1);
            }
        }
        list = ((List) (a(list)));
        if (flag)
        {
            return new ac(null, (al)list[1]);
        }
        if (flag1)
        {
            return new ac((am)list[0], null);
        } else
        {
            return new ac((am)list[0], (al)list[1]);
        }
    }

    static Object[] a(List list)
    {
        switch (list.size())
        {
        default:
            list = new ae(list);
            return (new Object[] {
                list, list
            });

        case 0: // '\0'
            return (new Object[] {
                ah.a, ah.a
            });

        case 1: // '\001'
            return (new Object[] {
                list.get(0), list.get(1)
            });
        }
    }

    public final ac a()
    {
        ac ac1 = a(a, g, h);
        i = (ag[])(ag[])i.clone();
        return ac1;
    }

    final ad a(am am1, al al1)
    {
        a.add(am1);
        a.add(al1);
        g = g | false;
        h = h | false;
        return this;
    }

    public final ad a(String s)
    {
        Object obj = null;
        ak ak1 = new ak(s);
        if (a.size() > 0)
        {
            s = ((String) (a.get(a.size() - 2)));
            obj = a.get(a.size() - 1);
        } else
        {
            Object obj1 = null;
            s = ((String) (obj));
            obj = obj1;
        }
        if (s == null || obj == null || s != obj || !(s instanceof ag))
        {
            throw new IllegalStateException("No field to apply suffix to");
        } else
        {
            b();
            s = new ag((ag)s, ak1);
            a.set(a.size() - 2, s);
            a.set(a.size() - 1, s);
            i[((ag) (s)).a] = s;
            return this;
        }
    }

    final void a(int j)
    {
        ag ag1 = new ag(b, c, d, e, j, i, f);
        a(((am) (ag1)), ((al) (ag1)));
        i[j] = ag1;
        f = null;
    }

    final void b()
    {
        if (f != null)
        {
            throw new IllegalStateException("Prefix not followed by field");
        } else
        {
            f = null;
            return;
        }
    }
}
