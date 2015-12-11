// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class c
    implements ag
{

    c()
    {
    }

    public final Object a(String s)
    {
        return new AtomicInteger(Integer.valueOf(s).intValue());
    }

    public final String a(Object obj)
    {
        return ((AtomicInteger)obj).toString();
    }
}
