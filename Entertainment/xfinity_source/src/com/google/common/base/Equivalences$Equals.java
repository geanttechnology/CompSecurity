// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Equivalence, Equivalences

private static final class  extends Equivalence
    implements Serializable
{

    static final INSTANCE INSTANCE = new <init>();

    private Object readResolve()
    {
        return INSTANCE;
    }

    protected boolean doEquivalent(Object obj, Object obj1)
    {
        return obj.equals(obj1);
    }

    public int doHash(Object obj)
    {
        return obj.hashCode();
    }


    private ()
    {
    }
}
