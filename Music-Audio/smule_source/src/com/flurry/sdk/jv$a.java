// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ir, iv, jx, jy, 
//            jz

final class b extends ir
{

    private final Map a;
    private final Map b;

    public Enum a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return (Enum)a.get(jx1.h());
        }
    }

    public void a(jz jz1, Enum enum)
    {
        if (enum == null)
        {
            enum = null;
        } else
        {
            enum = (String)b.get(enum);
        }
        jz1.b(enum);
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Enum)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    public dException(Class class1)
    {
        a = new HashMap();
        b = new HashMap();
        String s;
        Enum aenum[];
        Enum enum;
        iv iv1;
        int i;
        int j;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            j = aenum.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError();
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[i];
        s = enum.name();
        iv1 = (iv)class1.getField(s).getAnnotation(com/flurry/sdk/iv);
        if (iv1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = iv1.a();
        a.put(s, enum);
        b.put(enum, s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_41;
_L1:
    }
}
