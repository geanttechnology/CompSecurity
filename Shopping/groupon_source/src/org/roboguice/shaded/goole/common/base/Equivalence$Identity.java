// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.base;

import java.io.Serializable;

// Referenced classes of package org.roboguice.shaded.goole.common.base:
//            Equivalence

static final class A extends Equivalence
    implements Serializable
{

    static final A INSTANCE = new <init>();

    protected boolean doEquivalent(Object obj, Object obj1)
    {
        return false;
    }

    protected int doHash(Object obj)
    {
        return System.identityHashCode(obj);
    }


    A()
    {
    }
}
