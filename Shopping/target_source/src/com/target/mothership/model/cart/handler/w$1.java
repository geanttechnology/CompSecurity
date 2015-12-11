// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.c;
import com.target.mothership.services.apigee.c.b.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            w, d, TGTAppliedTenders, t, 
//            f

class this._cls0
    implements aa
{

    final w this$0;

    private List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        d d1 = new d();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            z z1 = (z)list.next();
            if (z1.i().c() == a.TARGET_GIFT_CARD)
            {
                arraylist.add(d1.a(z1));
            }
        } while (true);
        return arraylist;
    }

    public AppliedTenders a(c c1)
    {
        TGTAppliedTenders tgtappliedtenders = new TGTAppliedTenders();
        tgtappliedtenders.a(c1.b());
        z z1 = (new t()).a(c1.a());
        tgtappliedtenders.a((new f()).a(z1));
        tgtappliedtenders.a(a(c1.a()));
        return tgtappliedtenders;
    }

    public volatile Object a(Object obj)
    {
        return a((c)obj);
    }

    ppliedTenders()
    {
        this$0 = w.this;
        super();
    }
}
