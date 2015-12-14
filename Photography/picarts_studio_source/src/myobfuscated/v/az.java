// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import myobfuscated.q.b;
import myobfuscated.q.c;

final class az
    implements b
{

    private final Object a;

    public az(Object obj)
    {
        a = obj;
    }

    public final void a()
    {
    }

    public final void a(Priority priority, c c1)
    {
        c1.a(a);
    }

    public final void b()
    {
    }

    public final DataSource c()
    {
        return DataSource.LOCAL;
    }

    public final Class d()
    {
        return a.getClass();
    }
}
