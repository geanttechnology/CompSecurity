// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.x;

// Referenced classes of package com.google.b.b.a:
//            m

static final class  extends x
{

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        if (a1.f() == b.f)
        {
            return Boolean.valueOf(Boolean.parseBoolean(a1.i()));
        } else
        {
            return Boolean.valueOf(a1.j());
        }
    }

    public final void a(c c1, Object obj)
    {
        obj = (Boolean)obj;
        if (obj == null)
        {
            c1.f();
            return;
        } else
        {
            c1.a(((Boolean) (obj)).booleanValue());
            return;
        }
    }

    ()
    {
    }
}
