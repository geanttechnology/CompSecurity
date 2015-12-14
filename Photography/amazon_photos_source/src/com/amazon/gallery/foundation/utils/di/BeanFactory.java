// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.di;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.utils.di:
//            BeanKey

public abstract class BeanFactory
{

    private Map beanMap;
    protected Context context;

    protected BeanFactory()
    {
        beanMap = new HashMap();
    }

    public Object getBean(BeanKey beankey)
    {
        return beanMap.get(beankey.getKey());
    }

    public void init(Context context1)
    {
        context = context1;
    }

    public void putBean(BeanKey beankey, Object obj)
    {
        beanMap.put(beankey.getKey(), obj);
    }

    public void release()
    {
    }
}
