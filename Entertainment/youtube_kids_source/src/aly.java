// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class aly
{

    public final ctx a;
    public final chq b;
    public ama c;
    public bhx d;

    public aly(ctx ctx1, chq chq1)
    {
        a = (ctx)b.a(ctx1);
        b = (chq)b.a(chq1);
    }

    static void a(aly aly1, bxb bxb1, alw alw1, bhv bhv1)
    {
        if (bxb1 == null)
        {
            aly1 = aly1.b;
            bhv1.a(null, alw.f);
            return;
        }
        if (!bxb1.f().a())
        {
            aly1 = aly1.b;
            bhv1.a(null, alw.f);
            return;
        } else
        {
            bhv1.a(null, alw1);
            return;
        }
    }
}
