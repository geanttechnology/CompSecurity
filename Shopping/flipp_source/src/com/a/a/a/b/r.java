// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.l;
import java.io.IOException;

// Referenced classes of package com.a.a.a.b:
//            q, a

final class r extends l
{

    final int a;
    final a b;
    final q c;

    transient r(q q1, String s, Object aobj[], int i, a a1)
    {
        c = q1;
        a = i;
        b = a1;
        super(s, aobj);
    }

    public final void a()
    {
        try
        {
            c.b(a, b);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
