// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cyo
    implements Runnable
{

    private cym a;

    cyo(cym cym1)
    {
        a = cym1;
        super();
    }

    public final void run()
    {
        int i = (int)(a.b.b() - (long)a.c);
        i = a.a.a(i);
        a.a(i);
    }
}
