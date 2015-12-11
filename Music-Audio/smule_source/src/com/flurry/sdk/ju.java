// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package com.flurry.sdk:
//            ir, jw, ia, jz, 
//            jx

final class ju extends ir
{

    private final ia a;
    private final ir b;
    private final Type c;

    ju(ia ia1, ir ir1, Type type)
    {
        a = ia1;
        b = ir1;
        c = type;
    }

    private Type a(Type type, Object obj)
    {
        Object obj1;
label0:
        {
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        return ((Type) (obj1));
    }

    public void a(jz jz, Object obj)
    {
        ir ir1;
        ir1 = b;
        Type type = a(c, obj);
        if (type != c)
        {
            ir1 = a.a(jw.a(type));
            break MISSING_BLOCK_LABEL_38;
        }
_L1:
        ir1.a(jz, obj);
        return;
        if ((ir1 instanceof jr.a) && !(b instanceof jr.a))
        {
            ir1 = b;
        }
          goto _L1
    }

    public Object b(jx jx)
    {
        return b.b(jx);
    }
}
