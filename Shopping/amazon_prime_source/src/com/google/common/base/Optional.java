// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Absent, Present

public abstract class Optional
    implements Serializable
{

    Optional()
    {
    }

    public static Optional absent()
    {
        return Absent.withType();
    }

    public static Optional fromNullable(Object obj)
    {
        if (obj == null)
        {
            return absent();
        } else
        {
            return new Present(obj);
        }
    }

    public abstract Object get();

    public abstract boolean isPresent();
}
