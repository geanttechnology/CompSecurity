// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

// Referenced classes of package com.google.a.b:
//            f

static final class a extends SoftReference
    implements eference
{

    final get a;

    public final int a()
    {
        return 1;
    }

    public final enceQueue a(ReferenceQueue referencequeue, Object obj, enceQueue encequeue)
    {
        return new <init>(referencequeue, obj, encequeue);
    }

    public final void a(Object obj)
    {
    }

    public final enceQueue b()
    {
        return a;
    }

    public final boolean c()
    {
        return false;
    }

    public final boolean d()
    {
        return true;
    }

    public final Object e()
    {
        return get();
    }

    enceQueue(ReferenceQueue referencequeue, Object obj, enceQueue encequeue)
    {
        super(obj, referencequeue);
        a = encequeue;
    }
}
