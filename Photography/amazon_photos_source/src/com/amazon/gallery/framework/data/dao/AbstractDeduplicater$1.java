// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            AbstractDeduplicater

class this._cls0 extends ThreadLocal
{

    final AbstractDeduplicater this$0;

    public volatile Object get()
    {
        return get();
    }

    public List get()
    {
        List list = (List)super.get();
        list.clear();
        return list;
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected List initialValue()
    {
        return new ArrayList();
    }

    ()
    {
        this$0 = AbstractDeduplicater.this;
        super();
    }
}
