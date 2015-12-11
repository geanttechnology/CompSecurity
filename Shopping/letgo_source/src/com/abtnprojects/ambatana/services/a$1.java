// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.app.NotificationManager;
import android.os.Message;
import android.support.v7.aqo;
import android.support.v7.ep;

// Referenced classes of package com.abtnprojects.ambatana.services:
//            a

class a
{

    final a a;

    public void onEvent(ep ep1)
    {
        aqo.b("onEvent", new Object[0]);
        com.abtnprojects.ambatana.services.a.b(a).a(com.abtnprojects.ambatana.services.a.a(a), ep1.a, false);
        com.abtnprojects.ambatana.services.a.c(a).notify(1, com.abtnprojects.ambatana.services.a.b(a).a());
        ep1 = Message.obtain(null, 3, ep1.a, 0);
        com.abtnprojects.ambatana.services.a.a(a, ep1);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
