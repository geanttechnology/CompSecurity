// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            m, ao, ak, y, 
//            aj

final class a
    implements Callable
{

    final Map a;
    final m b;

    public final Object call()
    {
        Object obj1 = (ao)b.c.get();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = ((ao) (obj1)).f();
        ((ak) (obj)).a(new <init>(a, ((ao) (obj1)).getContext()));
        obj1 = new StringBuilder("usingStreaming=");
        if (((ak) (obj)).l == null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        obj = ((ak) (obj)).l;
        boolean flag;
        if (((y) (obj)).a != null && ((y) (obj)).f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L5
_L5:
        flag1 = true;
_L6:
        return aj.a(((StringBuilder) (obj1)).append(flag1).toString());
_L4:
        flag1 = false;
        if (true) goto _L6; else goto _L2
_L2:
        return aj.b("An unknown error occured.");
    }

    (m m1, Map map)
    {
        b = m1;
        a = map;
        super();
    }
}
