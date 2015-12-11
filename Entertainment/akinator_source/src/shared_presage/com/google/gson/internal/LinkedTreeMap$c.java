// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            LinkedTreeMap

private abstract class <init>
    implements Iterator
{

    dCount b;
    dCount c;
    int d;
    final LinkedTreeMap e;

    final <init> a()
    {
        <init> <init>1 = b;
        if (<init>1 == e.header)
        {
            throw new NoSuchElementException();
        }
        if (e.modCount != d)
        {
            throw new ConcurrentModificationException();
        } else
        {
            b = <init>1.d;
            c = <init>1;
            return <init>1;
        }
    }

    public final boolean hasNext()
    {
        return b != e.header;
    }

    public final void remove()
    {
        if (c == null)
        {
            throw new IllegalStateException();
        } else
        {
            e.removeInternal(c, true);
            c = null;
            d = e.modCount;
            return;
        }
    }

    private (LinkedTreeMap linkedtreemap)
    {
        e = linkedtreemap;
        super();
        b = e.header.d;
        c = null;
        d = e.modCount;
    }

    dCount(LinkedTreeMap linkedtreemap, byte byte0)
    {
        this(linkedtreemap);
    }
}
