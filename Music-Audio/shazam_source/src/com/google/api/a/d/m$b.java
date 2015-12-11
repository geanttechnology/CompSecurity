// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.b;
import com.google.api.a.g.f;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.api.a.d:
//            m

private static final class nit>
{

    final b a;
    final StringBuilder b;
    final f c;
    final List d;

    public (m m1, StringBuilder stringbuilder)
    {
        Class class1 = m1.getClass();
        d = Arrays.asList(new Type[] {
            class1
        });
        c = f.a(class1, true);
        b = stringbuilder;
        a = new b(m1);
    }
}
