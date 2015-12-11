// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class w
{

    private static final AtomicInteger a = new AtomicInteger(1);
    private static final Map b = Collections.synchronizedMap(new HashMap());

    public w()
    {
    }

    public static transient String a(Object aobj[])
    {
        String s = String.valueOf(a.getAndIncrement());
        b.put(s, ((Object) (aobj)));
        return s;
    }

    public static Object[] a(String s)
    {
        Object aobj[] = (Object[])b.get(s);
        b.remove(s);
        return aobj;
    }

}
