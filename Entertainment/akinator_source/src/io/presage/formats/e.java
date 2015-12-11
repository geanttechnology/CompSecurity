// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import io.presage.ads.d;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package io.presage.formats:
//            g

public final class e extends g
{

    public e(String s, String s1, d d1, io.presage.do.e e1)
    {
        super(s, s1, d1, e1);
        a(d1);
    }

    public final void c()
    {
        a.a("shown");
        Object obj = (ArrayList)a("actions");
        if (obj != null)
        {
            String s;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a().b(s))
            {
                s = (String)((Iterator) (obj)).next();
            }

        }
        a().b("close");
    }

    public final void d()
    {
    }
}
