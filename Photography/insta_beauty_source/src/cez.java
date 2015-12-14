// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class cez
    implements Runnable
{

    final String a;
    final cey b;

    cez(cey cey1, String s)
    {
        b = cey1;
        a = s;
        super();
    }

    public void run()
    {
        if (a == null)
        {
            Error error = new Error("error");
            b.b.a(cex.a(b.c), error);
            return;
        } else
        {
            b.b.a(cex.a(b.c), a);
            return;
        }
    }
}
