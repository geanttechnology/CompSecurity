// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bgr extends bdc
{

    private bgs h;

    public bgr(bdd bdd, bgs bgs1)
    {
        super(bdd);
        h = bgs1;
    }

    public final int a()
    {
        if (h.a() && !h.b())
        {
            return 0;
        } else
        {
            return super.a();
        }
    }
}
