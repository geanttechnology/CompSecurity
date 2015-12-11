// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;

// Referenced classes of package com.google.b.b.a:
//            m

static final class 
    implements y
{

    public final x a(f f, a a1)
    {
        a1 = a1.a;
        if (!java/lang/Enum.isAssignableFrom(a1) || a1 == java/lang/Enum)
        {
            return null;
        }
        f = a1;
        if (!a1.isEnum())
        {
            f = a1.getSuperclass();
        }
        return new init>(f);
    }

    ()
    {
    }
}
