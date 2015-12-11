// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import io.presage.Presage;
import io.presage.utils.do.a;
import java.util.HashMap;

// Referenced classes of package io.presage.services.for:
//            d, j

public final class h extends d
    implements j
{

    private a a;

    public h()
    {
        a = Presage.getInstance().getWS();
    }

    public final void b()
    {
        a.a("get_config", new HashMap());
    }

    public final void e()
    {
    }

    public final void h()
    {
    }
}
