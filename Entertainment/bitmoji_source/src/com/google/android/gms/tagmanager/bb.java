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

    private LruCache Vw;

    bb(int i, l.a a)
    {
        Vw = new LruCache(i, a) {

            final l.a Vx;
            final bb Vy;

            protected int sizeOf(Object obj, Object obj1)
            {
                return Vx.sizeOf(obj, obj1);
            }

            
            {
                Vy = bb.this;
                Vx = a;
                super(i);
            }
        };
    }

    public void e(Object obj, Object obj1)
    {
        Vw.put(obj, obj1);
    }

    public Object get(Object obj)
    {
        return Vw.get(obj);
    }
}
