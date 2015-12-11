// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import java.lang.ref.WeakReference;

// Referenced classes of package com.google.ads.util:
//            i

public final class nce extends nce
{

    final i d;

    public Object a()
    {
        return ((WeakReference)a).get();
    }

    public String toString()
    {
        return (new StringBuilder()).append(d.toString()).append(".").append(b).append(" = ").append(a()).append(" (?)").toString();
    }

    public nce(i j, String s, Object obj)
    {
        d = j;
        super(j, s, new WeakReference(obj), null);
    }
}
