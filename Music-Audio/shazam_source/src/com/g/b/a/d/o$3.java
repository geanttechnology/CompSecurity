// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import com.g.b.a.f;
import java.io.IOException;

// Referenced classes of package com.g.b.a.d:
//            o, k

final class  extends f
{

    final boolean b = true;
    final int c;
    final int d;
    final k e = null;
    final o f;

    public final void a()
    {
        try
        {
            o.a(f, b, c, d, e);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (o o1, String s, Object aobj[], int i, int j)
    {
        f = o1;
        c = i;
        d = j;
        super(s, aobj);
    }
}
