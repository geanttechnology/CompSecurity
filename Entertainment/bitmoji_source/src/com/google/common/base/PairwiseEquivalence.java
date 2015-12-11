// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

// Referenced classes of package com.google.common.base:
//            Equivalence, Preconditions

final class PairwiseEquivalence extends Equivalence
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    final Equivalence elementEquivalence;

    PairwiseEquivalence(Equivalence equivalence)
    {
        elementEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
    }

    protected boolean doEquivalent(Iterable iterable, Iterable iterable1)
    {
        iterable = iterable.iterator();
        iterable1 = iterable1.iterator();
_L4:
        if (!iterable.hasNext() || !iterable1.hasNext()) goto _L2; else goto _L1
_L1:
        if (elementEquivalence.equivalent(iterable.next(), iterable1.next())) goto _L4; else goto _L3
_L3:
        return false;
_L2:
        if (!iterable.hasNext() && !iterable1.hasNext())
        {
            return true;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    protected volatile boolean doEquivalent(Object obj, Object obj1)
    {
        return doEquivalent((Iterable)obj, (Iterable)obj1);
    }

    protected int doHash(Iterable iterable)
    {
        int i = 0x13381;
        for (iterable = iterable.iterator(); iterable.hasNext();)
        {
            Object obj = iterable.next();
            i = i * 24943 + elementEquivalence.hash(obj);
        }

        return i;
    }

    protected volatile int doHash(Object obj)
    {
        return doHash((Iterable)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PairwiseEquivalence)
        {
            obj = (PairwiseEquivalence)obj;
            return elementEquivalence.equals(((PairwiseEquivalence) (obj)).elementEquivalence);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return elementEquivalence.hashCode() ^ 0x46a3eb07;
    }

    public String toString()
    {
        String s = String.valueOf(elementEquivalence);
        return (new StringBuilder(String.valueOf(s).length() + 11)).append(s).append(".pairwise()").toString();
    }
}
