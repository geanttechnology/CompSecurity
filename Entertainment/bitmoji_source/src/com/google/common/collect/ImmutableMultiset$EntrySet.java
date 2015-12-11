// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableMultiset

private final class <init> extends <init>
{

    private static final long serialVersionUID = 0L;
    final ImmutableMultiset this$0;

    public boolean contains(Object obj)
    {
        if (obj instanceof <init>)
        {
            obj = (<init>)obj;
            break MISSING_BLOCK_LABEL_12;
        }
        do
        {
            return false;
        } while (((<init>) (obj)).<init>() <= 0 || count(((<init>) (obj)).<init>()) != ((<init>) (obj)).<init>());
        return true;
    }

    <init> get(int i)
    {
        return getEntry(i);
    }

    volatile Object get(int i)
    {
        return get(i);
    }

    public int hashCode()
    {
        return ImmutableMultiset.this.hashCode();
    }

    boolean isPartialView()
    {
        return ImmutableMultiset.this.isPartialView();
    }

    public int size()
    {
        return elementSet().size();
    }

    Object writeReplace()
    {
        return new erializedForm(ImmutableMultiset.this);
    }

    private erializedForm()
    {
        this$0 = ImmutableMultiset.this;
        super();
    }

    ( )
    {
        this();
    }
}
