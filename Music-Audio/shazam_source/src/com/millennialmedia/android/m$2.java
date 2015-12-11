// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            m, ao, ak, aj

final class a
    implements Callable
{

    final m a;

    public final Object call()
    {
        Object obj = (ao)a.c.get();
        if (obj != null)
        {
            obj = ((ao) (obj)).f();
            if (obj != null)
            {
                ((ak) (obj)).d();
                return aj.a("Success.");
            }
        }
        return aj.b("An unknown error occured.");
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
