// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class cml extends aps
    implements anm
{

    int a;
    int b;
    int c;
    int d;

    cml(arp arp, int i, int j, int k, int l, float f)
    {
        this(arp, 0x7fffffff, 0, 0x7fffffff, 0x7fffffff, 1.0F, 0, 0x7fffffff);
    }

    public cml(arp arp, int i, int j, int k, int l, float f, int i1, 
            int j1)
    {
        super(arp, i, j, k, l, f);
        a = -1;
        b = -1;
        c = i1;
        d = j1;
    }

    public final void a(int i, Object obj)
    {
        if (i == 0 && (obj instanceof cmm))
        {
            obj = (cmm)obj;
            a = ((cmm) (obj)).a;
            b = ((cmm) (obj)).b;
        } else
        if (i == 1 && (obj instanceof cmn))
        {
            obj = (cmn)obj;
            c = ((cmn) (obj)).a;
            d = ((cmn) (obj)).b;
            return;
        }
    }

    public final void a(anl anl1, int i, int j)
    {
        anl1.a(this, 0, new cmm(i, j));
    }
}
