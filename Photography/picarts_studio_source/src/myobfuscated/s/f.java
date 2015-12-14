// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import java.util.Queue;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.s:
//            s

abstract class f
{

    private final Queue a = j.a(20);

    f()
    {
    }

    protected abstract s a();

    public final void a(s s1)
    {
        if (a.size() < 20)
        {
            a.offer(s1);
        }
    }

    protected final s b()
    {
        s s2 = (s)a.poll();
        s s1 = s2;
        if (s2 == null)
        {
            s1 = a();
        }
        return s1;
    }
}
