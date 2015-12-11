// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cjq
{

    public final bwb a;
    public final bwb b;
    public final bwb c;
    public final bwv d[];
    public final int e;

    public cjq(bwb bwb, bwb bwb1, bwb bwb2, bwv abwv[], String as[], int i)
    {
        a = bwb;
        b = bwb1;
        c = bwb2;
        d = (bwv[])b.a(abwv);
        b.a(as);
        e = i;
    }

    public final boolean a()
    {
        return d.length > 1;
    }
}
