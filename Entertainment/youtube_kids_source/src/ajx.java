// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ajx
    implements avt
{

    private aju a;

    ajx(aju aju1)
    {
        a = aju1;
        super();
    }

    public final void a(avq avq1)
    {
        aju aju1 = a;
        avq1 = String.valueOf(avq1.toString());
        if (avq1.length() != 0)
        {
            avq1 = "onConnectionFailed: ".concat(avq1);
        } else
        {
            avq1 = new String("onConnectionFailed: ");
        }
        aju1.a(avq1);
        a.b.d();
        a.c();
    }
}
