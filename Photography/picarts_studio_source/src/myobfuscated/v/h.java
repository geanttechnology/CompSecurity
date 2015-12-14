// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import myobfuscated.q.b;
import myobfuscated.q.c;

// Referenced classes of package myobfuscated.v:
//            g

final class h
    implements b
{

    private final byte a[];
    private final g b;

    public h(byte abyte0[], g g1)
    {
        a = abyte0;
        b = g1;
    }

    public final void a()
    {
    }

    public final void a(Priority priority, c c1)
    {
        c1.a(b.a(a));
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
        return b.a();
    }
}
