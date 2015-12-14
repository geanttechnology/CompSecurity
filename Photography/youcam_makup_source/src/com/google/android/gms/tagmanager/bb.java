// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.LruCache;

// Referenced classes of package com.google.android.gms.tagmanager:
//            k

class bb
    implements k
{

    private LruCache agc;

    bb(int i, l.a a)
    {
        agc = new _cls1(i, a);
    }

    public void e(Object obj, Object obj1)
    {
        agc.put(obj, obj1);
    }

    public Object get(Object obj)
    {
        return agc.get(obj);
    }

    /* member class not found */
    class _cls1 {}

}
