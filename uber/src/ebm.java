// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ebm
{

    private djb a;
    private dfp b;

    private ebm()
    {
    }

    ebm(byte byte0)
    {
        this();
    }

    static dfp a(ebm ebm1)
    {
        return ebm1.b;
    }

    static djb b(ebm ebm1)
    {
        return ebm1.a;
    }

    public final ebm a(dfp dfp)
    {
        if (dfp == null)
        {
            throw new NullPointerException("riderApplicationComponent");
        } else
        {
            b = dfp;
            return this;
        }
    }

    public final ebm a(djb djb)
    {
        a = djb;
        return this;
    }

    public final ebw a()
    {
        if (a == null)
        {
            throw new IllegalStateException("riderFragmentModule must be set");
        }
        if (b == null)
        {
            throw new IllegalStateException("riderApplicationComponent must be set");
        } else
        {
            return new ebl(this, (byte)0);
        }
    }
}
