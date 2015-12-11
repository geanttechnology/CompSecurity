// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cud
{

    final bje a;
    private final bpj b;

    protected cud()
    {
        a = null;
        b = null;
    }

    public cud(bje bje1, bpj bpj1)
    {
        a = (bje)b.a(bje1);
        b = (bpj)b.a(bpj1);
    }

    public final void a(String s, String s1, int i, String s2, byte abyte0[], mj mj)
    {
        a.d(new csu());
        mj = new cue(this, mj);
        bpl bpl1 = b.a();
        bpl1.a = (String)b.a(s1);
        bpl1.b = i;
        bpl1.a(s);
        bpl1.c = (String)b.a(s2);
        bpl1.a(abyte0);
        b.a(bpl1, mj);
    }
}
