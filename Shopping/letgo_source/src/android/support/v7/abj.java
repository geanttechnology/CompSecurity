// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.LruCache;

// Referenced classes of package android.support.v7:
//            aea

class abj
    implements aea
{

    private LruCache a;

    abj(int i, aeb.a a1)
    {
        a = new LruCache(i, a1) {

            final aeb.a a;
            final abj b;

            protected int sizeOf(Object obj, Object obj1)
            {
                return a.a(obj, obj1);
            }

            
            {
                b = abj.this;
                a = a1;
                super(i);
            }
        };
    }

    public Object a(Object obj)
    {
        return a.get(obj);
    }

    public void a(Object obj, Object obj1)
    {
        a.put(obj, obj1);
    }
}
