// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import com.g.b.a.d;
import com.g.b.a.f;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.g.b.a.d:
//            o, i, a, p

final class  extends f
{

    final p b;
    final b c;

    public final void a()
    {
        try
        {
            com.g.b.a.d.o.f(c.c).a(b);
            return;
        }
        catch (IOException ioexception)
        {
            d.a.log(Level.INFO, (new StringBuilder("StreamHandler failure for ")).append(o.a(c.c)).toString(), ioexception);
        }
        try
        {
            b.a(a.b);
            return;
        }
        catch (IOException ioexception1)
        {
            return;
        }
    }

    transient n(n n, String s, Object aobj[], p p1)
    {
        c = n;
        b = p1;
        super(s, aobj);
    }
}
