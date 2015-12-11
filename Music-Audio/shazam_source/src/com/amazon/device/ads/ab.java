// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            z

public final class ab
    implements Iterable
{

    public final HashMap a = new HashMap();

    public ab()
    {
    }

    public final void a(z z1)
    {
        a.put(z1.b(), z1);
    }

    public final Iterator iterator()
    {
        return a.values().iterator();
    }
}
