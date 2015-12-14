// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Absent, Present, Preconditions

public abstract class Optional
    implements Serializable
{

    Optional()
    {
    }

    public static Optional absent()
    {
        return Absent.INSTANCE;
    }

    public static Optional of(Object obj)
    {
        return new Present(Preconditions.checkNotNull(obj));
    }

    public abstract Object get();

    public abstract boolean isPresent();
}
