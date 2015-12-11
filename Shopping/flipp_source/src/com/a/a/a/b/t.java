// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.l;
import java.io.IOException;

// Referenced classes of package com.a.a.a.b:
//            q, j

final class t extends l
{

    final boolean a = true;
    final int b;
    final int c;
    final j d = null;
    final q e;

    transient t(q q1, String s, Object aobj[], int i, int j)
    {
        e = q1;
        b = i;
        c = j;
        super(s, aobj);
    }

    public final void a()
    {
        try
        {
            q.a(e, a, b, d);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
