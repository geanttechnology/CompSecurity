// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;

// Referenced classes of package com.google.i18n.phonenumbers:
//            RegexCache

private static class size
{

    private LinkedHashMap map;
    private int size;

    public Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = map.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void put(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        map.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }


    public _cls1.this._cls0(int i)
    {
        size = i;
        map = new LinkedHashMap((i * 4) / 3 + 1, 0.75F, true) {

            final RegexCache.LRUCache this$0;

            protected boolean removeEldestEntry(java.util.Map.Entry entry)
            {
                return size() > size;
            }

            
            {
                this$0 = RegexCache.LRUCache.this;
                super(i, f, flag);
            }
        };
    }
}
