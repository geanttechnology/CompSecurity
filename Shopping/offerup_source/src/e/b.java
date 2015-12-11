// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e;

import e.b.h;
import e.c.d;

// Referenced classes of package e:
//            j, a

final class b
    implements e.c.b
{

    private d a;
    private a b;

    b(a a1, d d1)
    {
        b = a1;
        a = d1;
        super();
    }

    public final void call(Object obj)
    {
        obj = (j)obj;
        Object obj1;
        Throwable throwable;
        try
        {
            e.a.a();
            obj1 = (j)e.f.b.a(a).a(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (obj1 instanceof h)
            {
                throw (h)obj1;
            } else
            {
                ((j) (obj)).a(((Throwable) (obj1)));
                return;
            }
        }
        ((j) (obj1)).d();
        b.a.call(obj1);
        return;
        throwable;
        if (throwable instanceof h)
        {
            throw (h)throwable;
        }
        ((j) (obj1)).a(throwable);
        return;
    }
}
