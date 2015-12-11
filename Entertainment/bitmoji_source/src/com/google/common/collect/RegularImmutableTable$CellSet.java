// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            RegularImmutableTable

private final class <init> extends <init>
{

    final RegularImmutableTable this$0;

    public boolean contains(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof <init>)
        {
            obj = (<init>)obj;
            Object obj1 = RegularImmutableTable.this.get(((<init>) (obj)).<init>(), ((<init>) (obj)).<init>());
            flag = flag1;
            if (obj1 != null)
            {
                flag = flag1;
                if (obj1.equals(((<init>) (obj)).<init>()))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    <init> get(int i)
    {
        return getCell(i);
    }

    volatile Object get(int i)
    {
        return get(i);
    }

    boolean isPartialView()
    {
        return false;
    }

    public int size()
    {
        return RegularImmutableTable.this.size();
    }

    private ()
    {
        this$0 = RegularImmutableTable.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
