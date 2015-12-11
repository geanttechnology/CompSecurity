// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.c;

import android.content.Context;
import com.facebook.i;
import com.google.a.a.f;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.ui.analytics.b;
import de.greenrobot.event.EventBus;

public class a
    implements b
{

    private com.facebook.a.a logger;
    private final Context mContext;

    public a(com.target.a.a.a a1)
    {
        mContext = a1.a();
    }

    private void e()
    {
        boolean flag;
        if (d() && logger != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "Facebook sdk not initialized, can't proceed further");
    }

    public void a()
    {
        i.a(mContext);
        logger = com.facebook.a.a.c(mContext, "583232368478661");
    }

    public void b()
    {
        e();
        com.facebook.a.a.a(mContext, "583232368478661");
        com.target.ui.util.c.a.a().register(this);
    }

    public void c()
    {
        e();
        com.target.ui.util.c.a.a().unregister(this);
        com.facebook.a.a.b(mContext, "583232368478661");
    }

    public boolean d()
    {
        return i.a();
    }

    public void onEvent(com.target.ui.analytics.b.i j)
    {
        e();
        logger.a(j.orderCompletionDetails.c(), j.orderCompletionDetails.d());
    }
}
