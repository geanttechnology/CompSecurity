// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.h;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.u;
import com.google.b.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.b.b.a:
//            i

public static final class <init> extends x
{

    private final h a;
    private final Map b;

    public final Object a(a a1)
    {
        Object obj;
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        obj = a.a();
        a1.c();
_L1:
        Object obj1;
        if (!a1.e())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj1 = a1.h();
        obj1 = (a)b.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((b) (obj1)).i)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        a1.o();
          goto _L1
        try
        {
            ((i) (obj1)).a(a1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new u(a1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new AssertionError(a1);
        }
          goto _L1
        a1.d();
        return obj;
    }

    public final void a(c c1, Object obj)
    {
        if (obj == null)
        {
            c1.f();
            return;
        }
        c1.d();
        try
        {
            Iterator iterator = b.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ror ror = (sNext)iterator.next();
                if (ror.a(obj))
                {
                    c1.a(ror.g);
                    ror.a(c1, obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw new AssertionError();
        }
        c1.e();
    }

    private ssException(h h1, Map map)
    {
        a = h1;
        b = map;
    }

    b(h h1, Map map, byte byte0)
    {
        this(h1, map);
    }
}
