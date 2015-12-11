// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class cbc
    implements bhv
{

    private final bzi a;
    private final bhv b;
    private final List c = Collections.synchronizedList(new ArrayList());
    private cbb d;

    public cbc(cbb cbb1, bzi bzi1, bhv bhv1)
    {
        d = cbb1;
        super();
        a = bzi1;
        b = bhv1;
    }

    public final void a(Object obj, Exception exception)
    {
        b.a(a, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (cpv)obj1;
        c.addAll(((cpv) (obj)).c);
        if (((cpv) (obj)).b != null)
        {
            d.a.a(a.b(((cpv) (obj)).b), this);
            return;
        } else
        {
            b.a(a, new ArrayList(c));
            return;
        }
    }
}
