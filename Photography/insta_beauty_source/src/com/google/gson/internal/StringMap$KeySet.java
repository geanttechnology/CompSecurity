// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.gson.internal:
//            StringMap

final class <init> extends AbstractSet
{

    final StringMap this$0;

    public void clear()
    {
        StringMap.this.clear();
    }

    public boolean contains(Object obj)
    {
        return containsKey(obj);
    }

    public Iterator iterator()
    {
        class _cls1 extends StringMap.LinkedHashIterator
        {

            final StringMap.KeySet this$1;

            public volatile Object next()
            {
                return next();
            }

            public final String next()
            {
                return nextEntry().key;
            }

            _cls1()
            {
                this$1 = StringMap.KeySet.this;
                super(this$0, null);
            }
        }

        return new _cls1();
    }

    public boolean remove(Object obj)
    {
        int i = StringMap.access$500(StringMap.this);
        StringMap.this.remove(obj);
        return StringMap.access$500(StringMap.this) != i;
    }

    public int size()
    {
        return StringMap.access$500(StringMap.this);
    }

    private _cls1()
    {
        this$0 = StringMap.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
