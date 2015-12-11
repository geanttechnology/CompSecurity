// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.flurry.android:
//            cw, SdkAdLog, gc, SdkAdEvent, 
//            FlurryAds

final class el
{

    private FlurryAds gl;

    el(FlurryAds flurryads)
    {
        gl = flurryads;
    }

    final List h(List list)
    {
        CopyOnWriteArrayList copyonwritearraylist;
        Iterator iterator;
        copyonwritearraylist = new CopyOnWriteArrayList();
        iterator = list.iterator();
_L3:
        Object obj;
        cw cw1;
        SdkAdLog sdkadlog;
        SdkAdEvent sdkadevent;
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cw1 = (cw)iterator.next();
        sdkadlog = new SdkAdLog();
        sdkadlog.b(Long.valueOf(cw1.aB()));
        Iterator iterator1;
        Object obj2;
        java.util.Map.Entry entry;
        if (cw1.aA() == null)
        {
            obj = "";
        } else
        {
            obj = cw1.aA();
        }
        sdkadlog.b(((CharSequence) (obj)));
        obj = new CopyOnWriteArrayList();
        cw1;
        JVM INSTR monitorenter ;
        iterator1 = cw1.aC().iterator();
_L1:
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_267;
            }
            obj1 = (gc)iterator1.next();
        } while (!((gc) (obj1)).bD());
        sdkadevent = new SdkAdEvent();
        sdkadevent.a(((gc) (obj1)).getType());
        sdkadevent.a(Long.valueOf(((gc) (obj1)).bh()));
        obj2 = ((gc) (obj1)).getParams();
        obj1 = new HashMap();
        for (obj2 = ((Map) (obj2)).entrySet().iterator(); ((Iterator) (obj2)).hasNext(); ((Map) (obj1)).put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj2)).next();
        }

        break MISSING_BLOCK_LABEL_248;
        list;
        cw1;
        JVM INSTR monitorexit ;
        throw list;
        sdkadevent.a(((Map) (obj1)));
        ((List) (obj)).add(sdkadevent);
          goto _L1
        cw1;
        JVM INSTR monitorexit ;
        sdkadlog.d(((List) (obj)));
        copyonwritearraylist.add(sdkadlog);
        if (true) goto _L3; else goto _L2
_L2:
        gl.i(list);
        return copyonwritearraylist;
    }
}
