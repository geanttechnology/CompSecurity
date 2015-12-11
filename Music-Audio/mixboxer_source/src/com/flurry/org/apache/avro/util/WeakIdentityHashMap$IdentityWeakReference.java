// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.util;

import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.org.apache.avro.util:
//            WeakIdentityHashMap

class hash extends WeakReference
{

    int hash;
    final WeakIdentityHashMap this$0;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (get() != ((get) (obj = (get)obj)).get())
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return hash;
    }

    (Object obj)
    {
        this$0 = WeakIdentityHashMap.this;
        super(obj, WeakIdentityHashMap.access$000(WeakIdentityHashMap.this));
        hash = System.identityHashCode(obj);
    }
}
