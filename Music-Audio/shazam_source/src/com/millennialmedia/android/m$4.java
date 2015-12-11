// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            m, ao, an, aj

final class a
    implements Callable
{

    final Map a;
    final m b;

    public final Object call()
    {
        ao ao1 = (ao)b.c.get();
        if (ao1 != null && ao1 != null)
        {
            an.a(new (ao1.f(), new <init>(a, ao1.getContext())));
        }
        return aj.b("An unknown error occured.");
    }

    (m m1, Map map)
    {
        b = m1;
        a = map;
        super();
    }
}
