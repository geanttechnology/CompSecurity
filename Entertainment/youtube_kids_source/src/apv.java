// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;

public abstract class apv extends apb
{

    public final long f;
    public final long g;
    public final int h;

    public apv(art art, arx arx, app app, int i1, long l1, long l2, int j1)
    {
        super(art, arx, app, i1);
        f = l1;
        g = l2;
        h = j1;
    }

    public abstract boolean a(long l1, boolean flag);

    public abstract boolean a(aoq aoq);

    public abstract void g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract aon j();

    public abstract Map k();

    public final boolean l()
    {
        return h == -1;
    }
}
