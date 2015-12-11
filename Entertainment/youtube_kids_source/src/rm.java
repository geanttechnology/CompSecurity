// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rm
    implements bhv
{

    private rl a;

    rm(rl rl1)
    {
        a = rl1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        obj = (String)obj;
        bmo.a((new StringBuilder(String.valueOf(obj).length() + 27)).append("Error loading ad [request=").append(((String) (obj))).append("]").toString(), exception);
        a.s();
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bfm)obj1;
        a.a(((cry) (obj)));
    }
}
