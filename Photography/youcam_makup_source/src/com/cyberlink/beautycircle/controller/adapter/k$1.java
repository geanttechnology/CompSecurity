// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import com.cyberlink.beautycircle.model.NotificationList;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            k, l

class a
    implements Runnable
{

    final ArrayList a;
    final k b;

    public void run()
    {
        if (k.a(b) != null)
        {
            k.a(b, ((NotificationList)a.get(0)).createTime);
            k.a(b).a(k.b(b), k.c(b));
            k.a(b).a(false);
        }
    }

    (k k1, ArrayList arraylist)
    {
        b = k1;
        a = arraylist;
        super();
    }
}
