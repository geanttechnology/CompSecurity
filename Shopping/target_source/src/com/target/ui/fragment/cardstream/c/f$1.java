// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.google.a.a.e;
import com.target.a.a.b;
import com.target.mothership.model.coupons.interfaces.a.c;
import com.target.mothership.model.d;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            f

class val.absent extends d
{

    final f this$0;
    final e val$absent;
    final rfaces.a.c val$onLoadedCallback;

    public void a(c c1)
    {
        com.target.a.a.b.b("MobileCouponsDataSource", (new StringBuilder()).append("Error loading assigned mobile coupon offers: ").append(c1).toString());
        val$onLoadedCallback.a(val$absent);
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        list = f.a(f.this, list);
        val$onLoadedCallback.a(e.b(list));
    }

    public void b(Object obj)
    {
        a((c)obj);
    }

    rfaces.a.c()
    {
        this$0 = final_f1;
        val$onLoadedCallback = c1;
        val$absent = e.this;
        super();
    }
}
