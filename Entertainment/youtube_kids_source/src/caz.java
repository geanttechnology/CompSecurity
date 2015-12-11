// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

final class caz
    implements bhv
{

    private final List a;
    private List b;
    private bhv c;
    private cay d;

    public caz(cay cay1, List list, List list1, bhv bhv1)
    {
        d = cay1;
        super();
        b = list;
        a = list1;
        c = bhv1;
    }

    public final void a(Object obj, Exception exception)
    {
        c.a(b, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (List)obj1;
        a.addAll(((java.util.Collection) (obj)));
        d.a(b, a, this, c);
    }
}
