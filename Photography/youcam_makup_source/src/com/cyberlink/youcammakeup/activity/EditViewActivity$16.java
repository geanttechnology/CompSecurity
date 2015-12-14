// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.status.a;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, i

class a
    implements Runnable
{

    final a a;
    final EditViewActivity b;

    public void run()
    {
        for (Iterator iterator = EditViewActivity.z(b).iterator(); iterator.hasNext(); ((i)iterator.next()).a(a)) { }
    }

    (EditViewActivity editviewactivity, a a1)
    {
        b = editviewactivity;
        a = a1;
        super();
    }
}
