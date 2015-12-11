// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import com.g.b.a.f;
import java.io.IOException;

// Referenced classes of package com.g.b.a.d:
//            o, c

final class  extends f
{

    final int b;
    final long c;
    final o d;

    public final void a()
    {
        try
        {
            d.i.a(b, c);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (o o1, String s, Object aobj[], int i, long l)
    {
        d = o1;
        b = i;
        c = l;
        super(s, aobj);
    }
}
