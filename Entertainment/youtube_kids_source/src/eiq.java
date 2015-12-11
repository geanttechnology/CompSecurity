// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class eiq
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private eij a;

    eiq(eij eij1)
    {
        a = eij1;
    }

    final Object readResolve()
    {
        return a.d();
    }
}
