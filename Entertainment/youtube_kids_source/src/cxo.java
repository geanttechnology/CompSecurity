// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.client.methods.HttpGet;

public final class cxo extends cpd
    implements cot
{

    private final bnq b = a.C();

    public cxo(bns bns)
    {
        super(bns);
    }

    protected final bnq a()
    {
        return b;
    }

    public final Object a(Object obj)
    {
        obj = (cxu)obj;
        b.a(((cxu) (obj)).d);
        return new HttpGet(((cxu) (obj)).h);
    }
}
