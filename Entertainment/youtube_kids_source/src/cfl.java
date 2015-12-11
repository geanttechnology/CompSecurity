// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cfl
{

    static final long a[] = {
        5000L, 2000L, 2000L, 2000L, 2000L, 2000L, 5000L, 10000L, 15000L, 20000L
    };
    public static final cfl b = new cfl(-1, null, null);
    final cgm c;
    final cfx d;
    final int e;

    public cfl(int i, cgm cgm, cfx cfx)
    {
        e = i;
        c = cgm;
        d = cfx;
    }

    public static cfl a(cgm cgm, cfx cfx)
    {
        return new cfl(-1, cgm, cfx);
    }

}
