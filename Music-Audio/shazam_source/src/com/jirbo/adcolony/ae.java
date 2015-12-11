// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.jirbo.adcolony:
//            q, ac, d, av, 
//            ap, au

final class ae
{

    static byte a[] = new byte[1024];
    String b;

    ae(String s)
    {
        b = (new StringBuilder()).append(q.c.f.d).append(s).toString();
    }

    final av a()
    {
        return new av(b);
    }

    final ap b()
    {
        ap ap1;
        try
        {
            ap1 = new ap(new au(b));
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return ap1;
    }

    final void c()
    {
        (new File(b)).delete();
    }

}
