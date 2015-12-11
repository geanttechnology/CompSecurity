// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cuc extends crf
{

    private final bxu a;
    private final String b;
    private ctx c;

    cuc(ctx ctx1, bxu bxu1, String s)
    {
        c = ctx1;
        super();
        a = (bxu)b.a(bxu1);
        b = (String)b.a(s);
    }

    public final void a(Object obj)
    {
        obj = (bxb)obj;
        obj = c.a(b, ((bxb) (obj)));
        ctx.a(c).d(new csp(((bxi) (a)).i));
        super.a(obj);
    }
}
