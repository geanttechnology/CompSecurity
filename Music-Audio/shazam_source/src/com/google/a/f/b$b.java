// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import com.google.a.c.ae;
import com.google.a.c.az;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.f:
//            b, e

private static class a
{

    private final ae a;

    final a a(Map map)
    {
        com.google.a.c. ;
         = ae.i();
        Object obj = a;
        .a(.b + ((Map) (obj)).size());
        java.util.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); .a(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Entry)((Iterator) (obj)).next();
        }

        map = map.entrySet().iterator();
        while (map.hasNext()) 
        {
            Object obj1 = (java.util.Entry)map.next();
             1 = (next)((java.util.Entry) (obj1)).getKey();
            obj1 = (Type)((java.util.Entry) (obj1)).getValue();
            boolean flag;
            if (!1.b(((Type) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            g.a(flag, "Type variable %s bound to itself", new Object[] {
                1
            });
            .a(1, obj1);
        }
        .b;
        JVM INSTR tableswitch 0 1: default 204
    //                   0 229
    //                   1 236;
           goto _L1 _L2 _L3
_L1:
        map = new az(.b, .a);
_L5:
        return new <init>(map);
_L2:
        map = ae.h();
        continue; /* Loop/switch isn't completed */
_L3:
        map = ae.b(.a[0].getKey(), .a[0].getValue());
        if (true) goto _L5; else goto _L4
_L4:
    }

    Type a(TypeVariable typevariable, ypeVariable ypevariable)
    {
        Type type;
        type = (Type)a.get(new <init>(typevariable));
        if (type != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        type = typevariable.getBounds();
        if (type.length != 0) goto _L2; else goto _L1
_L1:
        return typevariable;
_L2:
        ypevariable = (new b(ypevariable, (byte)0)).a(type);
        if (a && Arrays.equals(type, ypevariable)) goto _L1; else goto _L3
_L3:
        return e.a(typevariable.getGenericDeclaration(), typevariable.getName(), ypevariable);
        return (new b(ypevariable, (byte)0)).a(type);
    }

    <init>()
    {
        a = ae.h();
    }

    private (ae ae1)
    {
        a = ae1;
    }

    // Unreferenced inner class com/google/a/f/b$b$1

/* anonymous class */
    final class _cls1 extends b.b
    {

        final TypeVariable a;
        final b.b b;
        final b.b c;

        public final Type a(TypeVariable typevariable, b.b b1)
        {
            if (typevariable.getGenericDeclaration().equals(a.getGenericDeclaration()))
            {
                return typevariable;
            } else
            {
                return b.a(typevariable, b1);
            }
        }

            
            {
                c = b.b.this;
                a = typevariable;
                b = b2;
                super();
            }
    }

}
