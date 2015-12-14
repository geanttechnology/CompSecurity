// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.model.NotificationList;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            k

class a
    implements android.view..OnClickListener
{

    final NotificationList a;
    final k b;

    public void onClick(View view)
    {
        if (a != null)
        {
            view = a.senderId;
        } else
        {
            view = null;
        }
        k.a(b, view);
    }

    (k k1, NotificationList notificationlist)
    {
        b = k1;
        a = notificationlist;
        super();
    }
}
