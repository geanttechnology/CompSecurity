// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class eig extends eln
{

    private eln a;
    private eif b;

    eig(eif eif1, eln eln1)
    {
        b = eif1;
        a = eln1;
        super();
    }

    public final boolean hasNext()
    {
        return a.hasPrevious();
    }

    public final boolean hasPrevious()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        return a.previous();
    }

    public final int nextIndex()
    {
        return eif.a(b, a.previousIndex());
    }

    public final Object previous()
    {
        return a.next();
    }

    public final int previousIndex()
    {
        return eif.a(b, a.nextIndex());
    }
}
