// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cj extends ci
{

    protected Boolean a;
    private String e;

    cj(cm cm, String s)
    {
        super(cm, s);
        a = Boolean.valueOf(false);
    }

    protected final cw a()
    {
        cw cw = super.a();
        a(cw, "RefId", (new StringBuilder()).append(e).append(".1").toString());
        if (a.booleanValue())
        {
            a(cw, "Cancel", new Boolean(true));
        }
        return cw;
    }

    final String b()
    {
        return e;
    }

    protected final void c()
    {
        super.c();
        e = (new StringBuilder()).append(b.b()).append(".").append(d).toString();
    }
}
