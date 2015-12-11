// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.e;
import c.f;
import java.io.Closeable;
import java.util.List;

// Referenced classes of package com.g.b.a.d:
//            a, m, e

public interface b
    extends Closeable
{
    public static interface a
    {

        public abstract void a(int i, long l);

        public abstract void a(int i, f f);

        public abstract void a(int i, com.g.b.a.d.a a1);

        public abstract void a(int i, List list);

        public abstract void a(boolean flag, int i, int j);

        public abstract void a(boolean flag, int i, e e, int j);

        public abstract void a(boolean flag, m m);

        public abstract void a(boolean flag, boolean flag1, int i, List list, com.g.b.a.d.e e);
    }


    public abstract void a();

    public abstract boolean a(a a1);
}
