// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.l;
import java.io.IOException;

// Referenced classes of package com.a.a.a.b:
//            q, d

final class s extends l
{

    final int a;
    final int b;
    final q c;

    transient s(q q1, String s1, Object aobj[], int i, int j)
    {
        c = q1;
        a = i;
        b = j;
        super(s1, aobj);
    }

    public final void a()
    {
        try
        {
            q q1 = c;
            int i = a;
            int j = b;
            q1.d.a(i, j);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
