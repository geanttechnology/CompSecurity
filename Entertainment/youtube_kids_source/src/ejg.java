// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Comparator;

final class ejg
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private Comparator a;
    private Object b[];

    public ejg(Comparator comparator, Object aobj[])
    {
        a = comparator;
        b = aobj;
    }

    final Object readResolve()
    {
        ejf ejf1 = (new ejf(a)).b((Object[])b);
        Object aobj[] = (Object[])ejf1.a;
        eje eje1 = eje.a(ejf1.c, ejf1.b, aobj);
        ejf1.b = eje1.size();
        return eje1;
    }
}
