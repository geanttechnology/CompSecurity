// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.l;
import java.io.IOException;

// Referenced classes of package com.a.a.a.b:
//            v, q, h, x

final class w extends l
{

    final x a;
    final v b;

    transient w(v v1, String s, Object aobj[], x x)
    {
        b = v1;
        a = x;
        super(s, aobj);
    }

    public final void a()
    {
        try
        {
            q.e(b.a).a(a);
            return;
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
    }
}
