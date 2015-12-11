// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ajv extends aun
{

    private aju a;

    ajv(aju aju1)
    {
        a = aju1;
        super();
    }

    public final void a()
    {
        a.a("onVolumeChanged");
    }

    public final void a(int i)
    {
        a.a((new StringBuilder(37)).append("onApplicationDisconnected ").append(i).toString());
        a.b.d();
        switch (aka.a[a.h.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a.a(false);
            if (i == 2005)
            {
                a.a.a();
                return;
            } else
            {
                a.b("CAST YT app stopped abnormally.");
                a.a.a(alu.i, true);
                return;
            }

        case 2: // '\002'
            a.c();
            return;
        }
    }
}
