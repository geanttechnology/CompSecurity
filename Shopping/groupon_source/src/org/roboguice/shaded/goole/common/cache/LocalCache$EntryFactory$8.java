// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;


// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

static final class nit> extends nit>
{

    nit> copyEntry(nit> nit>, nit> nit>1, nit> nit>2)
    {
        nit> = super.pyEntry(nit>, nit>1, nit>2);
        copyAccessEntry(nit>1, nit>);
        copyWriteEntry(nit>1, nit>);
        return nit>;
    }

    copyWriteEntry newEntry(copyWriteEntry copywriteentry, Object obj, int i, copyWriteEntry copywriteentry1)
    {
        return new Entry(copywriteentry.renceQueue, obj, i, copywriteentry1);
    }

    Entry(String s, int i)
    {
        super(s, i, null);
    }
}
