// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import java.util.LinkedHashMap;

public class DMSCache
{

    final LinkedHashMap MRUdata;

    public DMSCache(final int final_i)
    {
        MRUdata = new LinkedHashMap(0.75F, true, final_i) {

            private static final long serialVersionUID = 1L;
            final DMSCache this$0;
            final int val$capacity;

            protected boolean removeEldestEntry(java.util.Map.Entry entry)
            {
                return size() > capacity;
            }

            
            {
                this$0 = DMSCache.this;
                capacity = j;
                super(final_i, f, flag);
            }
        };
    }

    public Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = MRUdata.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void set(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        MRUdata.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }
}
