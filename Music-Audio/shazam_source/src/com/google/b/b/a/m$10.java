// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.x;
import java.net.URL;

// Referenced classes of package com.google.b.b.a:
//            m

static final class  extends x
{

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
        } else
        {
            a1 = a1.i();
            if (!"null".equals(a1))
            {
                return new URL(a1);
            }
        }
        return null;
    }

    public final void a(c c1, Object obj)
    {
        obj = (URL)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((URL) (obj)).toExternalForm();
        }
        c1.b(((String) (obj)));
    }

    ()
    {
    }
}
