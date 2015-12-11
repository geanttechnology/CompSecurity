// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class ekj
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final eho a;

    ekj(eho eho1)
    {
        a = eho1;
    }

    final Object readResolve()
    {
        return a.l_();
    }
}
