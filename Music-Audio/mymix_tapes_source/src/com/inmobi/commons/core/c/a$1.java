// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.core.c:
//            a

class a
    implements com.inmobi.commons.core.utilities.ean
{

    final com.inmobi.commons.core.c.a a;

    public void a(boolean flag)
    {
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Network status changed ").append(flag).toString());
        if (flag && !com.inmobi.commons.core.c.a.e().get() && com.inmobi.commons.a.a.e())
        {
            com.inmobi.commons.core.c.a.a(com.inmobi.commons.core.c.a.a(), 60);
        }
        com.inmobi.commons.core.c.a.e().set(flag);
    }

    omicBoolean(com.inmobi.commons.core.c.a a1)
    {
        a = a1;
        super();
    }
}
