// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            m, ao, ak, aj

final class a
    implements Callable
{

    final Map a;
    final m b;

    public final Object call()
    {
        Object obj = (ao)b.c.get();
        if (obj != null)
        {
            obj = ((ao) (obj)).f();
            String s = (String)a.get("streamVideoURI");
            if (obj != null && s != null)
            {
                ((ak) (obj)).setVideoSource(s);
                return aj.a("Success.");
            }
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
