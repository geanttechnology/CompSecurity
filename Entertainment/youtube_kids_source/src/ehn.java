// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class ehn
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private ehr a;

    ehn(ehr ehr1)
    {
        a = ehr1;
    }

    final Object readResolve()
    {
        return a.c();
    }
}
