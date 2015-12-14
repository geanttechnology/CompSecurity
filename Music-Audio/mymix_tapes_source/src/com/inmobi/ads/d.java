// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.a;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.ads:
//            f, e

final class d
    implements com.inmobi.commons.core.network.a.a
{
    public static interface a
    {

        public abstract void a(f f1);

        public abstract void b(f f1);
    }


    private static final String a = com/inmobi/ads/d.getSimpleName();
    private e b;
    private a c;

    public d(e e, a a1)
    {
        b = e;
        c = a1;
    }

    public void a()
    {
        (new com.inmobi.commons.core.network.a(b, this)).a();
    }

    public void a(c c1)
    {
        c1 = new f(b, c1);
        c.a(c1);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Ad fetch succeeded. Response:").append(c1.c()).toString());
    }

    public void b(c c1)
    {
        c1 = new f(b, c1);
        c.b(c1);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Ad fetch failed:").append(c1.d().b()).toString());
    }

}
