// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a.a;

import java.nio.charset.Charset;
import org.a.a.a.a.b.b;

// Referenced classes of package org.a.a.a.a.a:
//            f, c

public abstract class d
    implements f
{

    private final c a;

    public d(c c1)
    {
        org.a.a.a.a.b.b.a(c1, "Content type");
        a = c1;
    }

    public String b()
    {
        Charset charset = a.b();
        if (charset != null)
        {
            return charset.name();
        } else
        {
            return null;
        }
    }

    public String e()
    {
        return a.a();
    }

    public c f()
    {
        return a;
    }
}
