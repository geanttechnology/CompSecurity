// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.h;
import com.facebook.n;

// Referenced classes of package com.facebook.internal:
//            o, m

static final class b
    implements com.facebook.hRequest.b
{

    final a a;
    final String b;

    public void a(n n1)
    {
        if (n1.a() != null)
        {
            a.a(n1.a().e());
            return;
        } else
        {
            m.a(b, n1.b());
            a.a(n1.b());
            return;
        }
    }

    b(b b1, String s)
    {
        a = b1;
        b = s;
        super();
    }
}
