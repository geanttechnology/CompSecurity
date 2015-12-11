// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ir, jz, jx, jy, 
//            jf, io

public final class <init> extends ir
{

    private final jf a;
    private final Map b;

    public void a(jz jz1, Object obj)
    {
        if (obj == null)
        {
            jz1.f();
            return;
        }
        jz1.d();
        try
        {
            Iterator iterator = b.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                <init> <init>1 = (asNext)iterator.next();
                if (<init>1.h)
                {
                    jz1.a(<init>1.g);
                    <init>1.a(jz1, obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (jz jz1)
        {
            throw new AssertionError();
        }
        jz1.e();
    }

    public Object b(jx jx1)
    {
        Object obj;
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        obj = a.a();
        jx1.c();
_L1:
        Object obj1;
        if (!jx1.e())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj1 = jx1.g();
        obj1 = (a)b.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((b) (obj1)).i)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        jx1.n();
          goto _L1
        try
        {
            ((i) (obj1)).a(jx1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io(jx1);
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new AssertionError(jx1);
        }
          goto _L1
        jx1.d();
        return obj;
    }

    private essException(jf jf1, Map map)
    {
        a = jf1;
        b = map;
    }

    b(jf jf1, Map map, b b1)
    {
        this(jf1, map);
    }
}
