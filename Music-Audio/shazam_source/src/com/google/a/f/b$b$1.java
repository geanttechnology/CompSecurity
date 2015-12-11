// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package com.google.a.f:
//            b

final class nit> extends nit>
{

    final TypeVariable a;
    final eVariable b;
    final eVariable c;

    public final Type a(TypeVariable typevariable, eVariable evariable)
    {
        if (typevariable.getGenericDeclaration().equals(a.getGenericDeclaration()))
        {
            return typevariable;
        } else
        {
            return b.b(typevariable, evariable);
        }
    }

    eVariable(eVariable evariable, TypeVariable typevariable, eVariable evariable1)
    {
        c = evariable;
        a = typevariable;
        b = evariable1;
        super();
    }
}
