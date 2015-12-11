// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.base;

import java.io.Serializable;

// Referenced classes of package org.roboguice.shaded.goole.common.base:
//            Equivalence

static final class  extends Equivalence
    implements Serializable
{

    static final  INSTANCE = new <init>();

    protected boolean doEquivalent(Object obj, Object obj1)
    {
        return obj.equals(obj1);
    }

    public int doHash(Object obj)
    {
        return obj.hashCode();
    }


    ()
    {
    }
}
