// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bts
    implements bnj, bsn
{

    private final dzk a;
    private btk b;

    public bts(dzk dzk1)
    {
        a = (dzk)b.a(dzk1);
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Object obj = a.b;
        if (b == null && obj != null && ((dzi) (obj)).a != null)
        {
            b = new btk(((dzi) (obj)).a);
        }
        obj = b;
        if (obj != null)
        {
            ((btk) (obj)).a(bnk1);
        }
    }

    public final dre c()
    {
        return a.a;
    }
}
