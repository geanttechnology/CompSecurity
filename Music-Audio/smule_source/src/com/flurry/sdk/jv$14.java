// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.UUID;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class  extends ir
{

    public UUID a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return UUID.fromString(jx1.h());
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (UUID)obj);
    }

    public void a(jz jz1, UUID uuid)
    {
        if (uuid == null)
        {
            uuid = null;
        } else
        {
            uuid = uuid.toString();
        }
        jz1.b(uuid);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
