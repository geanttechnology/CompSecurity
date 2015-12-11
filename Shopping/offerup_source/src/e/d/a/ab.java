// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.d.b.a;
import e.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package e.d.a:
//            aa

final class ab extends j
{

    private boolean a;
    private List b;
    private a c;
    private j d;

    ab(aa aa, a a1, j j1)
    {
        c = a1;
        d = j1;
        super();
        a = false;
        b = new LinkedList();
    }

    public final void a()
    {
        if (!a)
        {
            a = true;
            ArrayList arraylist;
            try
            {
                arraylist = new ArrayList(b);
            }
            catch (Throwable throwable)
            {
                a(throwable);
                return;
            }
            b = null;
            c.a(arraylist);
        }
    }

    public final void a(Object obj)
    {
        if (!a)
        {
            b.add(obj);
        }
    }

    public final void a(Throwable throwable)
    {
        d.a(throwable);
    }

    public final void d()
    {
        a(0x7fffffffffffffffL);
    }
}
