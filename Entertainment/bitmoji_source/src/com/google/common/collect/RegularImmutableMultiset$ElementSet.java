// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            RegularImmutableMultiset

private final class <init> extends <init>
{

    final RegularImmutableMultiset this$0;

    public boolean contains(Object obj)
    {
        return RegularImmutableMultiset.this.contains(obj);
    }

    Object get(int i)
    {
        return RegularImmutableMultiset.access$100(RegularImmutableMultiset.this)[i]._mth0();
    }

    boolean isPartialView()
    {
        return true;
    }

    public int size()
    {
        return RegularImmutableMultiset.access$100(RegularImmutableMultiset.this).length;
    }

    private ()
    {
        this$0 = RegularImmutableMultiset.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
