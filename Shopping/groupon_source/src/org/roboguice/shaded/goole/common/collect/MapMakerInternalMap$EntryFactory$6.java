// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMakerInternalMap

static final class nit> extends nit>
{

    nit> copyEntry(nit> nit>, nit> nit>1, nit> nit>2)
    {
        nit> = super.pyEntry(nit>, nit>1, nit>2);
        copyExpirableEntry(nit>1, nit>);
        return nit>;
    }

    copyExpirableEntry newEntry(copyExpirableEntry copyexpirableentry, Object obj, int i, copyExpirableEntry copyexpirableentry1)
    {
        return new try(copyexpirableentry.renceQueue, obj, i, copyexpirableentry1);
    }

    try(String s, int i)
    {
        super(s, i, null);
    }
}
