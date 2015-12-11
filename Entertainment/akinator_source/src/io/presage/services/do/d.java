// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.do;

import io.presage.services.if.f;
import java.util.List;
import java.util.Map;

// Referenced classes of package io.presage.services.do:
//            a, c

public final class d extends a
    implements c
{

    public d()
    {
        super(50);
    }

    public final void a(f f1)
    {
        if (e().size() >= a)
        {
            b = true;
            return;
        }
        f f2 = (f)d().get(f1.b());
        if (f2 == null || !f2.f().equals(f1.f()) || f2.b(f1))
        {
            if (f2 != null && f2.b(f1))
            {
                f1.a(f2.a(f1));
            }
            e().add(f1);
        }
        d().put(f1.b(), f1);
    }
}
