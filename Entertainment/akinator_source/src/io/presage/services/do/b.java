// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.do;

import io.presage.services.if.e;
import java.util.List;
import java.util.Map;

// Referenced classes of package io.presage.services.do:
//            a, c

public final class b extends a
    implements c
{

    public b()
    {
        super(100);
    }

    public final void a(e e1)
    {
        if (e().size() >= a)
        {
            b = true;
            return;
        }
        e e2 = (e)d().get(e1.b());
        if (e2 == null || !e2.f().equals(e1.f()))
        {
            e().add(e1);
        }
        d().put(e1.b(), e1);
    }
}
