// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.a.e;
import com.google.b.b.a.f;
import com.google.b.d.a;
import com.google.b.d.c;
import java.io.IOException;

// Referenced classes of package com.google.b:
//            m, l

public abstract class x
{

    public x()
    {
    }

    public final l a(Object obj)
    {
        try
        {
            f f1 = new f();
            a(((c) (f1)), obj);
            obj = f1.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new m(((Throwable) (obj)));
        }
        return ((l) (obj));
    }

    public abstract Object a(a a1);

    public final Object a(l l)
    {
        try
        {
            l = ((l) (a(((a) (new e(l))))));
        }
        // Misplaced declaration of an exception variable
        catch (l l)
        {
            throw new m(l);
        }
        return l;
    }

    public abstract void a(c c, Object obj);
}
