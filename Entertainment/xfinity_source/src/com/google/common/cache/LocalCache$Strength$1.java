// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;

// Referenced classes of package com.google.common.cache:
//            LocalCache

static final class nit> extends nit>
{

    Equivalence defaultEquivalence()
    {
        return Equivalences.equals();
    }

    nce referenceValue(try try1, try try2, Object obj, int i)
    {
        if (i == 1)
        {
            return new Reference(obj);
        } else
        {
            return new ongValueReference(obj, i);
        }
    }

    nce(String s, int i)
    {
        super(s, i, null);
    }
}
