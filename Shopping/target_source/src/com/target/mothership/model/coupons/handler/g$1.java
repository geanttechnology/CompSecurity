// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.a.a.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.b.a.b.d;
import com.target.mothership.services.b.a.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            g

class this._cls0
    implements aa
{

    final g this$0;

    public volatile Object a(Object obj)
    {
        return a((f)obj);
    }

    public List a(f f1)
    {
        ArrayList arraylist = new ArrayList();
        if (f1 == null)
        {
            return arraylist;
        }
        for (f1 = f1.a().iterator(); f1.hasNext();)
        {
            d d1 = (d)f1.next();
            if (d1.b() == null)
            {
                b.a(com.target.mothership.model.coupons.handler.g.b(), "Available coupon missing accessor");
            } else
            {
                arraylist.add(g.a(g.this).a(d1));
            }
        }

        return arraylist;
    }

    ()
    {
        this$0 = g.this;
        super();
    }
}
