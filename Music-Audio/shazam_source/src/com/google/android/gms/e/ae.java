// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.util.LruCache;

// Referenced classes of package com.google.android.gms.e:
//            cv

final class ae
    implements cv
{

    private LruCache a;

    ae(cw.a a1)
    {
        a = new LruCache(a1) {

            final cw.a a;
            final ae b;

            protected final int sizeOf(Object obj, Object obj1)
            {
                return a.a(obj, obj1);
            }

            
            {
                b = ae.this;
                a = a1;
                super(0x100000);
            }
        };
    }

    public final Object a(Object obj)
    {
        return a.get(obj);
    }

    public final void a(Object obj, Object obj1)
    {
        a.put(obj, obj1);
    }
}
