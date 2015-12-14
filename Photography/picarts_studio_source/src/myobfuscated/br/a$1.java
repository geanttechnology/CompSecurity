// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.br:
//            a, c

final class it>
    implements Runnable
{

    private a a;

    public final void run()
    {
        for (Iterator iterator = a.f.iterator(); iterator.hasNext(); ((c)iterator.next()).a()) { }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
