// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import b.a.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;

// Referenced classes of package b.a.b:
//            f

public final class g
    implements y
{

    private final a a;

    public g(a a1)
    {
        a = a1;
    }

    public final x a(f f1, com.google.b.c.a a1)
    {
        if (a.a.isAssignableFrom(a1.a))
        {
            x x = f1.a(this, a1);
            return new b.a.b.f(a1.a, a, x, f1);
        } else
        {
            return null;
        }
    }
}
