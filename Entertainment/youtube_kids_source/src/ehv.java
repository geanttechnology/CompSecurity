// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class ehv
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private Object a[];

    ehv(Object aobj[])
    {
        a = aobj;
    }

    final Object readResolve()
    {
        if (a.length == 0)
        {
            return ehr.b;
        } else
        {
            return new ehs(a.c(a));
        }
    }
}
