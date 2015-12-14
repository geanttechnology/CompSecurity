// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.deduplicate:
//            CloudFieldDeduplicater

static final class  extends ThreadLocal
{

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
    }
}
