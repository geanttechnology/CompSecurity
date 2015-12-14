// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c, d

class a
    implements Runnable
{

    final c a;

    public void run()
    {
        for (Iterator iterator = ((ArrayList)c.b(a).clone()).iterator(); iterator.hasNext(); ((d)iterator.next()).a()) { }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
