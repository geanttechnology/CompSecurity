// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class alb
    implements bhv
{

    private final als a;
    private akx b;

    public alb(akx akx1, als als1)
    {
        b = akx1;
        super();
        a = als1;
    }

    public final void a(cfy cfy1)
    {
        int i = cfy1.c;
        cfy1 = b.l;
        cfy1 = a.a.c;
        (new StringBuilder(String.valueOf(cfy1).length() + 31)).append("App status for ").append(cfy1).append(" is ").append(i).append(".");
        if (i != 1 && i != 2)
        {
            b.a(a);
        }
    }

    public final void a(Object obj, Exception exception)
    {
        obj = String.valueOf(a);
        bmo.a((new StringBuilder(String.valueOf(obj).length() + 35)).append("Error on retrieving app status for ").append(((String) (obj))).toString(), exception);
        b.a(a);
    }

    public final volatile void a(Object obj, Object obj1)
    {
        a((cfy)obj1);
    }
}
