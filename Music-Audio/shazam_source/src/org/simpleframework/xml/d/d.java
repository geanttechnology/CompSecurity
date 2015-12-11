// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class d
    implements ag
{

    d()
    {
    }

    public final Object a(String s)
    {
        return new AtomicLong(Long.valueOf(s).longValue());
    }

    public final String a(Object obj)
    {
        return ((AtomicLong)obj).toString();
    }
}
