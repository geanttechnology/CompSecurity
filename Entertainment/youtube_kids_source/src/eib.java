// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.EnumMap;

final class eib
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private EnumMap a;

    eib(EnumMap enummap)
    {
        a = enummap;
    }

    final Object readResolve()
    {
        return new ehx(a);
    }
}
