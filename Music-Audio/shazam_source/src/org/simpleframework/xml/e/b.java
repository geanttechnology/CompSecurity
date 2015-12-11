// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.e;

import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package org.simpleframework.xml.e:
//            a

public final class b extends ConcurrentHashMap
    implements a
{

    public b()
    {
    }

    public final Object a(Object obj)
    {
        return get(obj);
    }

    public final void a(Object obj, Object obj1)
    {
        put(obj, obj1);
    }

    public final boolean contains(Object obj)
    {
        return containsKey(obj);
    }
}
