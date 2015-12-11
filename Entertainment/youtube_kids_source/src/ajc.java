// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ajc
    implements bhv
{

    private ame a;
    private ajb b;

    ajc(ajb ajb1, ame ame1)
    {
        b = ajb1;
        a = ame1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        obj = b;
        exception = String.valueOf(exception);
        (new StringBuilder(String.valueOf(exception).length() + 39)).append("exception while requesting descriptor: ").append(exception).toString();
        boolean flag = ((ajb) (obj)).b;
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (alw)obj1;
        obj1 = b;
        ame ame1 = a;
        String s = String.valueOf(ame1.a());
        String s1 = String.valueOf(obj);
        (new StringBuilder(String.valueOf(s).length() + 32 + String.valueOf(s1).length())).append("connect to screen ").append(s).append(", descriptor: ").append(s1).toString();
        boolean flag = ((ajb) (obj1)).b;
        ((ajb) (obj1)).a.a(ame1, ((alw) (obj)));
    }
}
