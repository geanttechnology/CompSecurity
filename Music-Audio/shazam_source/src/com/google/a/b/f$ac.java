// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.a.b:
//            f

static final class a extends WeakReference
    implements ference
{

    final get a;

    public final int a()
    {
        return 1;
    }

    public final nceQueue a(ReferenceQueue referencequeue, Object obj, nceQueue ncequeue)
    {
        return new <init>(referencequeue, obj, ncequeue);
    }

    public final void a(Object obj)
    {
    }

    public final nceQueue b()
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

    nceQueue(ReferenceQueue referencequeue, Object obj, nceQueue ncequeue)
    {
        super(obj, referencequeue);
        a = ncequeue;
    }
}
